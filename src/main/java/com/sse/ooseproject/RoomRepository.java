package com.sse.ooseproject;

import com.sse.ooseproject.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
        List<Room> findByNumber(String number);
        List<Room> findByBuildingId(long buildingId);
}
