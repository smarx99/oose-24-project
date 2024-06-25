package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "employee")
public class Employee extends Person {
    private String staffNr;
    private boolean isProfessor;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "employee")
    private List<TeachingShift> teachingShifts;

    // Empty constructor required by Spring
    public Employee() {}

    // Constructor with parameters
    public Employee(String firstName, String lastName, String email, String staffNr, boolean isProfessor) {
        super(firstName, lastName, email);
        this.staffNr = staffNr;
        this.isProfessor = isProfessor;
    }

    // Getter and setter methods
    public String getStaffNr() {
        return staffNr;
    }

    public void setStaffNr(String staffNr) {
        this.staffNr = staffNr;
    }

    public boolean getIsProfessor() {
        return isProfessor;
    }

    public void setIsProfessor(boolean isProfessor) {
        this.isProfessor = isProfessor;
    }

    public List<TeachingShift> getTeachingShifts() {
        return teachingShifts;
    }

    public void setTeachingShifts(List<TeachingShift> teachingShifts) {
        this.teachingShifts = teachingShifts;
    }
}

