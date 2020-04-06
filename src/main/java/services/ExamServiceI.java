package services;

import entities.RoleInfo;
import entities.Student;

import java.util.List;

public interface ExamServiceI {
    RoleInfo userLogin(String name, String password);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void deleteStudentById(int id);
}
