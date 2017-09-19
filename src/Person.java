/*
Created by h205p2 on 9/11/17.
 */
public class Person {
    static int nextId = 000001;
    int id = 0;
    String firstName = "";
    String lastName = "";

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = nextId;
        nextId++;
    }

}
