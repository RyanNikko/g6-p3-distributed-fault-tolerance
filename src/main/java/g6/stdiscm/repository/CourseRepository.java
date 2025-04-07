package g6.stdiscm.repository;  // Change package to "repository"

import g6.stdiscm.model.Course;  // Import the Course entity
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // You can add custom query methods if needed, e.g., find courses by instructor, etc.
}