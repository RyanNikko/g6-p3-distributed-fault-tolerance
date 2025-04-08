package g6.stdiscm.service;  // Change package to "service"

import g6.stdiscm.model.Course;  // Import the Course entity
import g6.stdiscm.repository.CourseRepository;  // Import the repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAvailableCourses() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Other business logic methods can be added here, such as enrolling a student, etc.
}