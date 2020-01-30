/**
 * Represents the students that study at the college.
 *
 * @author Candidate 184737
 * @version 19/11/18
 */
public class Student
{
    private String studentName;
    private Library studentLibrary;
    private LibraryCard cardIssued;
    private TextBook currentBook;

    /**
     * Constructs the Student class.
     *
     * @param name The name of the student.
     * @param library The identity of the library that the student is registered to.
     * @return No return value.
     */
    public Student(String name, Library library)
    {
        studentName = name;
        studentLibrary = library;
        cardIssued = studentLibrary.issueCard();
        currentBook = null;
    }
    
    /**
     * Determines whether the student has completed their studies or not.
     *
     * @return The student's study completion status.
     */
    public boolean finishedStudies()
    {
        if (currentBook == null && cardIssued.expired() == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Causes the student to complete some form of studying action.
     * This action could be to borrow a book, read a chapter or return the book.
     * 
     * @return No return value.
     */
    public void study()
    {
        if (currentBook == null) {
            currentBook = studentLibrary.borrowBook(cardIssued);
        }
        
        else if (currentBook != null) {
            if (currentBook.isFinished()) {
                currentBook.closeBook();
                studentLibrary.returnBook(currentBook);
                currentBook = null;
            }
            else {    
                currentBook.readNextChapter();
            }
        }
    }

    /**
     * Displays the student's progress studying and their usage of the library.
     *
     * @return No return value.
     */
    public void describe()
    {
        if (currentBook == null) {
            System.out.println("Student " + studentName + " does not have a book and ");
            cardIssued.describe();
        }
        
        else if (currentBook.isFinished() == false) {
            System.out.println("The student is reading the book");
        }
        else {
            System.out.println("The book is finished");
        }
        
        currentBook.describe();
    }
}
