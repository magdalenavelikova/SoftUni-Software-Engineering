package forLoopLabAndExcercise;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //На първия ред – периода, за който трябва да направите изчисления. Цяло число в интервала [1 ... 1000]
        //На следващите редове(равни на броят на дните) – броя пациенти, които пристигат за преглед за текущия ден. Цяло число в интервала [0…10 000]
        int period = Integer.parseInt(scanner.nextLine());
        int doctors = 7;
        int countAllPatient = 0;
        int countTreatedPatient = 0;
        int countUntreatedPatient = 0;

        for (int i = 1; i <= period; i++) {
            int patient = Integer.parseInt(scanner.nextLine());
            countAllPatient += patient;
            if (i % 3 == 0) {
                if (countUntreatedPatient > countTreatedPatient) {
                    doctors += 1;
                }
            }
            if (patient <= doctors) {
                countTreatedPatient += patient;
            } else {
                countUntreatedPatient += (patient - doctors);
                countTreatedPatient += doctors;
            }

        }
        System.out.printf("Treated patients: %d.%n", countTreatedPatient);
        System.out.printf("Untreated patients: %d.", countUntreatedPatient);
    }
}
