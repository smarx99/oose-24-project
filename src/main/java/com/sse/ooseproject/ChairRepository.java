package com.sse.ooseproject;

import com.sse.ooseproject.models.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChairRepository extends JpaRepository<Chair, Long> {
    List<Chair> findByName(String name);
    List<Chair> findByChairOwnerId(long chairOwnerId);
    List<Chair> findByBuildingId(long buildingId);
}
