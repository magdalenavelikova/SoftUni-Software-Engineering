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

            switch (type) {
                case "Private":
                    double salaryPrivate = Double.parseDouble(tokens[4]);
                    try {
                        soldier = new PrivateImpl(id, firstName, lastName, salaryPrivate);
                        soldiers.add(soldier);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "LieutenantGeneral":
                    double salaryLieutenant = Double.parseDouble(tokens[4]);
                    try {
                        LieutenantGeneralImpl general = new LieutenantGeneralImpl(id, firstName, lastName, salaryLieutenant);
                        if (tokens.length > 4) {
                            addSoldierToList(soldiers, general, tokens);
                        }
                        soldiers.add(general);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                case "Engineer":
                    double salaryEngineer = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salaryEngineer, corps);
                        if (tokens.length > 6) {
                            addToRepairList(engineer, tokens);
                        }
                        soldiers.add(engineer);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;

                case "Commando":
                    double salaryCommando = Double.parseDouble(tokens[4]);
                    String commandoCorps = tokens[5];
                    CommandoImpl commando = null;
                    try {
                        commando = new CommandoImpl(id, firstName, lastName, salaryCommando, commandoCorps);
                        if (tokens.length > 6) {
                            addMission(commando, tokens);
                        }
                        soldiers.add(commando);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }


                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    try {
                        SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                        soldiers.add(spy);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    break;
                default:
                    throw new IllegalArgumentException("Not a valid Soldier!");
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

    private static void addToRepairList(EngineerImpl engineer, String[] tokens) {
        if (tokens.length > 6) {
            for (int i = 6; i < tokens.length; i += 2) {
                String partName = tokens[i];
                int repairTime = Integer.parseInt(tokens[i + 1]);
                try {
                    Repair repair = new Repair(partName, repairTime);
                    engineer.addRepair(repair);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }


    }

    private static void addMission(CommandoImpl commando, String[] tokens) {

        for (int i = 6; i < tokens.length; i += 2) {
            String missionName = tokens[i];
            String missionState = tokens[i + 1];


            try {
                Mission mission = new Mission(missionName, missionState);
                commando.addMission(mission);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
