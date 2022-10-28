package preExam13082022;

import java.util.Scanner;

public class SumAndProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isConditionAchieved = false;
        for (int a = 1; a <= 9; a++) {
            for (int b = 9; b >= a; b--) {
                for (int c = 0; c <= 9; c++) {
                    for (int d = 9; d >= c; d--) {
                        String number = "" + a + "" + b + "" + c + "" + d;
                        if (((a + b + c + d) == (a * b * c * d)) && (n % 10 == 5)) {
                            isConditionAchieved = true;
                            System.out.println(number);
                            break;
                        }
                        if (((a * b * c * d) / (a + b + c + d) == 3) && (n % 3 == 0)) {
                            isConditionAchieved = true;
                            number = "" + d + "" + c + "" + b + "" + a;
                            System.out.println(number);
                            break;
                        }

                    }
                    if (isConditionAchieved) {
                        break;
                    }

                }
                if (isConditionAchieved) {
                    break;
                }

            }
            if (isConditionAchieved) {
                break;
            }

        }
        if (!isConditionAchieved) {
            System.out.println("Nothing found");
        }
    }
}
