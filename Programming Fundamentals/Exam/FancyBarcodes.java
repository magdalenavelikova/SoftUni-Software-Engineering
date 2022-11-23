package exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(@[#]+)(?<barcodes>[A-Z][A-Za-z0-9]{4,}[A-Z])(@[#]+)";
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String barcode = matcher.group("barcodes");
                StringBuilder productGroup = new StringBuilder();
                for (int j = 0; j < barcode.length(); j++) {
                    if (Character.isDigit(barcode.charAt(j))) {
                        productGroup.append(barcode.charAt(j));
                    }
                }
                if (productGroup.length()==0) {
                    System.out.println("Product group: 00");

                } else {
                    System.out.printf("Product group: %s%n", productGroup);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
