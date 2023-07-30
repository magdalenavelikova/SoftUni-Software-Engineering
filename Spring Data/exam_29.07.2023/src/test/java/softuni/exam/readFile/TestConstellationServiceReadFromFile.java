package softuni.exam.readFile;
//TestConstellationServiceReadFromFile

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.ConstellationServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestConstellationServiceReadFromFile {

    @InjectMocks
    private ConstellationServiceImpl constellationService;

    @Test
    void readConstellationsFromFile() throws IOException {

        String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"Andromeda\",\n" +
                "    \"description\": \"A princess chained to a rock, saved by Perseus.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Nebulosus Equinoxalis\",\n" +
                "    \"description\": \"A scorpion with a prominent stinger.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Centaurus\",\n" +
                "    \"description\": \"A half-human, half-horse creature wielding a spear.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cassiopeia\",\n" +
                "    \"description\": \"Queen punished for her vanity by being forced to sit on a throne.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cassiopeia\",\n" +
                "    \"description\": \"Description punished for her vanity by being forced to sit onX a throne.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"As\",\n" +
                "    \"description\": \"A maiden holding wheat or a sheaf of wheat.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Cepheus\",\n" +
                "    \"description\": \"King and husband of Cassiopeia.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Wrongeus\",\n" +
                "    \"description\": \"Bad\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Aquila\",\n" +
                "    \"description\": \"The eagle carrying Zeus's thunderbolts.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Draco\",\n" +
                "    \"description\": \"A dragon guarding the North Pole.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Hydra\",\n" +
                "    \"description\": \"A multi-headed serpent-like creature.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Lyra\",\n" +
                "    \"description\": \"The lyre of the mythical musician Orpheus.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Orion\",\n" +
                "    \"description\": \"A mighty hunter wielding a club and a bow.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Pegasus\",\n" +
                "    \"description\": \"A winged horse.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Perseus\",\n" +
                "    \"description\": \"A hero who slayed Medusa and saved Andromeda.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Sagitta\",\n" +
                "    \"description\": \"The arrow used by Hercules.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Sagittarius\",\n" +
                "    \"description\": \"An archer aiming his bow at the heart of Scorpius.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Scorpius\",\n" +
                "    \"description\": \"A scorpion with a prominent stinger.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Taurus\",\n" +
                "    \"description\": \"The bull from Greek mythology.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Ursa Major\",\n" +
                "    \"description\": \"The Great Bear, containing the Big Dipper asterism.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Ursa Minor\",\n" +
                "    \"description\": \"The Little Bear, containing the North Star.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Virgo\",\n" +
                "    \"description\": \"A maiden holding wheat or a sheaf of wheat.\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"Vulpecula\",\n" +
                "    \"description\": \"A fox carrying a goose in its jaws.\"\n" +
                "  }\n" +
                "]";

        String actual = constellationService.readConstellationsFromFile();

        Assertions.assertEquals(expected, actual);
    }
}