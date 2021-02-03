package Screens;

import Election_Commisioner.*;

public class ResultDisplay {
    public static void dislayResult(){
        int max_votes = 0;
        System.out.println("*****************************  ELECTION RESULTS  ****************************");
        System.out.println("__________________________________________________________________________");
        for (int i = 0; i <EC.parties.length ; i++) {
            System.out.println();
            System.out.println("<------- PARTY "+(i+1)+"-------->");
            System.out.println("Party Name: "+EC.parties[i].partyName);
            System.out.println("Party ID: "+EC.parties[i].partyID);
            System.out.println("Party Leader: "+EC.parties[i].partyLeader);
            System.out.println("Party Voters: "+EC.parties[i].votes);
            System.out.println("<--------------------------->");
            if(EC.parties[i].votes>max_votes){
                max_votes = EC.parties[i].votes;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("(__________________________________WINNING PARTY______________________________)");

        int count = 1;
        for (int i = 0; i <EC.parties.length ; i++) {
            if(EC.parties[i].votes==max_votes){
                System.out.println();
                System.out.println("                                  "+count+". "+EC.parties[i].partyName);
                count++;
            }
        }
    }

}
