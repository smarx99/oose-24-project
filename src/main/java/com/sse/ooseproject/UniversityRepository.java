package com.sse.ooseproject;

import com.sse.ooseproject.models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findByName(String name);
}
