package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {

    private String matNr;
    private String studySubject;

    public Student() {}

    public Student(String firstName, String lastName, String email, String matNr, String studySubject) {
        super(firstName, lastName, email);
        this.matNr = matNr;
        this.studySubject = studySubject;
    }

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
