package Election_Commisioner;
import Screens.*;

public class EC extends EC_Functions {
    private static String username;
    private static String password;
    public static Party [] parties;

    private  String [] party_ID_List = new String[]{"19203","11231","59493","34224","65091","43422","53323","64545"};
    private  String [] party_Name_List = new String[]{"A","B","C","D","E","F","G","H"};
    private  String [] party_Leader_List = new String[]{"snw","wmeo","djjwo","ekowms","ejwlla","dnekle","smwow","emwkw"};

    static {
        EC.parties = new Party[8];
        username = "MUJ";
        password = "pass@123";
    }

    public class Party {
        public String partyID;
        public String partyName;
        public String partyLeader;
        public int votes = 0;

        Party(){
            this.partyName = "Not Provided";
            this.partyID = "Not Provided";
            this.partyLeader = "Not Provided";
        }

        Party(String partyID,String partyName,String partyLeader){
            this.partyID = partyID;
            this.partyLeader = partyLeader;
            this.partyName = partyName;
        }
    }

    {
        for (int i = 0; i <8 ; i++) {
            EC.parties[i] = new Party(this.party_ID_List[i],this.party_Name_List[i],this.party_Leader_List[i]);
        }
    }


    @Override
    public void check_username(String ec_Username)throws EC_UsernameException{
        if(!ec_Username.trim().equals(username)){
            throw new EC_UsernameException(ec_Username);
        }
    }

    @Override
    public void check_password(String ec_Password) throws EC_PasswordException{
        if(!ec_Password.trim().equals(password)){
            throw new EC_PasswordException(ec_Password);
        }
    }

    @Override
    public void add_voter(){
        AddVoterInfoDisplay.display();
    }

    @Override
    public void delete_voter() {
        DeleteVoterInfoDisplay.display();
    }

    @Override
    public void update_voter() {

    }

    @Override
    public void result() {
       ResultDisplay.dislayResult();
    }

}
