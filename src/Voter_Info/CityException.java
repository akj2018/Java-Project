package Voter_Info;

public class CityException extends Exception{
    private String city;
    
    CityException(String city){
        this.city = city;
    }
    
    @Override
    public String toString(){
        return "Invalid city " +"["+city+"]"+ " Entered";
    }
}
