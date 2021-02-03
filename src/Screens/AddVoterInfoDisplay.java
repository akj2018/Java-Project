package Screens;

import Voter_Info.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddVoterInfoDisplay {
    public static void display() {

        Scanner s = new Scanner(System.in);

        Voter voter = new Voter();
        Voter_Count.list.add(voter);

        String name;
        int age;
        String gender;
        String voterID;
        String city;
        int f=0;

        int choice = 0;

        do{
            System.out.println();
            System.out.println("______________VOTER INFO_____________");
            System.out.println("           <1> ADD DETAILS");
            System.out.println("           <2> DISPLAY");
            System.out.println("           <3> SUBMIT DATA");
            System.out.println("______________________________________");
            System.out.println();

            try{
                System.out.println("Enter Your Choice: ");
                choice = s.nextInt();
            } catch (InputMismatchException e){
                System.out.println("<-------------------------- Invalid Input!! Try Again ---------------------------->");
                s.nextLine();
                continue;
            }

            s.nextLine();

            switch(choice){
                case 1:
                    do {
                        f = 0;
                        System.out.println("Enter Name: ");
                        name = s.nextLine();
                        try {
                            voter.setName(name);
                        } catch (NameException e) {
                            System.out.println(e);
                            f++;
                        }
                    }while (f>0);

                do {
                    f = 0;
                    System.out.println("Enter Age: ");
                    age = s.nextInt();
                    s.nextLine();
                    try{
                        voter.setAge(age);
                    } catch (AgeException e){
                        System.out.println(e);
                        f++;
                    }
                }while (f>0);


                do {
                        f = 0;
                    System.out.println("Enter Voter ID: ");
                    voterID = s.nextLine();
                    try{
                        voter.setVoterId(voterID);
                    } catch (VoterIDException e){
                        System.out.println(e);
                        f++;
                    }
                }while (f>0);

                do {
                        f = 0;
                    System.out.println("Enter City: ");
                    city = s.nextLine();
                    try{
                        voter.setCity(city);
                    } catch (CityException e){
                        System.out.println(e);
                        f++;
                    }
                }while (f>0);

                do {
                    f = 0;
                    System.out.println("Enter Gender: ");
                    gender = s.nextLine();
                    try{
                        voter.setGender(gender);
                    } catch (GenderException e){
                        System.out.println(e);
                        f++;
                    }
                }while (f>0);

                break;

                case 2:
                    voter.display();
                    break;

                case 3:
                    String voterName = voter.getName();
                    String voterGender = voter.getGender();
                    String voterCity = voter.getCity();
                    int voterAge = voter.getAge();
                    String voter_ID = voter.getVoter_id();
                    if(voterName.equals("")||
                            voterGender.equals("")||
                            voterCity.equals("")||
                            voterAge==0||
                            voter_ID.equals("")){
                        choice = 0;
                        System.out.println();
                        System.out.println("<------------------------ Invalid Credentials!! ------------------------>");
                    } else {
                        System.out.println("<---------------------- DETAILS ADDED SUCCESSFULLY --------------------->");
                    }
                    break;
                default:
                    System.out.println("<---------------------- Invalid Input!! Try Again --------------------------->");
            }

        } while(choice!=3);

    }
}
