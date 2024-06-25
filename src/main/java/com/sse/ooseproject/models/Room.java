package com.sse.ooseproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Column(name = "number_of_seats")
    private Integer seats = 0;  // Default value to avoid null assignment

    @Column(name = "is_auditorium")
    private boolean isAuditorium;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<RoomOccupancy> occupancies;

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getSeats() {
        return seats != null ? seats : 0; // Return default value if null
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean getIsAuditorium() {
        return isAuditorium;
    }

    public void setIsAuditorium(boolean isAuditorium) {
        this.isAuditorium = isAuditorium;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<RoomOccupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(List<RoomOccupancy> occupancies) {
        this.occupancies = occupancies;
    }
}
