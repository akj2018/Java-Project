package Voter_Info;

public class AgeException extends Exception{
    int age;
    AgeException(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Invalid Age"+"["+age+"]"+"Exception";
    }
}
