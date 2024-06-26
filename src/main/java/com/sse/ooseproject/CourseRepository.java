package com.sse.ooseproject;

import com.sse.ooseproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByChairId(long chairId);
}
