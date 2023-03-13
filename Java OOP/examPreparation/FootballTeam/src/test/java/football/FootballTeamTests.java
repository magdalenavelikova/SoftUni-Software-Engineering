package football;



import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FootballTeamTests {
    private Footballer footballer;
    private FootballTeam footballTeam;
    private List<Footballer> footballerList;

    @Before
    public void prepare() {

        footballerList = List.of(
                new Footballer("Alex"),
                new Footballer("Ivan"),
                new Footballer("Phillip")
        );
        footballTeam = new FootballTeam("Levski", 3);
        footballerList.forEach(f -> footballTeam.addFootballer(f));
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowExWhenNameIsEmptySting() {
        String name = "";
        footballTeam = new FootballTeam(name, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldThrowExWhenNameIsNull() {
        String name = null;
        footballTeam = new FootballTeam(name, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowExWhenVacantPositionIsNegativeNumber() {
        int vacantPosition = -1;
        footballTeam = new FootballTeam("Levski", vacantPosition);
    }

    @Test
    public void testGetNameShouldReturnFootballTeamName() {
        assertEquals("Levski", footballTeam.getName());
    }

    @Test
    public void testGetVacantPositionsShouldReturnPositions() {
        assertEquals(3, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerShouldThrowExWhenVacantPositionIsFull() {
        footballTeam.addFootballer(new Footballer("Stefan"));
    }

    @Test
    public void testGetCountShouldReturnSizeOfList() {
        assertEquals(footballerList.size(), footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerShouldThrowExWhenThereIsNoSuchFootballer() {
        footballTeam.removeFootballer("Me");
    }

    @Test
    public void testRemoveFootballerShouldRemoveFootballer() {
        footballTeam.removeFootballer("Alex");
        assertEquals(footballerList.size()-1, footballTeam.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrowExWhenThereIsNoSuchFootballer() {
        footballTeam.footballerForSale("Me");
    }

    @Test
    public void testFootballerForSaleShouldReturnFootballer() {
       Footballer expected=footballerList.get(0);
        Footballer actual = footballTeam.footballerForSale("Alex");
       assertFalse(actual.isActive());
        assertEquals(expected.getName(),actual.getName());
    }
    @Test
    public void testGetStatistic(){
        String output = footballerList.stream()
                .map(Footballer::getName)
                .collect(Collectors.joining(", "));
        String expected = String.format("The footballer %s is in the team %s.", output, footballTeam.getName());

        String actual=footballTeam.getStatistics();
        assertEquals(expected,actual);
    }

}
