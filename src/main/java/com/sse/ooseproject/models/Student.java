package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends Person {

    private String matNr;
    private String studySubject;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;

    // Empty constructor required by Spring
    public Student() {}

    // Constructor with parameters
    public Student(String firstName, String lastName, String email, String matNr, String studySubject) {
        super(firstName, lastName, email);
        this.matNr = matNr;
        this.studySubject = studySubject;
    }

    // Getter and setter methods
    public String getMatNr() {
        return matNr;
    }

    public void setMatNr(String matNr) {
        this.matNr = matNr;
    }

    public String getStudySubject() {
        return studySubject;
    }

    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
