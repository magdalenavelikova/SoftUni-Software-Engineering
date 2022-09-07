package While;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String studentName = scanner.nextLine();
        int poorGradecount = 1;
        int count = 1;
        double average = 0;
        boolean isSheExcludet = false;
        while (count <= 12) {
            if (poorGradecount > 2) {
                isSheExcludet = true;
                break;
            }
            double mark = Double.parseDouble(scanner.nextLine());
            if (mark < 4) {

                poorGradecount++;
                continue;
            }
            average += mark;
            count++;

        }
if (isSheExcludet){
    System.out.printf("%s has been excluded at %d grade",studentName,count);
}else {
    System.out.printf("%s graduated. Average grade: %.2f", studentName, average / 12);
}
    }
}
