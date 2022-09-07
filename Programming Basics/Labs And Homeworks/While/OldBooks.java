package While;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String book = scanner.nextLine();
        String bookForSearch = scanner.nextLine();
        boolean isFound = false;
        int count = 0;
        while (!bookForSearch.equals("No More Books")) {

            if (book.equals(bookForSearch)) {
                isFound = true;
                break;

            }
            count++;
            bookForSearch = scanner.nextLine();
        }
        if (isFound) {
            System.out.printf("You checked %d books and found it.", count);
        } else {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", count);
        }
    }
}
