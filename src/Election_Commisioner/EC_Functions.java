package Election_Commisioner;

public abstract class EC_Functions extends Exception{

    public abstract void check_username(String username) throws EC_UsernameException;
    public abstract void check_password(String password) throws EC_PasswordException;
    public abstract void add_voter ();
    public abstract void update_voter();
    public abstract void delete_voter();
    public abstract void result();
}
