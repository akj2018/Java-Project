package Election_Commisioner;

public class EC_UsernameException extends Exception {
    private String ecUsername = "";

    public EC_UsernameException(String ecUsername){
        this.ecUsername = ecUsername;
    }

    @Override
    public String toString() {
        return "Invalid Username Exception!!! Please Check Username";
    }
}
