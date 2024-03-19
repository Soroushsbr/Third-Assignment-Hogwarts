import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Hogwarts hogwarts = new Hogwarts();
    public static Assistant assistant = new Assistant();

    public static void main(String[] args) {
        // TODO: Program starts from here
        hogwarts.defaultCourses();
        assistant.defaultCourses();
        runMenu();
        System.out.println("Happy Norouz :)");
    }


    public static void runMenu() {
        System.out.println("--------WELCOME TO HOGWARTS--------");
        Scanner in = new Scanner(System.in);
        System.out.println("1.Hogwarts Management\n2.Assistant Management \n3.Teacher Management \n4.Student Management\n5.Exit");
        switch (in.next()) {
            case "1":
                hogwartsMenu();
                break;
            case "2":
                assistantMenu();
                break;
            case "3":
                teacherMenu();
                break;
            case "4":
                studentMenu();
                break;
            case "5":
                break;
            default:
                System.out.println("Error: Invalid input");
                runMenu();
                break;
        }
    }

    public static String quiz() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose one:\n1.Lion\n2.Snake\n3.Badger\n4.Owl");
        String house = "";
        switch (in.next()) {
            case "1":
                house = "Gryffindor";
                break;
            case "2":
                house = "Hufflepuff";
                break;
            case "3":
                house = "Ravenclaw";
                break;
            case "4":
                house = "Slytherin";
                break;
            default:
                quiz();
        }
        return house;
    }

    public static String hasedPassword(String enteredPassword) {
        int hashNum = enteredPassword.hashCode();
        return Integer.toString(hashNum);
    }

    public static void hogwartsMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("-------- Select an option --------\n1.Show Teachers\n2.Show Student\n3.Show Courses\n4.Exit");
        switch (in.next()) {
            case "1":
                hogwarts.viewAllTeachers();
                break;
            case "2":
                hogwarts.viewAllStudents();
                break;
            case "3":
                hogwarts.viewAllCourses();
                break;
            case "4":
                runMenu();
                break;
            default:
                System.out.println("Error: Invalid input");
                break;
        }
        hogwartsMenu();
    }

    public static void assistantMenu() {
        Scanner in = new Scanner(System.in);
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = hasedPassword(in.next());
        if (assistant.validatePassword(password) && assistant.validateUsername(username)) {
            assistantMenuLog();
        } else {
            System.out.println("Error: Wrong username or password.");
        }
        runMenu();
        //todo: make his powers
    }

    public static void assistantMenuLog() {
        Scanner in = new Scanner(System.in);
        System.out.println("--------Welcome Admin--------\n1.Adjust Teachers\n2.Adjust Students\n3.Adjust Courses\n4.Requests\n5.Exit");//todo
        switch (in.next()) {
            case "1":
                hogwarts.teachersList = assistant.adjustTeachersList();
                break;
            case "2":
                hogwarts.studentsList = assistant.adjustStudentList();
                break;
            case "3":
                hogwarts.coursesList = assistant.adjustCourseList();
                break;
            case "4":
                System.out.println("-----------------------\n1.Teacher Requests\n2.Student Requests\n3.Exit");
                switch (in.next()){
                    case "1":
                        requestTeacher();
                        break;
                    case "2":
                        requestStudent();
                        break;
                    default:
                        break;
                }
                break;
            case "5":
                runMenu();
                break;
            default:
                break;
        }
        assistantMenuLog();
    }

    public static void requestTeacher(){
        Scanner in = new Scanner(System.in);
        assistant.showRequestTeacher();
        System.out.println("----- Please Select one -----");
        int index = in.nextInt();
        System.out.println("----- Please Select one -----\n1.Accept\n2.Remove\n3.Exit");
        switch (in.next()){
            case "1":
                hogwarts.teachersList.add(assistant.requestsTeacher.get(index - 1));
                assistant.teachersList.add(assistant.requestsTeacher.get(index - 1));
                assistant.requestsTeacher.remove(index - 1);
                break;
            case "2":
                assistant.requestsTeacher.remove(index - 1);
            case "3":
                assistantMenuLog();
                break;
            default:
                requestTeacher();
                break;
        }
    }

    public static void requestStudent(){
        Scanner in = new Scanner(System.in);
        assistant.showRequestStudent();
        System.out.println("----- Please Select one -----");
        int index = in.nextInt();
        System.out.println("----- Please Select one -----\n1.Accept\n2.Remove\n3.Exit");
        switch (in.next()){
            case "1":
                hogwarts.studentsList.add(assistant.requestsStudent.get(index - 1));
                assistant.studentsList.add(assistant.requestsStudent.get(index - 1));
                assistant.requestsStudent.remove(index - 1);
                break;
            case "2":
                assistant.requestsStudent.remove(index - 1);
            case "3":
                assistantMenuLog();
                break;
            default:
                requestStudent();
                break;
        }
    }

    public static void teacherMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Log in\n2.Sign up\n3.Exit");
        String opt = in.next();
        if (opt.equals("1")) {
            System.out.println("Username: ");
            String username = in.next();
            Teacher teacher = teacherFinder(username);
            System.out.println("Password: ");
            String password = hasedPassword(in.next());
            if(teacher.validatePassword(password)) {
                teacherMenuLog(teacher, username);
            }
            else{
                System.out.println("Wrong Password");
            }
        } else if (opt.equals("2")) {
            System.out.print("Username: ");
            String username = in.next();
            System.out.print("Password: ");
            String password = hasedPassword(in.next());
            double score = 0;
            System.out.println("Please select a course you want to teach:");
            hogwarts.viewAllCourses();
            int index = in.nextInt();
            String course = hogwarts.coursesList.get(index - 1);
            Teacher teacher = new Teacher(username, password, score, course);
            assistant.requestsTeacher.add(teacher.toString());
            System.out.println("------Your request sent------");
            runMenu();
        } else if (opt.equals("3")) {
            runMenu();
        } else {
            System.out.println("Invalid input.");
            teacherMenu();
        }

    }

    public static void teacherMenuLog(Teacher teacher , String username){
        Scanner in = new Scanner(System.in);
        teacher.showProfile();
        System.out.println("----------------------\n1.Change Username\n2.Change Password\n3.Exit");
        switch (in.next()) {
            case "1":
                teacherReplace(username);
                System.out.println("New Username: ");
                teacher.changeUsername(in.next());
                hogwarts.teachersList.add(teacher.toString());
                assistant.teachersList.add(teacher.toString());
                teacherMenuLog(teacher , username);
                break;
            case "2":
                teacherReplace(username);
                System.out.println("New Password: ");
                teacher.changePassword(in.next());
                hogwarts.teachersList.add(teacher.toString());
                assistant.teachersList.add(teacher.toString());
                teacherMenuLog(teacher , username);
                break;
            case "3":
                runMenu();
                break;
            default:
                teacherMenuLog(teacher , username);
                break;

        }
    }

    public static void studentMenu() {
        Scanner in = new Scanner(System.in);
        //todo
        System.out.println("1.Log in\n2.Sign up\n3.Exit");
        String opt = in.next();
        if (opt.equals("1")) {
            System.out.println("Username: ");
            String username = in.next();
            Student student = studentFinder(username);
            System.out.println("Password: ");
            String password = hasedPassword(in.next());
            if(student.validatePassword(password)) {
                studentMenuLog(student, username);
            }
            else{
                System.out.println("Wrong Password");
            }
        } else if (opt.equals("2")) {
            System.out.print("Username: ");
            String username = in.next();
            System.out.print("Password: ");
            String password = hasedPassword(in.next());
            String house = quiz();
            double grade = 0;
            Student student = new Student(username, password, house, grade);
            assistant.requestsStudent.add(student.toString());
            System.out.println("------Your request sent------");
            runMenu();
        } else if (opt.equals("3")) {
            runMenu();
        } else {
            System.out.println("Error: Invalid input.");
            studentMenu();
        }
    }

    public static void studentMenuLog(Student student, String username){
        Scanner in = new Scanner(System.in);
        student.showProfile();
        System.out.println("----------------------\n1.Change Username\n2.Change Password\n3.Adjust Courses\n4.Exit");
        switch (in.next()) {
            case "1":
                studentReplace(username);
                System.out.println("New Username: ");
                student.changeUsername(in.next());
                hogwarts.studentsList.add(student.toString());
                assistant.studentsList.add(student.toString());
                studentMenuLog(student,username);
                break;
            case "2":
                studentReplace(username);
                System.out.println("New Password: ");
                student.changePassword(in.next());
                hogwarts.studentsList.add(student.toString());
                assistant.studentsList.add(student.toString());
                studentMenuLog(student,username);
                break;
            case "3":
                studentReplace(username); //fix
                adjustCourses(student);
                studentMenuLog(student,username);
                break;
            case "4":
                runMenu();
                break;
        }

    }

    public static void adjustCourses(Student student) {
        System.out.println("Taken Courses: " + student.getCourses() + "\n---------------------");
        Scanner in = new Scanner(System.in);
        System.out.println("Please select a course: ");
        hogwarts.viewAllCourses();
        int index = in.nextInt();
        ArrayList<String> courses = student.getCourses();
        courses.add(hogwarts.coursesList.get(index - 1));
        hogwarts.studentsAppend(student.toString());
        assistant.studentsAppend(student.toString());
    }

    public static void studentReplace(String username) {
        int i = 0;
        for (String student : hogwarts.studentsList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(student);
            if (matcher.find()) {
                hogwarts.studentsList.remove(i);
                assistant.studentsList.remove(i);
                break;
            }
            i++;
        }
    }

    public static void teacherReplace(String username) {
        int i = 0;
        for (String teacher : hogwarts.teachersList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(teacher);
            if (matcher.find()) {
                hogwarts.teachersList.remove(i);
                assistant.teachersList.remove(i);
                break;
            }
            i++;
        }
    }

    public static Teacher teacherFinder( String username) {
        for (String name : hogwarts.teachersList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                String[] parts = name.split(String.valueOf(";"));
                String course = parts[1];
                double score = Double.parseDouble(parts[2]);
                String password = parts[3];
                Teacher teacher = new Teacher(username, password, score, course);
                return teacher;
            } else {
                System.out.println("Username not found");
            }
        }
        return null;
    }
    public static Student studentFinder(String username){
        for (String name : hogwarts.studentsList) {
            Pattern pattern = Pattern.compile("\\w*" + username + "\\w*");
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                String[] parts = name.split(String.valueOf(";"));
                String house = parts[1];
                double grade = Double.parseDouble(parts[2]);
                String password = parts[4];
                Student student = new Student(username , password, house , grade);
                if(!parts[3].equals("[]")){
                    String list = parts[3].substring(1 , parts.length - 1);
                    String[] listObj = list.split(String.valueOf(","));
                    ArrayList<String> courses = student.getCourses();
                    for (int i = 0; i < parts.length; i++) {
                        if (listObj[i].charAt(0) == ' ') {
                            courses.add(listObj[i].substring(1));
                        } else {
                            courses.add(listObj[i]);
                        }
                    }
                }
                return student;
            } else {
                System.out.println("Username not found"); //todo: fix the bug
            }
        }
        return null;
    }
}