import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Account{
    private String username;
    private String password;
    private ArrayList<String> courses = new ArrayList<>();
    private String house;
    private UUID accountID;
    int gradeCnt;
    double grade;
    public Student(String username , String password, String house , double grade){
        this.username = username;
        this.password = password;
        this.house = house;
        this.grade = grade;
    }

    public int getGradeCnt() {
        return gradeCnt;
    }

    public void setGradeCnt(int gradeCnt) {
        this.gradeCnt = gradeCnt;
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        return enteredPassword.equals(password);
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    @Override
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void showProfile() {
        System.out.println("|-------- " + username +" --------|");
        System.out.println("Grade: " + grade); //todo
        System.out.println("Hogwarts House: " + house); //todo
        System.out.println("Taken Courses: " + courses); //todo
    }

    public ArrayList<String> getCourses(){
        return courses;
    }

    @Override
    public void uuidMaker() {
        super.uuidMaker();
    }

    @Override
    public String toString() {
        return ( this.username + ";" + this.house + ";" + this.grade + ";" + this.courses + ";" + this.password + ";" + this.gradeCnt);
    }
}
