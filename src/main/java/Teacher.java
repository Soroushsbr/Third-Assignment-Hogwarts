import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends Account{
    private String username;
    private String password;
    private double score;
    private String course = "";

    private int vote = 0;
    public Teacher(String username , String password , double score, String course){
        this.username = username;
        this.password = password;
        this.score = score;
        this.course = course;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    @Override
    public void changePassword(String newPassword) {
        super.changePassword(newPassword);
    }

    public void showProfile() {
        System.out.println("|-------- " + username +" --------|");
        System.out.println("Score: " + score); //todo
        System.out.println("Taken Course: " + course); //todo
    }

    @Override
    public String toString() {
        return (this.username + ";" + this.course + ";" + this.score + ";" + this.vote + ";" + this.password);
    }
}
