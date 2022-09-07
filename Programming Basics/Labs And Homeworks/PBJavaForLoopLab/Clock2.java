package PBJavaForLoopLab;

public class Clock2 {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        for (int i = 0; i <24; i++) {

            for (int j = 0; j <= 59; j++) {

                for (int k = 0; k <= 59; k++) {

                    if (hours < 24) {
                        System.out.printf("%d :", hours);
                        System.out.printf(" %d :", minutes);
                        System.out.printf(" %d%n", seconds);
                        seconds += 1;
                        if (k == 59) {
                            seconds = 0;
                        }
                    }
                }


                minutes += 1;
                if (j == 59) {
                    hours += 1;
                    minutes = 0;
                }
            }

        }
    }
}
