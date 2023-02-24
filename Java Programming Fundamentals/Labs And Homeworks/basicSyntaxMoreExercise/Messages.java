package basicSyntaxMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        while (lines > 0) {
            String input= scanner.nextLine();
            int keyboardNumber=Integer.parseInt(""+input.charAt(0));
            String charSet="";
            switch (keyboardNumber){
                case 2:
                    charSet="abc";
                    break;
                case 3:
                    charSet="def";
                    break;
                case 4:
                    charSet="ghi";
                    break;
                case 5:
                    charSet="jkl";
                    break;
                case 6:
                    charSet="mno";
                    break;
                case 7:
                    charSet="pqrs";
                    break;
                case 8:
                    charSet="tuv";
                    break;
                case 9:
                    charSet="wxyz";
                    break;
                case 0:
                    charSet=" ";
                    break;
            }
            System.out.print(charSet.charAt(input.length()-1));


            lines--;
        }

    }
}
