package Screens;

import Election_Commisioner.EC;
import Election_Commisioner.EC_Functions;
import Election_Commisioner.EC_PasswordException;
import Election_Commisioner.EC_UsernameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LogicECDisplay {
    public static void display(EC_Functions electionCommissioner) {

        String usernname = "";
        String password = "";

        Scanner s = new Scanner(System.in);

        int flag = 0;
        int count =0;
        do{
            System.out.println();
            System.out.println("<================================= VALIDATION OF EC ================================>");
            System.out.println("<===================================  (Attempt "+(count+1)+")  =================================>");
            System.out.println();
            System.out.println("Enter Username: ");
            usernname = s.nextLine();
            System.out.println();
            System.out.println("Enter Password: ");
            password = s.nextLine();

            try{
                electionCommissioner.check_username(usernname);
                electionCommissioner.check_password(password);
                flag = 0;
            } catch (EC_UsernameException e1){
                System.out.println();
                System.out.println(e1);
                flag = 1;
                count++;

            } catch (EC_PasswordException e2){
                System.out.println();
                System.out.println(e2);
                flag = 1;
                count++;
            }
        } while(flag!=0 && count!=3);

        if(count==3){
            System.out.println();
            System.out.println("<---------------------------- MAX LOGIN LIMIT REACHED ---------------------------------->");
            return;
        }

        System.out.println("[_____________________________VALIDATION SUCCESSFUL_____________________________________]");
        int choice = 0;

        do{
            System.out.println();
            System.out.println("<++++++++++++++++++++++++++++++ ELECTION COMMISSIONER ++++++++++++++++++++++++++++++>");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("                   1. ADD VOTER");
            System.out.println("                   2. DELETE VOTER");
            System.out.println("                   3. ELECTION RESULT");
            System.out.println("                   4. BACK");
            System.out.println("_____________________________________________________________________________________");

            System.out.println("  Enter Your Choice: ");
            try{
                choice = s.nextInt();
            } catch (InputMismatchException e){
                System.out.println("<--------------------------- Invalid Input ! Try Again --------------------->");
                s.nextLine();
                continue;
            }


            switch (choice){
                case 1:
                    electionCommissioner.add_voter();
                    break;
                case 2:
                    electionCommissioner.delete_voter();
                    break;
                case 3:
                    electionCommissioner.result();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("             !!!Invalid Input!! Please Try Again          ");
            }

        } while(choice!=4);
    }
}
