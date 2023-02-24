package interfacesAndAbstractionExercise.telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private boolean isValidURL(String url) {

        for (char singleChar : url.toCharArray()) {
            if (Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : urls) {
            if (isValidURL(url)) {
                output.append(String.format("Invalid URL!%n"));
            } else {
                output.append(String.format("Browsing: %s!%n", url));
            }
        }
        //output.deleteCharAt(output.length() - 1);
        return output.toString().trim();
    }

    private boolean isValidPhoneNumber(String number) {

        for (char singleChar : number.toCharArray()) {
            if (!Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : numbers) {
            if (isValidPhoneNumber(number)) {
                output.append(String.format("Invalid number!%n"));
            } else {
                output.append(String.format("Calling... %s%n", number));
            }
        }
      //  output.deleteCharAt(output.length() - 1);
        return output.toString().trim();
    }
}
