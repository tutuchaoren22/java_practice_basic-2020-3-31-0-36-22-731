package repositories;

import entities.Course;
import entities.RoleInfo;
import entities.Student;
import entities.Teacher;

import java.util.List;

public interface ExamRepositoryI {
    RoleInfo userLogin(String name, String password);
    List<Student> getAllStudents();
    Student getStudentById(int id);
//    List<Teacher> getAllTeachers();
//    List<Course> getAllSCourses();
    void addStudent(Student student);
//    void updateScoreByStudent();
    void deleteStudentById(int id);
//    void deleteCourseById();
//    void deleteTeacherById();
}
