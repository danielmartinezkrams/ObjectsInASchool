/*
 Created by h205p2 on 9/11/17.
 */
public class Teacher extends Person{
    String subject = "";
    public Teacher(String subject, String firstName, String lastName){
        super(firstName, lastName);
        this.subject = subject;
    }

}
