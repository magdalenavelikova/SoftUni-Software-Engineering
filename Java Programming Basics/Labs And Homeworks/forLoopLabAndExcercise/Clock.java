package forLoopLabAndExcercise;

public class Clock {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        for (int i = 0; i < 24; i++) {

            for (int j = 0; j <=59; j++) {
                if (hours<24) {
                        System.out.printf("%d :", hours);
                        System.out.printf(" %d%n", minutes);
                }
                minutes += 1;
                if (j ==59) {
                    hours += 1;
                    minutes = 0;
                }
            }

        }
    }
}
