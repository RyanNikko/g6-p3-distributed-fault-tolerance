package g6.stdiscm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import g6.stdiscm.model.Enrollment;
import g6.stdiscm.service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;
    
    // POST endpoint for a student to enroll in a course.
    // take note: better if the username would come from the authenticated user.
    @PostMapping
    public Enrollment enroll(@RequestParam String username, @RequestParam Long courseId) {
        return enrollmentService.enrollStudent(username, courseId);
    }
    
    // GET endpoint
    // for student to view enrollment
    @GetMapping("/{username}")
    public List<Enrollment> getEnrollments(@PathVariable String username) {
        return enrollmentService.getEnrollmentsByStudent(username);
    }
}
