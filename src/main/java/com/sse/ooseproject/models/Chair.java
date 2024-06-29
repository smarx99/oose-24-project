package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "chair")
public class Chair extends OrganizationalUnit {

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee chairOwner;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    // Getter and setter methods
    public Employee getChairOwner() {
        return chairOwner;
    }

    public void setChairOwner(Employee chairOwner) {
        this.chairOwner = chairOwner;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
