package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.Arrays.stream;
import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_JSON;

@Service
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    private final ModelMapper mapper;

    public AgentServiceImpl(AgentRepository agentRepository,
                            TownRepository townRepository,
                            Gson gson,
                            ValidationUtil validationUtil, ModelMapper mapper) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() != 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(RESOURCES_FILE_PATH_JSON + "agents.json"));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        if (agentRepository.count() == 0) {
            stream(this.gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class))
                    .filter(agentSeedDto -> {
                                boolean isValid = validationUtil.isValid(agentSeedDto);
                                boolean isUnique = agentRepository.findFirstByFirstName(agentSeedDto.getFirstName()).isEmpty();
                                boolean isValidTown =
                                        townRepository.findFirstByTownName(agentSeedDto.getTown())
                                                .isPresent();

                                if (isValid && isUnique && isValidTown) {
                                    stringBuilder.append(String.format("Successfully imported agent - %s %s",
                                            agentSeedDto.getFirstName(), agentSeedDto.getLastName())).append(System.lineSeparator());
                                } else {
                                    stringBuilder.append("Invalid agent").append(System.lineSeparator());
                                }
                                return (isValid && isUnique && isValidTown);
                            }
                    )
                    .map(agentSeedDto -> {
                        Agent agent = mapper.map(agentSeedDto, Agent.class);
                        agent.setTown(townRepository.findFirstByTownName(
                                        agentSeedDto.getTown())
                                .get());
                        return agent;
                    })
                    .forEach(agentRepository::save);
        }
        return stringBuilder.toString().trim();
    }
}

