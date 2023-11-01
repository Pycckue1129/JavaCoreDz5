package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
//Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5,
// отсортированных по убыванию среднего балла.
//В решении не использовать циклы! Только StreamAPI
@Getter
@AllArgsConstructor
class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}
