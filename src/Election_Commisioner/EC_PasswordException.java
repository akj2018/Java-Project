package Election_Commisioner;

public class EC_PasswordException extends Exception {
    private String ecPassword = "";

    public EC_PasswordException(String ecPassword){
        this.ecPassword = ecPassword;
    }

    @Override
    public String toString() {
        return "Invalid Password Exception!!! Please Re-enter Password";
    }
}
