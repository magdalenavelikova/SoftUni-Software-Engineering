package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizardsList = getWizardsList(magicians, "Wizard");
        List<Magician> blackWidowsList = getWizardsList(magicians, "BlackWidow");

        while (!wizardsList.isEmpty() && !blackWidowsList.isEmpty()) {
            Magician wizard = wizardsList.get(0);
            Magician blackWidow = blackWidowsList.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if(blackWidow.isAlive()){
                wizard.takeDamage(blackWidow.getMagic().fire());
                if (!wizard.isAlive()){
                    wizardsList.remove(wizard);
                }
            }else {
                blackWidowsList.remove(blackWidow);
            }
        }


        String output = "";
        if (wizardsList.isEmpty()) {
            output = "Black widows win!";
        } else if (blackWidowsList.isEmpty()) {
            output = "Wizards win!";
        }
        return output;
    }

    private static List<Magician> getWizardsList(Collection<Magician> magicians, String Wizard) {
        return magicians.stream()
                .filter(m -> m.getClass().getSimpleName().equals(Wizard)
                        && m.isAlive())
                .collect(Collectors.toList());
    }
}
