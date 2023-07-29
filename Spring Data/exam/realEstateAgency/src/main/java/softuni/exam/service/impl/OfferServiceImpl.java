package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferWrapperDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.constans.GlobalConstants.RESOURCES_FILE_PATH_XML;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private static String OFFERS_FILE_PATH = RESOURCES_FILE_PATH_XML + "offers.xml";
    private final ModelMapper mapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelMapper mapper,
                            XmlParser xmlParser,
                            ValidationUtil validationUtil,
                            AgentRepository agentRepository, ApartmentRepository apartmentRepository) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.agentRepository = agentRepository;

        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public boolean areImported() {

        return offerRepository.count() != 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder stringBuilder = new StringBuilder();
        if (offerRepository.count() == 0) {
            xmlParser
                    .fromFile(OFFERS_FILE_PATH, OfferWrapperDto.class)
                    .getOffers().stream()
                    .filter(offerSeedDto -> {
                                {
                                    boolean isValid = validationUtil.isValid(offerSeedDto);

                                    boolean isValidAgent =
                                            agentRepository.findFirstByFirstName(offerSeedDto.getAgent().getName())
                                                    .isPresent();



                                    if (isValid  && isValidAgent) {
                                        stringBuilder.append(String.format("Successfully imported offer %s",
                                                        offerSeedDto.getPrice()))
                                                .append(System.lineSeparator());
                                    } else {
                                        stringBuilder.append("Invalid offer").append(System.lineSeparator());
                                    }
                                    return (isValid  && isValidAgent);
                                }
                            }
                    )
                    .map(offerSeedDto -> {
                                Offer offer = mapper.map(offerSeedDto, Offer.class);
                                offer.setAgent(agentRepository
                                        .findFirstByFirstName(
                                                offerSeedDto
                                                        .getAgent().getName())
                                        .get());
                                offer.setApartment(apartmentRepository.findById(offerSeedDto.getApartment().getId()).get());
                                return offer;
                            }
                    )
                    .forEach(offerRepository::save);
        }

        return stringBuilder.toString().trim();
    }



    @Override
    public String exportOffers() {


        StringBuilder sb = new StringBuilder();

        offerRepository.findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType.three_rooms)
                .stream().forEach(offer -> {
            sb.append(String.format("Agent %s %s with offer №%s:",
                   offer.getAgent().getFirstName(),
                    offer.getAgent().getLastName(),
                   offer.getId())).append(System.lineSeparator());
            sb.append(String.format("  -Apartment area: %.2f",
                   offer.getApartment().getArea())).append(System.lineSeparator());
            sb.append(String.format("  --Town: %s",
                   offer.getApartment().getTown().getTownName())).append(System.lineSeparator());
            sb.append(String.format("  ---Price: %s$",
                    offer.getPrice().setScale(2))).append(System.lineSeparator());


        });
        return sb.toString().trim();
    }

}
