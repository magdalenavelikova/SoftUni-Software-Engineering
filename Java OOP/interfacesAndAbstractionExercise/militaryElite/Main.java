package interfacesAndAbstractionExercise.militaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Soldier> soldiers = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            Soldier soldier;
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary = Double.parseDouble(tokens[4]);
            switch (type) {
                case "Private":

                    soldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(soldier);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl general = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    if (tokens.length > 4) {
                        addSoldierToList(soldiers, general, tokens);
                    }
                    soldiers.add(general);
                    break;
                case "Engineer":
                    String corps = tokens[5];
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                    if (tokens.length > 6) {
                        addToRepairList( engineer, tokens);
                    }
                    soldiers.add(engineer);
                    break;

                case "Commando":
                    String commandoCorps = tokens[5];
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, commandoCorps);
                    if (tokens.length > 6) {
                        addMission( commando, tokens);
                    }
                    soldiers.add(commando);
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.add(spy);
                    break;
            }

            input = scanner.nextLine();
        }

        soldiers.stream().forEach(System.out::println);

    }

    private static void addSoldierToList(List<Soldier> soldiers, LieutenantGeneralImpl general, String[] tokens) {

        for (int i = 5; i < tokens.length; i++) {
            int targetId = Integer.parseInt(tokens[i]);
            for (Soldier soldier : soldiers) {
                if (soldier.getId() == targetId) {

                    Private priv = (Private) soldier;
                    general.addPrivate(priv);
                }
            }


        }


    }

    private static void addToRepairList( EngineerImpl engineer, String[] tokens) {
        if (tokens.length > 6) {
            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int repairTime = Integer.parseInt(tokens[i + 1]);
                try {
                    Repair repair = new Repair(partName, repairTime);
                    engineer.addRepair(repair);
                } catch (Exception ex) {

                }
            }
        }


    }

    private static void addMission( CommandoImpl commando, String[] tokens) {

        for (int i = 6; i < tokens.length; i += 2) {
            String missionName = tokens[i];
            String missionState = tokens[i + 1];
            try {
                Mission mission = new Mission(missionName, missionState);
                commando.addMission(mission);
            } catch (Exception ex) {

            }
        }

    }
}
