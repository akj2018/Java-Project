package Voter_Info;

public class NameException extends Exception{
    private String name;

    NameException(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Invalid Name " +"["+name+"]"+ " Entered";
    }
}
