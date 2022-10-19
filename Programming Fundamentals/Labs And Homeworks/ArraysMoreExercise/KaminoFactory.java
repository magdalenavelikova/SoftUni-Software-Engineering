package arraysMoreExercise;

import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String inputLine = scanner.nextLine();
        int bestSequenceIndex = n - 1;
        int bestSequenceSum = 0;
        int bestCountSequence = 0;
        int bestDNASample = 0;
        int[] bestArrDNA = new int[n];
        int countArr = 0;
        while (!inputLine.equals("Clone them!")) {
            countArr++;
            int[] arrDNA = new int[n];
            int sequenceIndex = 0;
            int sequenceSum = 0;
            int countSequence = 0;
            for (int i = 0; i < arrDNA.length; i++) {
                arrDNA[i] = Integer.parseInt(inputLine.split("!+")[i]);
                if (i > 0) {
                    if (arrDNA[i] == arrDNA[i - 1] && arrDNA[i] == 1) {
                        countSequence++;
                        sequenceIndex = i - countSequence;
                    }
                }
                sequenceSum += arrDNA[i];
            }

            if (countSequence > bestCountSequence) {
                bestArrDNA = arrDNA;
                bestCountSequence = countSequence;
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestDNASample = countArr;
            } else if (countSequence == bestCountSequence && sequenceIndex < bestSequenceIndex) {
                bestArrDNA = arrDNA;
                bestCountSequence = countSequence;
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestDNASample = countArr;
            }  else if (countSequence == bestCountSequence && sequenceIndex == bestSequenceIndex && sequenceSum > bestSequenceSum) {
                bestArrDNA = arrDNA;
                bestCountSequence = countSequence;
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestDNASample = countArr;
            }


            inputLine = scanner.nextLine();

        }

            System.out.printf("Best DNA sample %d with sum: %d.%n", bestDNASample, bestSequenceSum);
            for (int item : bestArrDNA) {
                System.out.print(item + " ");
            }

    }
}
