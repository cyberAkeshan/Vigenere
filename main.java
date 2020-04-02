/**
 * main.
 *
 * @author Akeshan
 * @version 1.04.2020
 */

import java.util.Scanner;

public class main
{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to...");
        System.out.println("(1)ENCRYPT?");
        System.out.println("(2)DECRYPT?");
        Encryption encry  = new Encryption();
        Decryption decry = new Decryption();

        switch(scanner.nextInt()){
            case 1 : encry.encrypt();
                System.out.println("Do you wanna decrypt something?");
                System.out.println("(1)YES");
                System.out.println("(2)NO");
                switch (scanner.nextInt()){
                    case 1: decry.decrypt(); break;
                    case 2: System.out.println("Ok, see you later."); break;
                }

                break;

            case 2 : decry.decrypt();
                System.out.println("Do you wanna encrypt something?");
                System.out.println("(1)YES");
                System.out.println("(2)NO");
                switch (scanner.nextInt()){
                    case 1: encry.encrypt(); break;
                    case 2: System.out.println("Ok, see you later."); break;
                }

                break;

            default: System.out.println("Please enter a valid number!");
        }

    }
}
