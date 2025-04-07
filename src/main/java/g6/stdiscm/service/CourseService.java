package g6.stdiscm.service;  // Change package to "service"

import g6.stdiscm.model.Course;  // Import the Course entity
import g6.stdiscm.repository.CourseRepository;  // Import the repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAvailableCourses() {
        return courseRepository.findAll();
    }

    // Other business logic methods can be added here, such as enrolling a student, etc.
}