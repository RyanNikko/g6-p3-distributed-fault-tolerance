package g6.stdiscm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import g6.stdiscm.model.Grade;
import g6.stdiscm.model.Course;
import g6.stdiscm.model.User;
import g6.stdiscm.repository.GradeRepository;
import g6.stdiscm.repository.CourseRepository;
import g6.stdiscm.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Grade uploadGrade(String studentUsername, Long courseId, String gradeValue) {

        User student = userRepository.findByUsername(studentUsername);
        Optional<Course> courseOpt = courseRepository.findById(courseId);

        if (!courseOpt.isPresent()) {
            throw new RuntimeException("Course not found");
        }

        Course course = courseOpt.get();
        Grade grade = new Grade();

        grade.setStudent(student);
        grade.setCourse(course);
        grade.setGradeValue(gradeValue);
        
        return gradeRepository.save(grade);
    }
    
    public List<Grade> getGradesForStudent(String username) {
        User student = userRepository.findByUsername(username);
        return gradeRepository.findByStudent(student);
    }
}