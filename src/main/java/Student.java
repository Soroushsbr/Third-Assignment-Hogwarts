import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Account{
    private String username;
    private String password;
    private ArrayList<String> courses = new ArrayList<>();
    private String house;
    double grade;
    public Student(String username , String password, String house , double grade){
        this.username = username;
        this.password = password;
        this.house = house;
        this.grade = grade;
    }
    @Override
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    @Override
    public void changeUsername(String newUsername) {
        this.username = newUsername;
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
    public String toString() {
        return ( this.username + ";" + this.house + ";" + this.grade + ";" + this.courses + ";" + this.password);
    }
}
