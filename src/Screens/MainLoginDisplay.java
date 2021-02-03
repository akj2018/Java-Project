package Screens;

import Election_Commisioner.EC;
import Election_Commisioner.EC_Functions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLoginDisplay {
    public static void loginPage() throws Exception {
        int choice = 0;

        EC_Functions electionCommissioner = new EC();

        do{
            Scanner s = new Scanner(System.in);
            System.out.println();
            System.out.println("_________________________________\uD835\uDC16\uD835\uDC04\uD835\uDC0B\uD835\uDC02\uD835\uDC0E\uD835\uDC0C\uD835\uDC04 \uD835\uDC13\uD835\uDC0E \uD835\uDC04\uD835\uDC0B\u200B\uD835\uDC04\uD835\uDC02\uD835\uDC13\uD835\uDC11\uD835\uDC0E\uD835\uDC0D\uD835\uDC08\uD835\uDC02 \uD835\uDC15\uD835\uDC0E\uD835\uDC13\uD835\uDC08\uD835\uDC0D\uD835\uDC06 \uD835\uDC12\uD835\uDC18\uD835\uDC12\uD835\uDC13\uD835\uDC04\uD835\uDC0C_____________________________");
            System.out.println();
            System.out.println("                                    1. VOTER");
            System.out.println("                                    2. ELECTION COMMISSIONER");
            System.out.println("                                    3. EXIT");
            System.out.println("___________________________________________________________________________________________________");
            System.out.println();
            try{
                System.out.println("Enter Choice: ");
                choice = s.nextInt();
            } catch (InputMismatchException e){
                System.out.println("<--------------------------- Invalid Input!! Try Again --------------------->");
                continue;
            }

            switch (choice){
                case 1:
                    LoginVoterDisplay.display();
                    break;
                case 2:
                    LogicECDisplay.display(electionCommissioner);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("<======================= Thanks For Your Valuable Time =======================>");
                    break;
                default:
                    System.out.println("<---------------------- Invalid Input!! Try Again -------------------------->");
            }
        } while(choice!=3);

    }
}
