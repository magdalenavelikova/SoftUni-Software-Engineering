package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfCoins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));
        Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
        try {
            usedCoins = chooseCoins(coins, targetSum);

        } catch (IllegalStateException e) {
            System.out.println("Error");
        }


        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        int index = coins.length - 1;
        Map<Integer, Integer> used = new LinkedHashMap<>();
        int countOfCoins;
        while (targetSum != 0 && index >= 0) {
            int coinsToTake = coins[index--];
            countOfCoins = targetSum / coinsToTake;
            targetSum = targetSum % coinsToTake;
            if (countOfCoins != 0) {
                used.put(coinsToTake, countOfCoins);
            }
        }
        if (targetSum != 0) {
            throw new IllegalStateException("Error");
        }
        return used;
    }
}
