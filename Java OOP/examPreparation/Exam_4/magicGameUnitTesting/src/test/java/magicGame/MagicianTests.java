package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MagicianTests {
    Magician magician;
    List<Magic> magics;
    Magic magic;

    @Before
    public void setup() {
        magician = new Magician("Magician", 10);
        magic = new Magic("First", 100);
        magician.addMagic(magic);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowException() {
        magician = new Magician("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldThrowException() {
        magician = new Magician("Test", -1);
    }

    @Test
    public void testConstructorShouldCreateMagician() {
        magician = new Magician("First", 10);
    }

    @Test
    public void testAddMagicShouldAdd() {
        magician.addMagic(magic);
        Assert.assertEquals("First", magician.getMagic(magic.getName()).getName());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicShouldThrowEx() {
        Magic nullMagic = null;
        magician.addMagic(nullMagic);
    }

    @Test
    public void testGetUsername() {
        String actual = magician.getUsername();
        Assert.assertEquals("Magician",actual);
    }
    @Test
    public void testGetHealth() {
        int actual = magician.getHealth();
        Assert.assertEquals(10,actual);
    }


    @Test
    public void testGetMagicShouldReturnNull(){
        Magic actual = magician.getMagic("Unexist");
        Assert.assertEquals(null,actual);
    }
    @Test
    public void testRemoveMagicShouldReturnFalse(){
        Magic newMagic=new Magic("test",20);
        boolean actual = magician.removeMagic(newMagic);
        Assert.assertFalse(actual);
    }
    @Test
    public void testRemoveMagicShouldReturnTrue(){
               boolean actual = magician.removeMagic(magic);
        Assert.assertTrue(actual);
    }
    @Test(expected = Exception.class)
    public void testGetMagicsShouldReturnUnmodifiableCollection(){
         magician.getMagics().add(magic);
    }
    @Test
    public void testGetMagicsShouldReturnCollection(){
        int actual = magician.getMagics().size();
        Assert.assertEquals(1,actual);
    }
@Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldThrowEx(){
        Magician dead=new Magician("Dead",0);
        dead.takeDamage(0);
}
    @Test
    public void testTakeDamageShouldDecreaseHealth(){
           magician.takeDamage(5);
        int actual = magician.getHealth();
        Assert.assertEquals(5, actual);
    }
    @Test
    public void testTakeDamageShouldSetHealthToZero(){
        magician.takeDamage(15);
        int actual = magician.getHealth();
        Assert.assertEquals(0, actual);
    }



}
