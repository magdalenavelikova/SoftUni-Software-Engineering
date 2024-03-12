package algorithms;

import java.util.Arrays;

public class Candy {
    //There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
    //
    //You are giving candies to these children subjected to the following requirements:
    //
    //Each child must have at least one candy.
    //Children with a higher rating get more candies than their neighbors.


    public static void main(String[] args) {
    int[] candies = new int[]{1,2,87,87,87,2,1};
      System.out.println(candy(candies));
   }

    public static int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);


        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
        }
        for (int i = ratings.length-2; i >=0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }

        }



        return  Arrays.stream(candies).sum();

    }
}