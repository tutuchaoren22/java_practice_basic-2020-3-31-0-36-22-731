package controllers;

import entities.RoleInfo;
import entities.Student;
import repositories.ExamRepository;
import repositories.ExamRepositoryI;
import services.ExamService;
import services.ExamServiceI;

import java.util.List;

public class ExamController {
    private ExamServiceI examService = new ExamService();

    public RoleInfo userLogin(String name, String password) {
        return examService.userLogin(name,password);
    }

    public List<Student> getAllStudents() {
        return examService.getAllStudents();
    }
    public Student getStudentById(int id) {
        return examService.getStudentById(id);
    }

    public void addStudent(Student student) {
        examService.addStudent(student);
    }

    public void deleteStudentById(int id) {
        examService.deleteStudentById(id);
    }
}
