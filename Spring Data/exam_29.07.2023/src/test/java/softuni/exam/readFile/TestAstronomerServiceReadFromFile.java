package softuni.exam.readFile;
//TestAstronomerServiceReadFromFile

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.exam.service.impl.AstronomerServiceImpl;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TestAstronomerServiceReadFromFile {

    @InjectMocks
    private AstronomerServiceImpl astronomerService;

    @Test
    void readAstronomersFromFile() throws IOException {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<astronomers>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>176858.79</average_observation_hours>\n" +
                "        <birthday>1989-01-01</birthday>\n" +
                "        <first_name>Drake</first_name>\n" +
                "        <last_name>Hawthorne</last_name>\n" +
                "        <salary>207615.71</salary>\n" +
                "        <observing_star_id>50</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>300.79</average_observation_hours>\n" +
                "        <birthday>1989-01-01</birthday>\n" +
                "        <first_name>Drake</first_name>\n" +
                "        <last_name>Hawthorne</last_name>\n" +
                "        <salary>207615.71</salary>\n" +
                "        <observing_star_id>50</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>176858.79</average_observation_hours>\n" +
                "        <birthday>1989-01-01</birthday>\n" +
                "        <first_name>Drake</first_name>\n" +
                "        <last_name>Hawthorne</last_name>\n" +
                "        <salary>207615.71</salary>\n" +
                "        <observing_star_id>50</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>55537.43</average_observation_hours>\n" +
                "        <birthday>1966-11-03</birthday>\n" +
                "        <first_name>Elena</first_name>\n" +
                "        <last_name>Sullivan</last_name>\n" +
                "        <salary>98319.24</salary>\n" +
                "        <observing_star_id>91</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>105443.87</average_observation_hours>\n" +
                "        <birthday>1954-09-02</birthday>\n" +
                "        <first_name>Cassandra</first_name>\n" +
                "        <last_name>Bellamy</last_name>\n" +
                "        <salary>1499.52</salary>\n" +
                "        <observing_star_id>28</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>72795.68</average_observation_hours>\n" +
                "        <birthday>1993-08-14</birthday>\n" +
                "        <first_name>Victor</first_name>\n" +
                "        <last_name>Adams</last_name>\n" +
                "        <salary>316456.16</salary>\n" +
                "        <observing_star_id>42</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>105443.87</average_observation_hours>\n" +
                "        <birthday>1954-09-02</birthday>\n" +
                "        <first_name>Cassandra</first_name>\n" +
                "        <last_name>Bellamy</last_name>\n" +
                "        <salary>111076.52</salary>\n" +
                "        <observing_star_id>28</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>106936.42</average_observation_hours>\n" +
                "        <birthday>1959-06-03</birthday>\n" +
                "        <first_name>Nathaniel</first_name>\n" +
                "        <last_name>Reynolds</last_name>\n" +
                "        <salary>101754.41</salary>\n" +
                "        <observing_star_id>16</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>241603.8</average_observation_hours>\n" +
                "        <birthday>1958-09-04</birthday>\n" +
                "        <first_name>Serena</first_name>\n" +
                "        <last_name>Chandler</last_name>\n" +
                "        <salary>98328.09</salary>\n" +
                "        <observing_star_id>16</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>153446.68</average_observation_hours>\n" +
                "        <birthday>1951-03-10</birthday>\n" +
                "        <first_name>Gabriel</first_name>\n" +
                "        <last_name>Fletcher</last_name>\n" +
                "        <salary>62358.41</salary>\n" +
                "        <observing_star_id>54</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>244764.96</average_observation_hours>\n" +
                "        <birthday>1989-05-24</birthday>\n" +
                "        <first_name>Lorelei</first_name>\n" +
                "        <last_name>Blackwell</last_name>\n" +
                "        <salary>153955.54</salary>\n" +
                "        <observing_star_id>36</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>183403.7</average_observation_hours>\n" +
                "        <birthday>1983-04-12</birthday>\n" +
                "        <first_name>Sebastian</first_name>\n" +
                "        <last_name>Maxwell</last_name>\n" +
                "        <salary>54559.97</salary>\n" +
                "        <observing_star_id>23</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>150617.05</average_observation_hours>\n" +
                "        <birthday>1980-07-26</birthday>\n" +
                "        <first_name>Aurora</first_name>\n" +
                "        <last_name>Hamilton</last_name>\n" +
                "        <salary>211196.44</salary>\n" +
                "        <observing_star_id>74</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>16667.34</average_observation_hours>\n" +
                "        <birthday>1960-01-02</birthday>\n" +
                "        <first_name>Julian</first_name>\n" +
                "        <last_name>Whitaker</last_name>\n" +
                "        <salary>66661.49</salary>\n" +
                "        <observing_star_id>64</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>121317.97</average_observation_hours>\n" +
                "        <birthday>1976-04-03</birthday>\n" +
                "        <first_name>Genevieve</first_name>\n" +
                "        <last_name>Archer</last_name>\n" +
                "        <salary>67686.33</salary>\n" +
                "        <observing_star_id>18</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>148528.89</average_observation_hours>\n" +
                "        <birthday>1958-04-26</birthday>\n" +
                "        <first_name>Elias</first_name>\n" +
                "        <last_name>Donovan</last_name>\n" +
                "        <salary>288559.38</salary>\n" +
                "        <observing_star_id>42</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>55643.78</average_observation_hours>\n" +
                "        <birthday>1986-07-15</birthday>\n" +
                "        <first_name>Isadora</first_name>\n" +
                "        <last_name>Fitzgerald</last_name>\n" +
                "        <salary>334024.69</salary>\n" +
                "        <observing_star_id>64</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>209054.25</average_observation_hours>\n" +
                "        <birthday>1988-05-03</birthday>\n" +
                "        <first_name>Lysander</first_name>\n" +
                "        <last_name>Spencer</last_name>\n" +
                "        <salary>108576.5</salary>\n" +
                "        <observing_star_id>78</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>34635.09</average_observation_hours>\n" +
                "        <birthday>1995-08-14</birthday>\n" +
                "        <first_name>Astrid</first_name>\n" +
                "        <last_name>Webster</last_name>\n" +
                "        <salary>104422.67</salary>\n" +
                "        <observing_star_id>87</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>83542.93</average_observation_hours>\n" +
                "        <birthday>1980-12-10</birthday>\n" +
                "        <first_name>Leander</first_name>\n" +
                "        <last_name>Valentine</last_name>\n" +
                "        <salary>377608.72</salary>\n" +
                "        <observing_star_id>91</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>22836.19</average_observation_hours>\n" +
                "        <birthday>1980-01-16</birthday>\n" +
                "        <first_name>Helena</first_name>\n" +
                "        <last_name>Bishop</last_name>\n" +
                "        <salary>294111.44</salary>\n" +
                "        <observing_star_id>80</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>31049.67</average_observation_hours>\n" +
                "        <birthday>1966-05-05</birthday>\n" +
                "        <first_name>Dorian</first_name>\n" +
                "        <last_name>Sawyer</last_name>\n" +
                "        <salary>161438.11</salary>\n" +
                "        <observing_star_id>77</observing_star_id>\n" +
                "    </astronomer>\n" +
                "    <astronomer>\n" +
                "        <average_observation_hours>20537.9</average_observation_hours>\n" +
                "        <birthday>1957-09-04</birthday>\n" +
                "        <first_name>Vivienne</first_name>\n" +
                "        <last_name>Griffin</last_name>\n" +
                "        <salary>252195.46</salary>\n" +
                "        <observing_star_id>24</observing_star_id>\n" +
                "    </astronomer>\n" +
                "</astronomers>\n";

        String actual = astronomerService.readAstronomersFromFile();

        Assertions.assertEquals(expected, actual);
    }
}