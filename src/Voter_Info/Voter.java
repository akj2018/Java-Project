package Voter_Info;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Voter extends Voter_Count implements Voter_Function {
    private String name="";
    private String voter_id="";
    private  String gender="";
    private String city="";
    private int age;
    private String vote_party="";

    public Voter(){
        super();
    }

    public String getName() {
        return name;
    }

    public String getVoter_id() {
        return voter_id;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public String getVote_party() {
        return vote_party;
    }

    public void setVote_party(String vote_party) {
        this.vote_party = vote_party;
    }

    @Override
     public void setName(String name) throws NameException{
        name = name.trim();
        String regex = "[a-zA-Z]*";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(name.trim().replaceAll("\\s",""));
        if(name.equals("") || !matcher.matches()){
            throw new NameException(name);
        }
        int firstSpace = name.indexOf(" ");
        String temp = name;
        this.name = "";
        if(firstSpace!=-1){
            while(firstSpace!=-1){
                this.name = this.name + temp.substring(0,1).toUpperCase()+temp.substring(1,firstSpace).toLowerCase();
                this.name = this.name + " ";
                temp = temp.substring(firstSpace+1);
                firstSpace = temp.indexOf(" ");
            }

        }
        this.name = this.name + temp.substring(0,1).toUpperCase()+
                temp.substring(1).toLowerCase();
    }

    @Override
    public void setVoterId(String voter_id) throws VoterIDException{
        voter_id = voter_id.trim();
        String regex = "[^0-9]";
        Pattern p1 = Pattern.compile(regex);
        Matcher matcher1 = p1.matcher(voter_id.trim().replaceAll("\\s",""));
        String regex2 = "[0-9]{9}";
        Pattern p2 = Pattern.compile(regex2);
        Matcher matcher2 = p2.matcher(voter_id);
        if(voter_id.equals("")||matcher1.matches()|| !matcher2.matches()){
            throw new VoterIDException(voter_id);
        }
        this.voter_id = voter_id;
    }

    @Override
    public void setAge(int age) throws AgeException{
        String regex = "[0-9]{1,3}";
        Pattern p1 = Pattern.compile(regex);
        Matcher matcher1 = p1.matcher(Integer.toString(age).trim().replaceAll("\\s",""));
        if(age>=100||age<=17 || !matcher1.matches()){
            throw new AgeException(age);
        }
        this.age = age;
    }

    @Override
    public void setCity(String city) throws CityException{
        String regex = "[a-zA-Z]*";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(city.trim().replaceAll("\\s",""));
        if(city.equals("") || !matcher.matches()){
            throw new CityException(city);
        }
        int firstSpace = city.indexOf(" ");
        String temp = city;
        this.city = "";
        if(firstSpace!=-1){
            while(firstSpace!=-1){
                this.city = this.city + temp.substring(0,1).toUpperCase()+temp.substring(1,firstSpace).toLowerCase();
                this.city = this.city + " ";
                temp = temp.substring(firstSpace+1);
                firstSpace = temp.indexOf(" ");
            }

        }
        this.city = this.city + temp.substring(0,1).toUpperCase()+
                    temp.substring(1).toLowerCase();



    }

    @Override
    public void setGender(String gender)throws GenderException{
        String regex = "d+";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(gender.trim().replaceAll("\\s",""));
        if(gender.equals("") || matcher.matches()|| (!(gender.toLowerCase().equals("male"))&&!(gender.toLowerCase().equals("female")))){
            throw new GenderException(gender);
        }
        this.gender = gender.substring(0,1).toUpperCase()+gender.substring(1).toLowerCase();

    }

    public void display(){
        System.out.println();
        System.out.println("<-------VOTER DETAILS------>");
        System.out.println("VOTER'S NAME: "+this.getName());
        System.out.println("VOTER'S AGE: "+this.getAge());
        System.out.println("VOTER'S VOTER ID: "+this.getVoter_id());
        System.out.println("VOTER'S CITY: "+this.getCity());
        System.out.println("VOTER'S GENDER: "+this.getGender());
        System.out.println("<--------------------------->");
        System.out.println();
    }
}
