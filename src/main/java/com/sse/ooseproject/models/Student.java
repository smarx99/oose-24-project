package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {

    private String matNr;
    private String studySubject;

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
}
