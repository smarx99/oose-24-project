package com.sse.ooseproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sse.ooseproject.models.Student;
import com.sse.ooseproject.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String students(@RequestParam(value = "sort_by", defaultValue = "firstName") String sortBy,
                           @RequestParam(value = "sort_asc", defaultValue = "true") boolean sortAsc,
                           Model model) {

        List<Student> students = studentRepository.findAll();

        Comparator<Student> comparator;
        switch (sortBy) {
            case "lastName":
                comparator = Comparator.comparing(Student::getLastName);
                break;
            case "email":
                comparator = Comparator.comparing(Student::getEmail);
                break;
            case "matNr":
                comparator = Comparator.comparing(Student::getMatNr);
                break;
            default:
                comparator = Comparator.comparing(Student::getFirstName);
        }

        if (!sortAsc) {
            comparator = comparator.reversed();
        }

        List<Student> sortedStudents = students.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        model.addAttribute("students", sortedStudents);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        // Returning the name of a view (found in resources/templates) as a string lets this endpoint return that view.
        return "students";
    }
}
