package methodsMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulatorNotWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        String command = inputArray[0];
        int[] numberArray = new int[inputArray.length];
        while (!command.equals("end")) {

            if (command.equals("exchange")) {
                int index = Integer.parseInt(inputArray[1]) + 1;
                if (index > numberArray.length || index < 1) {
                    System.out.println("Invalid index");
                } else if (index < numberArray.length) {
                    int[] resultArray = new int[numberArray.length];
                    for (int j = 0; j < resultArray.length - index; j++) {
                        resultArray[j] = numberArray[index + j];
                    }
                    for (int i = 0; i < index; i++) {
                        resultArray[numberArray.length - index + i] = numberArray[i];
                    }
                    numberArray = resultArray;
                }
            } else if (command.equals("max")) {
                int maxNumber = Integer.MIN_VALUE;
                int maxNumberIndex = -1;
                if (inputArray[1].equals("even")) {
                    for (int i = 0; i < numberArray.length; i++) {
                        if (numberArray[i] % 2 == 0 && numberArray[i] > maxNumber) {
                            maxNumber = numberArray[i];
                            maxNumberIndex = i;
                        }
                    }
                } else {
                    for (int i = 0; i < numberArray.length; i++) {
                        if (!(numberArray[i] % 2 == 0) && numberArray[i] > maxNumber) {
                            maxNumber = numberArray[i];
                            maxNumberIndex = i;
                        }
                    }
                }
                if (maxNumberIndex >= 0) {
                    System.out.println(maxNumberIndex);
                } else {
                    System.out.println("No matches");
                }
            } else if (command.equals("min")) {
                int minNumber = Integer.MAX_VALUE;
                int minNumberIndex = -1;
                if (inputArray[1].equals("even")) {
                    for (int i = 0; i < numberArray.length; i++) {
                        if (numberArray[i] % 2 == 0 && numberArray[i] < minNumber) {
                            minNumber = numberArray[i];
                            minNumberIndex = i;
                        }
                    }
                } else {
                    for (int i = 0; i < numberArray.length; i++) {
                        if (!(numberArray[i] % 2 == 0) && numberArray[i] < minNumber) {
                            minNumber = numberArray[i];
                            minNumberIndex = i;
                        }
                    }

                }
                if (minNumberIndex >= 0) {
                    System.out.println(minNumberIndex);
                } else {
                    System.out.println("No matches");
                }
            } else if (command.equals("first")) {
                int count = Integer.parseInt(inputArray[1]);
                if (count <= numberArray.length && count>0) {
                    int[] countedNumbers = new int[count];
                    int counterForValid = 0;
                    if (inputArray[2].equals("even")) {

                        for (int i = 0; i < numberArray.length; i++) {
                            if (numberArray[i] % 2 == 0 && counterForValid < count) {
                                countedNumbers[counterForValid] = numberArray[i];
                                counterForValid++;
                            }
                        }
                    } else {
                        for (int i = 0; i < numberArray.length; i++) {
                            if (!(numberArray[i] % 2 == 0) && counterForValid < count) {
                                countedNumbers[counterForValid] = numberArray[i];
                                counterForValid++;
                            }
                        }
                    }
                    if (counterForValid == 0) {
                        String output = "[]";
                        System.out.println(output);
                    } else if (counterForValid < count) {
                        String output = "[";
                        for (int i = 0; i < counterForValid - 1; i++) {
                            output += countedNumbers[i] + ", ";
                        }
                        output += countedNumbers[counterForValid - 1] + "]";
                        System.out.println(output);
                    } else if (counterForValid == count) {
                        String output = "[";
                        for (int i = 0; i < countedNumbers.length - 1; i++) {
                            output += countedNumbers[i] + ", ";
                        }
                        output += countedNumbers[countedNumbers.length - 1] + "]";
                        System.out.println(output);
                    }

                } else {
                    System.out.println("Invalid count");
                }

            } else if (command.equals("last")) {
                int count = Integer.parseInt(inputArray[1]);
                if (count <= numberArray.length && count > 0) {
                    int[] countedNumbers = new int[count];
                    int counterForValid = 0;
                    if (inputArray[2].equals("even")) {

                        for (int i = numberArray.length - 1; i >= 0; i--) {
                            if (numberArray[i] % 2 == 0 && counterForValid < count) {
                                countedNumbers[counterForValid] = numberArray[i];
                                counterForValid++;
                            }
                        }

                    } else {
                        for (int i = numberArray.length - 1; i >= 0; i--) {
                            if (!(numberArray[i] % 2 == 0) && counterForValid < count) {
                                countedNumbers[counterForValid] = numberArray[i];
                                counterForValid++;
                            }
                        }
                    }

                    int[] tempArray = new int[count-1];
                    for (int i = counterForValid-1; i >=0; i--) {
                       tempArray[(i-(counterForValid))+1] = countedNumbers[i];

                    }
                    countedNumbers = tempArray;

                    if (counterForValid == 0) {
                        String output = "[]";
                        System.out.println(output);
                    } else if (counterForValid < count) {
                        String output = "[";
                        for (int i = 0; i < counterForValid - 1; i++) {
                            output += countedNumbers[i] + ", ";
                        }
                        output += countedNumbers[counterForValid - 1] + "]";
                        System.out.println(output);
                    } else if (counterForValid == count) {
                        String output = "[";
                        for (int i = 0; i < countedNumbers.length - 1; i++) {
                            output += countedNumbers[i] + ", ";
                        }
                        output += countedNumbers[countedNumbers.length - 1] + "]";
                        System.out.println(output);
                    }

                } else {
                    System.out.println("Invalid count");
                }

            } else {
                numberArray = Arrays
                        .stream(inputArray)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            inputArray = scanner.nextLine().split(" ");
            command = inputArray[0];
        }
        String output = "[";
        for (int i = 0; i < numberArray.length - 1; i++) {
            output += numberArray[i] + ", ";
        }
        output += numberArray[numberArray.length - 1] + "]";
        System.out.println(output);
    }
}
