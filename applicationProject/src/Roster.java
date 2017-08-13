/*
 * Roster Class
 */
import java.util.ArrayList;

/**
 *
 * @author Kyleigh Knight
 * 
 * contains methods:
 *  -print_all() formatted
 *  -print_avg_grade()
 *  -print_invalid_emails() checks emails for @ and no spaces
 */
public class Roster {
    
    private String idNum;
    private String fName;
    private String lName;
    private String email;
    private int age;
    private int gr1;
    private int gr2;
    private int gr3;
    
    private static String [] students = {
            "1,John,Smith,John1989@gmail.com,20,88,79,59",
            "2,Suzan,Erickson,Erickson_1990@gmailcom,19,91,72,85",
            "3,Jack,Napoli,The_lawyer99yahoo.com,19,85,84,87",
            "4,Erin,Black,Erin.black@comcast.net,22,91,98,82",
            "5,Kyleigh,Knight,kyleigh.knight@hotmail.com,27,90,73,89"
        };

    private static ArrayList<Student> roster = new ArrayList<>();

    public static void main(String args[]){
        loadStudents(students);
        print_all();
        print_invalid_emails();
        rosterAvg();
        remove("3");
        remove("3");
        print_all();
    }
    
    /**
     * object constructors
     * @param idNum
     * @param fName
     * @param lName
     * @param email
     * @param age
     * @param gr1
     * @param gr2
     * @param gr3
     */
    public Roster(String idNum, String fName, String lName, String email, 
            int age, int gr1, int gr2, int gr3){
        this.idNum = idNum;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.age = age;
        this.gr1 = gr1;
        this.gr2 = gr2;
        this.gr3 = gr3;
    }

    /**
     * Load method from array of student data into arraylist
     * @param students
     */
    public static void loadStudents(String[] students){
        String space = ",";
        for(String a : students){
            String[] studentInfo = a.split(space);
            add(  studentInfo[0],
                  studentInfo[1],
                  studentInfo[2],
                  studentInfo[3],
                  Integer.parseInt(studentInfo[4]),
                  Integer.parseInt(studentInfo[5]),
                  Integer.parseInt(studentInfo[6]),
                  Integer.parseInt(studentInfo[7]) );
        }
    }

    public static void add(String idNum, String fName, String lName, String email,
        int age, int g1, int g2, int g3){
        int[] grades = {g1, g2, g3};
        Student newStudent = new Student(idNum, fName, lName, email, age, grades);
        roster.add(newStudent);
    }

    /**
     *remove student's information
     * @param idNum
     */
    public static void remove(String idNum){
        Student found = null;
        for(Student e : roster){
            String id = e.getIdNum();
            if((id.equals(idNum))){
                found = e;
            }
        }
        if(found != null){
            roster.remove(found);
            System.out.println("Removed Student: " + idNum);
        } else {
            System.out.println("No Student found with ID: " + idNum);
        }
    }

    /**
     * formatted print all listed students data using accessor
     */
    public static void print_all(){
        for(Student e : roster){
            e.print();
        }
    }

    /**
     * print() a student's average grade by student id
     * @param idNum
     */
    public static void print_average_grade(String idNum){
        for(Student e : roster){
            if(e.getIdNum() == idNum){
                double total = 0;
                double grade = 0;
                int[] grades = e.getGrades();
                for(int g : grades){
                    total++;
                    grade += g;
                }
                int average = (int)(((grade)/(total*100)*100));
                System.out.println(idNum + " average is " + average);
            }
        }
    }

    /**
     * print() all students averages
     */
    public static void rosterAvg(){
        for(Student e : roster){
            print_average_grade(e.getIdNum());
        }
    }

    /**
     * verifies student email addresses and displays all invalid email 
     * addresses to the user
     */
    public static void print_invalid_emails(){
        for(Student e : roster){
            String stringTest = e.getEmailAddress();
            if((stringTest.contains(" ")) || (! stringTest.contains("@"))
                    || (! stringTest.contains("."))){
                System.out.printf("Invalid email: %s\n", stringTest);
            }
        }
    }
}