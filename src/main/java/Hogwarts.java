import java.util.ArrayList;
import java.util.Arrays;

public class Hogwarts {

    // TODO: Define Attributes
    public ArrayList<String> teachersList = new ArrayList<>();
    public ArrayList<String> studentsList = new ArrayList<>();
    public ArrayList<String> coursesList = new ArrayList<>();

    // TODO: Define Functionalities
    public void viewAllTeachers() {
        System.out.println("    NAME   COURSE   SCORE\n");
        int i = 1;
        for(String teacher : teachersList){
            String[] parts = teacher.split(String.valueOf(";"));
            System.out.print(i + ". ");
            for(int j = 0 ; j < parts.length - 1; j++){
                System.out.print(parts[j] + "   ");
            }
            System.out.println();
            i++;
        }
    }

    public void teacherAppend(String enteredTeacher){
        teachersList.add(enteredTeacher);
    }

    public void viewAllStudents() {
        System.out.println("   NAME    HOUSE    GRADE    COURSES\n");
        int i = 1;
        for(String student : studentsList){
            String[] parts = student.split(String.valueOf(";"));
            System.out.print(i + ". ");
            for(int j = 0 ; j < parts.length - 1; j++){
                System.out.print(parts[j] + "   ");
            }
            System.out.println();
            i++;
        }
    }

    public void studentsAppend(String enteredStudent){
        studentsList.add(enteredStudent);
    }

    public void viewAllCourses() {
        int i = 1;
        for(String course : coursesList){
            System.out.println(i + ". " +course);
            i++;
        }
    }
    public void defaultCourses(){
        coursesList.addAll(Arrays.asList("Calculus" , "Magic" , "Riding Broomstick" , "Physics" , "Chemistry"));
    }


}