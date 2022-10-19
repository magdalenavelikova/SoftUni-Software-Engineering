package methodsMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulatorTimeLimit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbersArray =  Arrays
                        .stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String[] inputArray = scanner.nextLine().split(" ");
        String command = inputArray[0];

        while (!command.equals("end")) {
            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(inputArray[1]);
                    if (isValidIndex(numbersArray, index)) {
                        numbersArray=exchangeArray(numbersArray, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "min":
                    String typeForMin=inputArray[1];
                    int minNumberIndex=getMinNumber(numbersArray,typeForMin);
                    if (minNumberIndex >= 0) {
                        System.out.println(minNumberIndex);
                    } else {
                        System.out.println("No matches");
                    }

                    break;
                case "max":
                    String typeForMax=inputArray[1];
                    int maxNumberIndex=getMaxNumber(numbersArray,typeForMax);
                    if (maxNumberIndex !=-1) {
                        System.out.println(maxNumberIndex);
                    } else {
                        System.out.println("No matches");
                    }
                    break;
                case "first":
                    int firstCountElements = Integer.parseInt(inputArray[1]);

                    if (firstCountElements <= 0 || firstCountElements > numbersArray.length) { // invalid count of elements
                        System.out.println("Invalid count");
                    } else { // valid count of elements
                        String currentFirstType = inputArray[2];

                        if (currentFirstType.equals("even")) {
                            printFirstEvenElements(numbersArray, firstCountElements); // printing the result of the method - either ARRAY or empty brackets []
                        } else if (currentFirstType.equals("odd")) {
                            printFirstOddElements(numbersArray, firstCountElements); // printing the result of the method - either ARRAY or empty brackets []
                        } else {
                            System.out.println("Wrong First Type Elements!");
                        }
                    }
                    break;
                case "last":
                    int lastCountElements = Integer.parseInt(inputArray[1]);

                    if (lastCountElements <= 0 || lastCountElements > numbersArray.length) { // invalid count of elements
                        System.out.println("Invalid count");
                    } else { // valid count of elements
                        String currentLastType = inputArray[2];

                        if (currentLastType.equals("even")) {
                            printLastEvenElements(numbersArray, lastCountElements); // printing the result of the method - either ARRAY or empty brackets []
                        } else if (currentLastType.equals("odd")) {
                            printLastOddElements(numbersArray, lastCountElements); // printing the result of the method - either ARRAY or empty brackets []
                        } else {
                            System.out.println("Wrong Last Type Elements!");
                        }
                    }
                    break;

            }


            inputArray = scanner.nextLine().split(" ");
            command = inputArray[0];
        }
        printArray(numbersArray);

    }
    public static void printLastEvenElements(int[] numbersArray, int count) { // returns the last {count} even elements
        String finalString = "]";
        int countEvenElements = 0;

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            int currentElement = numbersArray[i];

            if (currentElement % 2 == 0) {
                countEvenElements++;
                if (countEvenElements == 1) {
                    finalString = currentElement + finalString;
                } else if (countEvenElements < count) {
                    finalString = currentElement + ", " + finalString;
                } else if (countEvenElements == count) {
                    finalString = currentElement + ", " + finalString;
                    break;
                }
            }
        }

        System.out.println("[" + finalString);
    }

    public static void printLastOddElements(int[] numbersArray, int count) { // returns the last {count} odd elements
        String finalString = "]";
        int countOddElements = 0;

        for (int i = numbersArray.length - 1; i >= 0; i--) {
            int currentElement = numbersArray[i];

            if (currentElement % 2 == 1) {
                countOddElements++;
                if (countOddElements == 1) {
                    finalString = currentElement + finalString;
                } else if (countOddElements < count) {
                    finalString = currentElement + ", " + finalString;
                } else if (countOddElements == count) {
                    finalString = currentElement + ", " + finalString;
                    break;
                }
            }
        }

        System.out.println("[" + finalString);
    }
    public static void printFirstEvenElements(int[] numbersArray, int count) { // returns the first {count} even elements
        String finalString = "[";
        int countEvenElements = 0;

        for (int currentElement : numbersArray) {
            if (currentElement % 2 == 0) {
                countEvenElements++;
                if (1 == countEvenElements) {
                    finalString = finalString + currentElement;
                } else if (countEvenElements < count) {
                    finalString = finalString + ", " + currentElement;
                } else if (countEvenElements == count) {
                    finalString = finalString + ", " + currentElement;
                    break;
                }
            }
        }

        System.out.println(finalString + "]");
    }
    public static void printFirstOddElements(int[] numbersArray, int count) { // returns the first {count} even elements
        String finalString = "[";
        int countOddElements = 0;

        for (int currentElement : numbersArray) {
            if (currentElement % 2 != 0) {
                countOddElements++;
                if (1 == countOddElements) {
                    finalString = finalString + currentElement;
                } else if (countOddElements < count) {
                    finalString = finalString + ", " + currentElement;
                } else if (countOddElements == count) {
                    finalString = finalString + ", " + currentElement;
                    break;
                }
            }
        }

        System.out.println(finalString + "]");
    }

public static int getMaxNumber(int [] numbersArray, String type){
    int maxNumber = Integer.MIN_VALUE;
    int maxNumberIndex = -1;
    if (type.equals("even")) {
        for (int i = 0; i < numbersArray.length; i++) {
            if (numbersArray[i] % 2 == 0 && numbersArray[i] >= maxNumber) {
                maxNumber = numbersArray[i];
                maxNumberIndex = i;
            }
        }
    } else if(type.equals("odd")){
        for (int i = 0; i < numbersArray.length; i++) {
            if (!(numbersArray[i] % 2 == 0) && numbersArray[i] >= maxNumber) {
                maxNumber = numbersArray[i];
                maxNumberIndex = i;
            }
        }
    }
    return maxNumberIndex;
}
    public static int getMinNumber(int [] numbersArray, String type){
        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = -1;
        if (type.equals("even")) {
            for (int i = 0; i < numbersArray.length; i++) {
                if (numbersArray[i] % 2 == 0 && numbersArray[i] <= minNumber) {
                    minNumber = numbersArray[i];
                    minNumberIndex = i;
                }
            }
        } else if(type.equals("odd")){
            for (int i = 0; i < numbersArray.length; i++) {
                if (!(numbersArray[i] % 2 == 0) && numbersArray[i] <= minNumber) {
                    minNumber = numbersArray[i];
                    minNumberIndex = i;
                }
            }
        }
        return minNumberIndex;
    }
    public static int[] exchangeArray(int[] numbersArray, int index) {
        int[] resultArray = new int[numbersArray.length];
        for (int j = 0; j < resultArray.length - (index + 1); j++) {
            resultArray[j] = numbersArray[(index + 1) + j];
        }
        for (int i = 0; i < index + 1; i++) {
            resultArray[numbersArray.length - (index + 1) + i] = numbersArray[i];
        }
        numbersArray = resultArray;
        return numbersArray;

    }

    private static void printArray(int[] array) {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            output.append(array[i]).append(", ");
        }
        output.append(array[array.length - 1]).append("]");
        System.out.println(output);
    }

    private static boolean isValidIndex(int[] array, int index) {
        return (index < array.length && index >= 0);
    }

}
