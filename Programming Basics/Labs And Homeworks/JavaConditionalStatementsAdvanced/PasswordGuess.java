package JavaConditionalStatementsAdvanced;

import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String password= scanner.nextLine();
        String realPassword="s3cr3t!P@ssw0rd";
                if(password.equals(realPassword)){
                    System.out.println("Welcome");
                }else{
                    System.out.println("Wrong password!");
                }
    }
}
