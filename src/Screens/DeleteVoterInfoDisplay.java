package Screens;

import Voter_Info.*;

import java.util.Scanner;

public class DeleteVoterInfoDisplay {
    public static void display() {
        Scanner s = new Scanner(System.in);
        String name;
        String voterID;

        if(Voter_Count.list.isEmpty()){
            System.out.println();
            System.out.println("<---------------------- NO VOTERS ADDED ---------------------->");
            return;
        }

        System.out.println();
        System.out.println("__________DELETION OF VOTER__________");
        System.out.println("Enter Voter's Name: ");
        name = s.nextLine();
        name = name.trim();
        System.out.println();
        System.out.println("Enter Voter ID: ");
        voterID = s.nextLine();
        voterID = voterID.trim();

        int flag = 0;
        for(int i=0;i<Voter_Count.list.size();i++){
            if (Voter_Count.list.get(i).getName().equals(name)
                    && Voter_Count.list.get(i).getVoter_id().equals(voterID)){
                Voter_Count.list.remove(i);
                flag = 1;
                System.out.println();
                System.out.println("<------------ VOTER DELETED ---------->");
                break;
            } else if(Voter_Count.list.get(i).getName().equals(name)){
                System.out.println();
                System.out.println("<----- VOTER ID MISMATCH ERROR!! ----->");
                flag = 1;
            } else if(Voter_Count.list.get(i).getVoter_id().equals(voterID)){
                System.out.println();
                System.out.println("<------ NAME MISMATCH ERROR!! ------>");
                flag = 1;
            }
        }

        if(flag==0){
            System.out.println();
            System.out.println("<------- VOTER DOES NOT EXIST  ------>");
        }

    }
}
