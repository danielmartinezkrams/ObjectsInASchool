import java.util.ArrayList;

/*
 Created by h205p2 on 9/11/17.
 */
public class Section {
    String name = "";
    int maxSize = 0;
    int currentSize = 0;
    static int nextId = 0;
    int id = 0;
    int awesomeScore = 0;
    ArrayList<Student> students = new ArrayList<Student>();
    Teacher teacher;
    public void addStudent(Student stdt){
        students.add(stdt);
    }
    public void removeStudent(int id){
        for(int i = 0; i < this.students.size(); i++){
            if(students.get(i).id == id){
                students.remove(i);
            }
        }
    }
    public void sectionSeatsRemaining(){
        System.out.println(this.maxSize - this.students.size());
    }
    public int returnAwesomeScore(){
        int score = 0;
        for(int i = 0; i < students.size(); i++){
            score += students.get(i).awesomeness;
        }
        return (score / (students.size() + 1));
    }
    public Section (String name, int maxSize, ArrayList<Student> students, Teacher teacher){
        this.name = name;
        this.maxSize = maxSize;
        this.currentSize = students.size();
        this.students = students;
        this.teacher = teacher;
        this.id = nextId;
        this.awesomeScore = returnAwesomeScore();;
        nextId++;
    }

}
