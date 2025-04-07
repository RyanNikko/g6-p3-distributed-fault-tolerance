package g6.stdiscm.controller;  // Change package to "controller"

import g6.stdiscm.model.Course;  // Import the Course entity
import g6.stdiscm.service.CourseService;  // Import the service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAvailableCourses();
    }
}
