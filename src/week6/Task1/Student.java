package week6.Task1;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private int courseNumber;
    private List<Integer> grades;

    public Student(String firstName, String lastName, int courseNumber, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public List<Integer> getGrades() {
        return grades;
    }
}

