package g6.stdiscm.controller;

import g6.stdiscm.model.Grade;
import g6.stdiscm.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;
    
    // POST endpoint 
    // for faculty to upload a grade for a student.
    @PostMapping("/upload")
    public Grade uploadGrade(@RequestParam String studentUsername,
                             @RequestParam Long courseId,
                             @RequestParam String gradeValue) {
        return gradeService.uploadGrade(studentUsername, courseId, gradeValue);
    }
    
    // GET endpoint 
    //for student to view their grades.
    @GetMapping("/{username}")
    public List<Grade> getGrades(@PathVariable String username) {
        return gradeService.getGradesForStudent(username);
    }
}