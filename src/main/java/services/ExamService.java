package services;

import entities.RoleInfo;
import entities.Student;
import repositories.ExamRepository;
import repositories.ExamRepositoryI;

import java.util.List;

public class ExamService implements ExamServiceI {
    private ExamRepositoryI examRepository = new ExamRepository();

    @Override
    public RoleInfo userLogin(String name, String password) {
        return examRepository.userLogin(name,password);
    }

    @Override
    public List<Student> getAllStudents() {
        return examRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return examRepository.getStudentById(id);
    }

    @Override
    public void addStudent(Student student) {
        examRepository.addStudent(student);
    }

    @Override
    public void deleteStudentById(int id) {
        examRepository.deleteStudentById(id);
    }
}
