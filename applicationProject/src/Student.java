import java.util.Arrays;

/*
 * Student Class 
 */

/**
 *
 * @author Kyleigh Knight
 * 
 * contains:
 *  -studentId
 *  -fName
 *  -lName
 *  -email
 *  -age
 *  -grades (array)
 * uses:
 *  -accessor
 *  -mutator
 *  -constructor
 *  -print() specific data with accessor
 */
public class Student{
    private String idNum;
    private String fName;
    private String lName;
    private String email;
    private int age;
    private int[] grades;

    // Constructor
    public Student(String idNum, String fName, String lName, String email, int age, int[] grades){
        setIdNum(idNum);
        setFirstName(fName);
        setLastName(lName);
        setEmail(email);
        setAge(age);
        setGrades(grades);
    }

    Student(String string, String string0, String string1, String string2, int parseInt, int parseInt0, int parseInt1, int parseInt2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    Instance accessor methods::::
    Accessor to get student's id.
    @params none
    */
    public String getIdNum(){
        return idNum;
    }

    /*
    accessor to get student's first name
    @params none
    */
    public String getFirstName(){
        return fName;
    }
    
    /*
    accessor to get student's last name
    @params none
    */
    public String getLastName(){
        return lName;
    }

    /*
    accessor to get student's email address name
    @params none
    */
    public String getEmailAddress(){
        return email;
    }
    
    /*
    accessor to get student's age
    @params none
    */
    public int getAge(){
        return age;
    }

    /*
    accessor to get student's single grade
    @params none
    */
    public int getGrades(int e){
        return this.grades[e];
    }

    /*
    accessor to get student's array of grades
    @params none
    */
    public int[] getGrades(){
        return grades;
    }

    /*
    accessor to get student's grades in string
    @params none
    */
    public String getStringGrades(){
        return Arrays.toString(this.grades);
    }

    /**
     * instance mutator methods
     * 
     * mutator to set student's id;
     * @param idNum
    */
    public void setIdNum(String idNum){
        this.idNum = idNum;
    }

    /**
     * mutator to set student first name
     * @param fName
     */
    public void setFirstName(String fName){
        this.fName = fName;
    }

    /**
     * mutator to set student last name
     * @param lName
     */
    public void setLastName(String lName){
        this.lName = lName;
    }

    /**
     * mutator to set student's email
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * mutator to set student's age
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * mutator to set student's grades in an array
     * 
     * @param gradeArray
     */
    public void setGrades(int[] grades){
        this.grades = grades;
    }

    /**
     * mutator to set student's grades into a string
     * 
     * @param scores
     */
    public void setStringGrade(String scores){
        String space = "|";
        String[] givenScores = scores.split(space);
        
        for(int i=0; i<scores.length(); i++){
            this.grades[i] = Integer.parseInt(givenScores[i]);
        }
    }

    /**
     * print() specific student data using accessors formatted
     */
    public void print(){
        System.out.printf("%s\tFirst Name: %s\tLast Name: %s\tAge: %d\tGrades: %s\n",
                this.getIdNum(), this.getFirstName(), this.getLastName(),
                this.getAge(), this.getStringGrades());
    }
    
}