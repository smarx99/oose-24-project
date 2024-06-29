package com.sse.ooseproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.sse.ooseproject.models.Room;
import com.sse.ooseproject.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/rooms")
    public String rooms(@RequestParam(value = "sort_by", defaultValue = "number") String sortBy,
                        @RequestParam(value = "sort_asc", defaultValue = "true") boolean sortAsc,
                        Model model) {

        List<Room> rooms = roomRepository.findAll();

        Comparator<Room> comparator;
        switch (sortBy) {
            case "id":
                comparator = Comparator.comparing(Room::getId);
                break;
            case "seats":
                comparator = Comparator.comparing(Room::getSeats);
                break;
            case "is_auditorium":
                comparator = Comparator.comparing(Room::getIsAuditorium);
                break;
            case "building":
                comparator = Comparator.comparing(room -> room.getBuilding().getName());
                break;
            default:
                comparator = Comparator.comparing(Room::getNumber);
        }

        if (!sortAsc) {
            comparator = comparator.reversed();
        }

        List<Room> sortedRooms = rooms.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        model.addAttribute("rooms", sortedRooms);
        model.addAttribute("sort_by", sortBy);
        model.addAttribute("sort_asc", sortAsc);

        return "rooms";
    }
}
