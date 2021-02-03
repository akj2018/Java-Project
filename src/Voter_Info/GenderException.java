package Voter_Info;

public class GenderException extends Exception{
    String gender;
    GenderException(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Invalid Gender"+"["+gender+"]"+"Exception";
    }
}
