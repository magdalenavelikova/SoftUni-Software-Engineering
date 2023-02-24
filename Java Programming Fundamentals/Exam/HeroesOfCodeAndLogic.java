package exam;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            String heroName = input.split("\\s+")[0];
            int hp = Integer.parseInt(input.split("\\s+")[1]);
            int mp = Integer.parseInt(input.split("\\s+")[2]);

            heroesMap.putIfAbsent(heroName, new ArrayList<>());
            heroesMap.get(heroName).add(hp);
            heroesMap.get(heroName).add(mp);

        }
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
            String command = commandLine.split(" \\- ")[0];
            String heroName = commandLine.split(" \\- ")[1];
            int currentHP = heroesMap.get(heroName).get(0);
            int currentMP = heroesMap.get(heroName).get(1);
            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commandLine.split(" \\- ")[2]);
                    String spellName = commandLine.split(" \\- ")[3];
                    if (currentMP >= neededMP) {
                        currentMP -= neededMP;
                        heroesMap.get(heroName).set(1, currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, currentMP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandLine.split(" \\- ")[2]);
                    String attacker = commandLine.split(" \\- ")[3];

                    if (currentHP - damage > 0) {
                        currentHP -= damage;
                        heroesMap.get(heroName).set(0, currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    } else {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandLine.split(" \\- ")[2]);
                    if (currentMP + amount > 200) {
                        amount = 200 - currentMP;
                        currentMP = 200;
                    } else {
                        currentMP += amount;
                    }
                    heroesMap.get(heroName).set(1, currentMP);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    int amountForHP = Integer.parseInt(commandLine.split(" \\- ")[2]);
                    if (currentHP + amountForHP > 100) {
                        amountForHP = 100 - currentHP;
                        currentHP = 100;
                    } else {
                        currentHP += amountForHP;
                    }
                    heroesMap.get(heroName).set(0, currentHP);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountForHP);

                    break;


            }
            commandLine = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> hero : heroesMap.entrySet()) {
            System.out.println(hero.getKey());
            System.out.println("  HP: " + hero.getValue().get(0));
            System.out.println("  MP: " + hero.getValue().get(1));

        }

    }
}
