package solidLab.p05_DependencyInversion.p01_HelloWord;

import java.time.LocalDateTime;

public class HelloWorld {
    public String greeting(String name) {
        if (LocalDateTime.now().getHour()< 12) {
            return "Good morning, " + name;
        }

        if (LocalDateTime.now().getHour() < 18) {
            return "Good afternoon, " + name;
        }

        return "Good evening, " + name;
    }
}
