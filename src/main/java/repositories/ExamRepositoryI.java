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
    Student getStudentByName(String name);

    List<Teacher> getAllTeachers();

    Teacher getTeacherById(int id);

    List<Course> getAllCourses();

    Course getCourseByName(String courseName);

    List<Course> getCourseByTeacher(int teacherId);

    void addStudent(Student student);

    void addCourse(Course course);

    //    void updateScoreByStudent();
    void deleteStudentById(int id);

    void deleteCourseById(int id);

    void deleteTeacherById(int id);

    void updateScoreByStudentId(int score, int id);
}
