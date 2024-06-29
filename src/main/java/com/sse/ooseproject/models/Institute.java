package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "institute")
public class Institute extends OrganizationalUnit {

    private String providesStudySubject;

    // Getter and setter methods
    public String getProvidesStudySubject() {
        return providesStudySubject;
    }

    public void setProvidesStudySubject(String providesStudySubject) {
        this.providesStudySubject = providesStudySubject;
    }
}
