package solidLab;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "my-password";

        PasswordHasher passwordHasher = new PasswordHasher(new Sha256Algorithm());

        String hash = passwordHasher.hash(password);

        System.out.println(hash);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String loginInfo = scanner.nextLine();

        while (!passwordHasher.hash(loginInfo).equals(hash)) {
            System.out.print(System.lineSeparator() + "Enter password: ");
            loginInfo = scanner.nextLine();
        }

        System.out.println("Welcome!");

    }

    public static String decodeBase64Hash(String hash, PasswordDecoder passwordDecoder) {
        return passwordDecoder.decode(hash);
    }
}
