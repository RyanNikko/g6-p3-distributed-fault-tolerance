package g6.stdiscm.model;

import jakarta.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;
    
    // ex. 'A', 'B+'
    private String gradeValue; 

    public Grade() { }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public User getStudent() {
        return student;
    }
    
    public void setStudent(User student) {
        this.student = student;
    }
    
    public String getGradeValue() {
        return gradeValue;
    }
    
    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }
}
