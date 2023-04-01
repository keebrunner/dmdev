package week6.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentsRunner {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", 1, Arrays.asList(4, 5, 3, 5)));
        students.add(new Student("Jane", "Doe", 2, Arrays.asList(5, 5, 4, 3)));
        students.add(new Student("Bob", "Smith", 1, Arrays.asList(3, 2)));
        students.add(new Student("Alice", "Jones", 2, Arrays.asList(5, 4, 5)));
        students.add(new Student("Peter", "Parker", 1, Arrays.asList(5, 4, 4, 4)));
        students.add(new Student("Mary", "Jane", 2, Arrays.asList(4, 4, 4)));
        students.add(new Student("Bruce", "Wayne", 1, Arrays.asList(5, 5, 5)));
        students.add(new Student("Clark", "Kent", 2, Arrays.asList(3, 4, 3, 5)));

        CourseStatistics courseStatistics = new CourseStatistics(students);
        courseStatistics.calculateStatistics();
    }
}
