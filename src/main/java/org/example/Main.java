package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
// Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5,
// отсортированных по убыванию среднего балла.
// В решении не использовать циклы! Только StreamAPI
public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Name1", Arrays.asList(4.2, 4.5, 5.0), "Информатика"),
                new Student("Name2", Arrays.asList(3.5, 4.0, 4.5), "Информатика"),
                new Student("Name3", Arrays.asList(4.5, 5.0, 5.0), "Физика"),
                new Student("Name4", Arrays.asList(4.0, 4.0, 4.0), "Информатика"),
                new Student("Name5", Arrays.asList(2.0, 5.0, 5.0), "Химия"),
                new Student("Name6", Arrays.asList(4.0, 5.0, 5.0), "Информатика"),
                new Student("Name7", Arrays.asList(1.0, 5.0, 5.0), "Информатика"),
                new Student("Name8", Arrays.asList(5.0, 5.0, 5.0), "Химия"),
                new Student("Name9", Arrays.asList(4.0, 5.0, 5.0), "Информатика"),
                new Student("Name10", Arrays.asList(4.0, 5.0, 4.7), "Информатика"),
                new Student("Name11", Arrays.asList(4.0, 5.0, 4.8), "Информатика")
        );

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getSpecialty().equals("Информатика"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .limit(5)
                .toList();

        filteredStudents.forEach(student -> System.out.println(student.getName() + " " +
                Math.round(student.getAverageGrade() * 100) / 100.0));
    }
}