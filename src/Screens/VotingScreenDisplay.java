package Screens;

import java.util.Scanner;
import java.util.regex.*;
import Election_Commisioner.*;
import Voter_Info.Voter;

public class VotingScreenDisplay {
    public static void display(Voter v){

        String voterParty = v.getVote_party();
        if (!voterParty.equals("")){
            System.out.println("(_______________________________ ALREADY VOTED _______________________________)");
            return;
        }

        Scanner s = new Scanner(System.in);

        String partID;

        int flag = 0;
        do{
            System.out.println();
            System.out.println("<=============================== VOTING PAGE ===================================>");
            System.out.println("<------------------------------------------------------------------------------->");
            System.out.println("      PARTY ID         |          PARTY NAME          |       PARTY LEADER       ");
            System.out.println("_______________________|______________________________|___________________________");
            System.out.println();
            for(int i=0;i<EC.parties.length;i++){
                System.out.println("         "+EC.parties[i].partyID+"          "+"|"
                        +"             "+EC.parties[i].partyName+"              "+"|"
                        +"         "+EC.parties[i].partyLeader);
            }
            System.out.println("___________________________________________________________________________________ ");
            System.out.println("Enter Party ID To Vote For: ");
            partID = s.nextLine();

            String regex1 = "[^0-9]";
            Pattern p1 = Pattern.compile(regex1);
            String regex2 = "[0-9]{5}";
            Pattern p2 = Pattern.compile(regex2);

            Matcher m1 = p1.matcher(partID.trim().replaceAll("\\s",""));
            Matcher m2 = p2.matcher(partID.trim().replaceAll("\\s",""));

            if(m1.matches()){
                System.out.println();
                System.out.println("<-------- Invalid Party ID!! [Contains Non-Digit Symbols] --------->");
                flag = 0;
                continue;
            }

            if(!m2.matches()){
                System.out.println();
                System.out.println("<-------- Invalid Party ID! [Contains more than 5 digits] --------->");
                System.out.println("<-------- Invalid Party ID! [Does Not Contains Exactly 5 digits] --------->");
                flag = 0;
                continue;
            }

            for(int i=0;i<EC.parties.length;i++){
                if(EC.parties[i].partyID.equals(partID)){
                    EC.parties[i].votes = EC.parties[i].votes + 1;
                    flag = 1;
                    System.out.println();
                    v.setVote_party(partID);
                    System.out.println("<--------------------------- VOTED SUCCESSFULLY ------------------------->");

                }
            }
            if(flag==0){
                System.out.println("<--------------------- Party ID Does Not Matches ------------------------->");
            }

        } while(flag!=1);
    }
}
