/*
Created by h205p2 on 9/12/17.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerGo {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Teacher> searchTeachers = new ArrayList<Teacher>();
    static ArrayList<Student> searchStudents = new ArrayList<Student>();
    static ArrayList<Section> searchSections = new ArrayList<Section>();
    public static void main(String args[]){
        System.out.println("Would you like to search (h), create a Student (s) or Teacher (t), or manage a Section (c)?");
        options(sc.next());
    }
    public static void options(String command){
        switch(command) {
            case "h":
                System.out.println("Are you searching for a student (s) or teacher(t)?");
                String returnStatement = new String();
                switch(sc.next()){
                    case "s":
                        System.out.println("What is the id you are searching for?");
                        int idStudentGuess = sc.nextInt();
                        for(int i = 0; i < searchStudents.size(); i++){
                            if(idStudentGuess == searchStudents.get(i).id){
                                returnStatement += searchStudents.get(i).firstName + " " + searchStudents.get(i).lastName + " is in the following courses";
                                for(int j = 0; j < searchSections.size(); j++){
                                    for(int k = 0; k < searchSections.get(j).students.size(); k++){
                                        if(searchSections.get(j).students.get(k).id == idStudentGuess){
                                            returnStatement += searchSections.get(j).name + " ";
                                        }
                                    }
                                }

                            }
                        }
                        System.out.println(returnStatement);
                        break;
                    case "t":
                        System.out.println("What is the id you are searching for?");
                        int idTeacherGuess = sc.nextInt();
                        returnStatement = new String();
                        for(int i = 0; i < searchTeachers.size(); i++){
                            if(idTeacherGuess == searchTeachers.get(i).id){
                                returnStatement += searchTeachers.get(i).firstName + " " + searchTeachers.get(i).lastName + " is teaching the following courses";
                                for(int j = 0; j < searchSections.size(); j++){
                                    if(searchSections.get(j).teacher.id == idTeacherGuess){
                                        returnStatement += searchSections.get(j).name;
                                    }
                                }

                            }
                        }
                        System.out.println(returnStatement);
                }
            case "s":
                Student student = createStudent();
                System.out.println("The student's id is: " + student.id);
                break;
            case "t":
                Teacher teacher = createTeacher();
                System.out.println("The teacher's id is: " + teacher.id);
                break;
            case "c":
                System.out.println("Would you like to create a section (c), check the number of students in a section (n), or add student to a previously created section (a) or remove a student from a previously created section (r)?");
                switch(sc.next()){
                    case "c":
                        Section section = createSection();
                        System.out.println("The name is " + section.name);
                        System.out.println("The id is " + section.id);
                        System.out.println("The max size is " + section.maxSize);
                        System.out.println("The teacher is " + section.teacher.firstName + " " + section.teacher.lastName);
                        break;
                    case "a":
                        System.out.println("What is the section id?");
                        int idGuess = sc.nextInt();
                        for(int i = 0; i < searchSections.size(); i++){
                            if(idGuess == searchSections.get(i).id) {
                                System.out.println("What is the id of the student you would like to add?");
                                for (int j = 0; j < searchStudents.size(); j++) {
                                    int idStud = sc.nextInt();
                                    if (idStud == searchStudents.get(j).id) {
                                        searchSections.get(i).addStudent(searchStudents.get(j));
                                        System.out.println(searchStudents.get(j).firstName + " " + searchStudents.get(j).lastName + " was added to section " + searchSections.get(i).name);
                                    }
                                }
                            }
                        }
                        break;
                    case "r":
                        System.out.println("What is the section id?");
                        idGuess = sc.nextInt();
                        for(int i = 0; i < searchSections.size(); i++){
                            if(idGuess == searchSections.get(i).id) {
                                System.out.println("What is the id of the student you would like to remove?");
                                for (int j = 0; j < searchStudents.size(); j++) {
                                    int idStud = sc.nextInt();
                                    if(idStud == searchStudents.get(j).id) {
                                        searchSections.get(i).removeStudent(searchStudents.get(j).id);
                                        System.out.println(searchStudents.get(j).firstName + " " + searchStudents.get(j).lastName + " was removed from section " + searchSections.get(i).name);
                                    }
                                }
                            }
                        }
                        break;
                    case "n":
                        System.out.println("What is the section id?");
                        idGuess = sc.nextInt();
                        for(int i = 0; i < searchSections.size(); i++){
                            if(idGuess == searchSections.get(i).id) {
                                searchSections.get(i).sectionSeatsRemaining();
                            }

                        }
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        checkForMore();
    }
    public static void checkForMore(){
        System.out.println("Would you like to do anything else (y or n)?");
        String answer = sc.next();
        switch(answer){
            case "y":
                System.out.println("Would you like to search (h), create a Student (s) or Teacher (t), or manage a Section (c)?");
                options(sc.next());
                break;
            case "n":
                break;
            default:
                System.out.println("Invalid");
        }
    }
    public static Teacher createTeacher(){
        System.out.println("What is the first name?");
        String teacherFirst = sc.next();
        System.out.println("What is the last name?");
        String teacherLast = sc.next();
        System.out.println("What is the subject?");
        String teacherSubject = sc.next();
        Teacher teacher = new Teacher(teacherSubject, teacherFirst, teacherLast);
        searchTeachers.add(teacher);
        return teacher;
    }
    public static Student createStudent(){
        System.out.println("What is the first name?");
        String studentFirst = sc.next();
        System.out.println("What is the last name?");
        String studentLast = sc.next();
        System.out.println("What is the grade?");
        int studentGrade = sc.nextInt();
        System.out.println("How awesome is the student?");
        int studentAwesomeness = sc.nextInt();
        Student student = new Student(studentGrade, studentFirst, studentLast, studentAwesomeness);
        searchStudents.add(student);
        return student;
    }
    public static Section createSection(){
        ArrayList<Student> students = new ArrayList<Student>();
        Teacher sectionTeacher = null;
        Section section = null;
        System.out.println("What is the name of the section?");
        String sectionName = sc.next();
        System.out.println("What is the section maximum size?");
        int sectionMaxSize = sc.nextInt();
        System.out.println("Have you created a teacher (y or n)?");
        String teacherCreatedAnswer = sc.next();
        switch(teacherCreatedAnswer) {
            case "y":
                System.out.println("What is the teacher's id?");
                for (int i = 0; i < searchTeachers.size(); i++) {
                    int idGuess = sc.nextInt();
                    if (idGuess == searchTeachers.get(i).id) {
                        sectionTeacher = searchTeachers.get(i);
                    } else {
                        sectionTeacher = createTeacher();
                        searchTeachers.add(sectionTeacher);
                        System.out.println("The teacher's id is: " + sectionTeacher.id);
                    }
                }
                section = new Section(sectionName, sectionMaxSize, students, sectionTeacher);
                searchSections.add(section);
                break;
            case "n":
                sectionTeacher = createTeacher();
                searchTeachers.add(sectionTeacher);
                System.out.println("The teacher's id is: " + sectionTeacher.id);
                section = new Section(sectionName, sectionMaxSize, students, sectionTeacher);
                searchSections.add(section);
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        return section;
    }
}
