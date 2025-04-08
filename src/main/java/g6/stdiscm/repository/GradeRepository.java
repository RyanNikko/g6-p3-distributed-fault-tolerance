package g6.stdiscm.repository;

import g6.stdiscm.model.Grade;
import g6.stdiscm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudent(User student);
}