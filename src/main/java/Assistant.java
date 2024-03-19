import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assistant extends Hogwarts{
    private String username = "Soroush";        //the admin can log in just with this specific id :)
    private final String password = "46792755";     //this password is actually hashed you can try it if you want :)
    public ArrayList<String> requestsTeacher = new ArrayList<>();
    public ArrayList<String> requestsStudent = new ArrayList<>(); //todo: you know what to do with these two

    public void showRequestTeacher(){
        int i = 1;
        for(String teacher : requestsTeacher){
            System.out.println(i + ". " + teacher);
            i++;
        }
    }

    public void showRequestStudent(){
        int i = 1;
        for(String student : requestsStudent){
            System.out.println(i + ". " + student);
            i++;
        }
    }
    public ArrayList<String> adjustCourseList(){
        Scanner in = new Scanner(System.in);
        viewAllCourses();
        System.out.println("-------------------\n1.Add\n2.Remove\n3.Exit");
        switch (in.next()){
            case "1":
                viewAllCourses();
                System.out.print("-------------------\nEnter the name of course you want to add: ");
                String courseName = in.next();
                coursesList.add(courseName);
                System.out.println("Added Successfully");
                adjustCourseList();
                break;
            case "2":
                viewAllCourses();
                System.out.println("------Please select the one you want to remove------");
                int index = in.nextInt();
                coursesList.remove(index - 1);
                System.out.println("Removed Successfully");
                adjustCourseList();
                break;
            case "3":
                break;
            default:
                adjustCourseList();
                break;
        }
        return coursesList;
    }

    public ArrayList<String> adjustTeachersList(){
        Scanner in = new Scanner(System.in);
        viewAllTeachers();
        System.out.println("-------------------\n1.Remove\n2.Exit");
        switch (in.next()){
            case "1":
                viewAllTeachers();
                System.out.println("------Please select the one you want to remove------");
                int index = in.nextInt();
                teachersList.remove(index - 1);
                System.out.println("Removed Successfully");
                adjustTeachersList();
                break;
            case "2":
                break;
            default:
                adjustTeachersList();
                break;
        }
        return teachersList;
    }

    public ArrayList<String> adjustStudentList(){
        Scanner in = new Scanner(System.in);
        viewAllStudents();
        System.out.println("-------------------\n1.Remove\n2.Exit");
        switch (in.next()){
            case "1":
                viewAllStudents();
                System.out.println("------Please select the one you want to remove------");
                int index = in.nextInt();
                studentsList.remove(index - 1);
                System.out.println("Removed Successfully");
                adjustStudentList();
                break;
            case "2":
                break;
            default:
                adjustStudentList();
                break;
        }
        return studentsList;
    }
    public boolean validatePassword(String enteredPassword) {
        Pattern pattern = Pattern.compile(password);
        Matcher matcher = pattern.matcher(enteredPassword);
        return matcher.find();
    }

    public boolean validateUsername(String enteredUsername) {
        Pattern pattern = Pattern.compile(username);
        Matcher matcher = pattern.matcher(enteredUsername);
        return matcher.find();
    }

    @Override
    public void viewAllTeachers() {
        super.viewAllTeachers();
        //todo
    }

    @Override
    public void viewAllStudents() {
        super.viewAllStudents();
    }

    @Override
    public void viewAllCourses() {
        super.viewAllCourses();
    }

    @Override
    public void teacherAppend(String enteredTeacher) {
        super.teacherAppend(enteredTeacher);
    }

    @Override
    public void studentsAppend(String enteredStudent) {
        super.studentsAppend(enteredStudent);
    }

    public ArrayList<String> getRequestsStudent() {
        return requestsStudent;
    }

    public ArrayList<String> getRequestsTeacher() {
        return requestsTeacher;
    }
}

