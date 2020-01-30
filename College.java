import java.util.*;
import java.util.ArrayList;
/**
 * Represents the college the students study at.
 *
 * @author Candidate 184737
 * @version 19/11/18
 */
public class College
{
    private ArrayList<Student> student;
    private Library library;
    private Random randomStudent;

    /**
     * Constructs the college class.
     *
     * @param numStudents The number of students studying at the college.
     * @param numBooks The number of textbooks held in the college library.
     * @return No return value.
     */
    public College(int numStudents, int numBooks)
    {
        library = new Library(numBooks);
        student = new ArrayList(numStudents);
        randomStudent = new Random();
        String name;
        for(int i = 0; i < numStudents; i++) {
            name = "Student " + (i + 1);
            student.add(new Student(name, library));
        }
        System.out.println(student);
    }

    /**
     * Allows parameter values to be passed in via main/command line.
     *
     * @param args An array of command line arguments passed into the main method.
     * @return No return value.
     */
    public static void main(String[] args) {
        int one = Integer.parseInt(args[0]);
        int two = Integer.parseInt(args[1]);
        int three = Integer.parseInt(args[2]);
        College test = new College(one, two);
        test.runCollege(three);
    }
    
    /**
     * Displays the number of students enrolled at the college and the number of textbooks in the library.
     * 
     * @return No return value.
     */
    public void describe()
    {
        System.out.println("The college currently has " + student.size() + " hard-working students.");
        library.describe();
    }
    
    /**
     * Selects a random student at the college.
     * And determines whether the student has graduated or if they need to continue to study.
     * 
     * @return No return value.
     */
    private void nextStep()
    {
        int num = randomStudent.nextInt(student.size());
        
        if (student.isEmpty()) {
            System.out.println("Everything has gone quiet.");
        }
        
        if (student.get(num).finishedStudies() == true) {
            student.remove(num);
            System.out.println("The student has graduated and left the college.");
        }
        else {
            student.get(num).study();
        } 
    }
    
    /**
     * Displays the describe and nextStep methods.
     * Repeats the process a number of times determined by the user.
     *
     * @param nSteps Takes the number of steps input by the user.
     * @return No return value.
     */
    public void runCollege(int nSteps)
    {
        for (int i = 0; i < nSteps; i++) {
            System.out.println("Step " + i);
            describe();
            nextStep();
        }
    }
}
