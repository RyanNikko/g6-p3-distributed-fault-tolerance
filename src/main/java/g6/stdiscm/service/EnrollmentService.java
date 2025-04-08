package g6.stdiscm.service;

import g6.stdiscm.model.Enrollment;
import g6.stdiscm.model.Course;
import g6.stdiscm.model.User;
import g6.stdiscm.repository.EnrollmentRepository;
import g6.stdiscm.repository.CourseRepository;
import g6.stdiscm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Enrollment enrollStudent(String username, Long courseId) {

        User student = userRepository.findByUsername(username);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (!courseOpt.isPresent()) {
            throw new RuntimeException("Course not found");
        }

        Course course = courseOpt.get();
        if (enrollmentRepository.existsByCourseAndStudent(course, student)){
            throw new RuntimeException("Already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.setEnrollmentDate(new Date());
        
        return enrollmentRepository.save(enrollment);
    }
    
    public List<Enrollment> getEnrollmentsByStudent(String username) {
        User student = userRepository.findByUsername(username);
        return enrollmentRepository.findByStudent(student);
    }
}