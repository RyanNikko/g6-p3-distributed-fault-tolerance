package g6.stdiscm.repository;

import g6.stdiscm.model.Enrollment;
import g6.stdiscm.model.Course;
import g6.stdiscm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(User student);
    boolean existsByCourseAndStudent(Course course, User student);
}