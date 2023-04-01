package week6.Task1;

import java.util.*;
import java.util.stream.Collectors;

public class CourseStatistics {
    private List<Student> students;

    public CourseStatistics(List<Student> students) {
        this.students = students;
    }

    public void calculateStatistics() {
        Map<Integer, TreeMap<String, Object>> result = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            List<Student> filteredStudents = list.stream()
                                    .filter(s -> s.getGrades().size() > 3)
                                    .collect(Collectors.toList());
                            List<Integer> filteredGrades = filteredStudents.stream()
                                    .map(Student::getGrades)
                                    .flatMap(List::stream)
                                    .collect(Collectors.toList());
                            double filteredAverageGrade = filteredGrades.stream()
                                    .mapToInt(Integer::intValue)
                                    .average()
                                    .orElse(Double.NaN);
                            List<String> sortedStudentNames = filteredStudents.stream()
                                    .sorted(Comparator.comparing(Student::getFirstName)
                                            .thenComparing(Student::getLastName))
                                    .map(s -> s.getFirstName() + " " + s.getLastName())
                                    .collect(Collectors.toList());

                            List<Student> sortedStudents = filteredStudents.stream()
                                    .sorted(Comparator.comparing(Student::getFirstName)
                                            .thenComparing(Student::getLastName))
                                    .collect(Collectors.toCollection(ArrayList::new));

                            TreeMap<String, Object> courseData = new TreeMap<>();
                            courseData.put("averageGrade", filteredAverageGrade);
                            courseData.put("sortedStudentNames", sortedStudentNames);
                            courseData.put("sortedStudents", sortedStudents);
                            courseData.put("averageGradeOfSortedStudents", filteredStudents.stream()
                                    .flatMapToInt(s -> s.getGrades().stream().mapToInt(Integer::intValue))
                                    .average()
                                    .orElse(Double.NaN));

                            return courseData;
                        })));

        for (Map.Entry<Integer, TreeMap<String, Object>> entry : result.entrySet()) {
            int courseNumber = entry.getKey();
            TreeMap<String, Object> courseData = entry.getValue();

            double averageGrade = (double) courseData.get("averageGrade");
            List<String> sortedStudentNames = (List<String>) courseData.get("sortedStudentNames");
            List<Student> sortedStudents = (List<Student>) courseData.get("sortedStudents");
            double averageGradeOfSortedStudents = (double) courseData.get("averageGradeOfSortedStudents");

            System.out.println("Course number: " + courseNumber);
            System.out.println("Average grade: " + String.valueOf(Math.round(averageGrade * 10) / 10.0));
            System.out.println("Sorted student names:");
            sortedStudentNames.forEach(System.out::println);

            System.out.println("Sorted students:");
            sortedStudents.forEach(student -> {
                System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + student.getGrades());
            });

            System.out.println("Average grade of sorted students: " + String.valueOf(Math.round(averageGradeOfSortedStudents * 10) / 10.0) + "\n");
        }
    }
}
