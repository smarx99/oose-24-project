package com.sse.ooseproject;

import com.sse.ooseproject.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> findByName(String name);
    List<Building> findByUniversityId(long universityId);
}
