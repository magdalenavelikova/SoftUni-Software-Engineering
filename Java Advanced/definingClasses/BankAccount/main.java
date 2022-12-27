package definingClasses;

import java.util.*;
import java.util.function.BiFunction;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        BiFunction<BankAccount, String, String> depositFunction = (b, s) -> {
            double amount = Double.parseDouble(s);
            b.deposit(amount);
            return String.format("Deposited %.0f to ID%d", amount, b.getId());
        };

        BiFunction<BankAccount, String, String> getInterestFunction = (b, s) -> {
            int years = Integer.parseInt(s);

            return String.format("%.2f", b.getInterest(years));
        };

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    System.out.println("Account ID" + bankAccount.getId() + " created");
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    break;
                case "Deposit":
                    String output = executeOnBankAccount(data, bankAccountMap, depositFunction);
                    System.out.println(output);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    String outputGetInterest = executeOnBankAccount(data, bankAccountMap, getInterestFunction);
                    System.out.println(outputGetInterest);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    public static String executeOnBankAccount(String[] data, Map<Integer, BankAccount> bankAccountMap, BiFunction<BankAccount, String, String> function) {
        int id = Integer.parseInt(data[1]);
        BankAccount bankAccount = bankAccountMap.get(id);
        if (bankAccount == null) {
            return "Account does not exist";
        }
        return function.apply(bankAccount, data[2]);


    }
}
