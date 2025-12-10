import java.util.Scanner;

public class userNameChecker{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        String userName, confUserName;

        System.out.print("Enter User Name : ");
        userName = myScanner.nextLine();

        System.out.print("Confirm User Name : ");
        confUserName = myScanner.nextLine();

        System.out.println("Length 1 : " + userName.length());
        System.out.println("Length 2 : " +  confUserName.length());

        System.out.println("Lengths Match  : " + (confUserName.length() == userName.length()));
        System.out.println("Strings Match: " +  confUserName.equals(userName));

        myScanner.close();
    }
}