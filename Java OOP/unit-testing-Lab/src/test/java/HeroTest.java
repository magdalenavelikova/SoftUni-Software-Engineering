
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {


    @Test
    public void testHeroAttackWhenTargetDiesGetsExp() {
        int exp = 10;
        Target facade = mock(Target.class);
        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(exp);

        Weapon weapon = mock(Axe.class);

        Hero hero = new Hero("Ivan", weapon);

        hero.attack(facade);
        assertEquals(exp, hero.getExperience());

    }
}