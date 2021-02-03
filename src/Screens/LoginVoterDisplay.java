package Screens;

import Voter_Info.Voter_Count;

import java.util.Scanner;

public class LoginVoterDisplay {
    public static void display(){
        Scanner s = new Scanner(System.in);
            String voterID;
            String name;

         if(Voter_Count.list.isEmpty()){
             System.out.println();
             System.out.println("<------------------------------- NO VOTERS ADDED  ----------------------------->");
             return;
         }


        int flagID = 0;
        int flagName = 0;
        int count = 0;
        int attempts = 0;

         do{
             attempts++;
             flagID = 0;
             flagName = 0;
             System.out.println();
             System.out.println("<============================== VOTER LOGIN PAGE ============================>");
             System.out.println("<=============================  ("+" ATTEMPT "+(attempts)+" )  ============================>");
             System.out.println();
             System.out.println("Enter Your Name: ");
             name = s.nextLine();
             name = name.trim();
             System.out.println();
             System.out.println("Enter Your Voter ID: ");
             voterID = s.nextLine();
             voterID = voterID.trim();
             System.out.println("_______________________________________________");
             System.out.println();

             for(int i = 0; i< Voter_Count.list.size(); i++,count++){
                 if (Voter_Count.list.get(i).getName().equals(name)
                         && Voter_Count.list.get(i).getVoter_id().equals(voterID)){
                     System.out.println();
                     System.out.println("<--------------------------- SUCCESSFULLY LOGGED IN ----------------------->");
                     VotingScreenDisplay.display(Voter_Count.list.get(i));
                     return;
                 }

                 if(Voter_Count.list.get(i).getName().equals(name)){
                     flagName = 1;
                 }

                 if(Voter_Count.list.get(i).getVoter_id().equals(voterID)){
                     flagID = 1;
                 }
             }


             if(flagID==0 && flagName==0 && attempts!=3 ){
                 System.out.println("<-------------------------- INVALID ENTRY!! TRY AGAIN ---------------------------->");
             } else if(flagID==1 && flagName==0){
                 System.out.println();
                 System.out.println("<-------------------------- NAME MISMATCH ERROR!! ---------------------------->");
             } else if(flagName==1 && flagID==0){
                 System.out.println();
                 System.out.println("<----------------------- VOTER ID MISMATCH ERROR!! -------------------------->");
             } else if(attempts!=3){
                 System.out.println();
                 System.out.println("<---------------------------- MATCH NOT FOUND!! ------------------------------>");
             }
         } while(attempts!=3);


            System.out.println();
            System.out.println("<-------------------------- VOTER DOES NOT EXIST  ---------------------------->");


    }
}
