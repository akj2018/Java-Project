package Voter_Info;

public class VoterIDException extends Exception{
    String voterID;
    VoterIDException(String voterID){
        this.voterID = voterID;
    }

    @Override
    public String toString() {
        return "Invalid Voter ID"+"["+voterID+"]"+"Exception";
    }
}
