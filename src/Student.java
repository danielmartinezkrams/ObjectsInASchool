import java.util.ArrayList;

/**
 Created by h205p2 on 9/11/17.
 */
public class Student extends Person{
    int grade = 0;
    int awesomeness = 0;
    public Student(int grade, String firstName, String lastName, int awesomeness){
        super(firstName, lastName);
        this.grade = grade;
        this.awesomeness = awesomeness;
    }

}
