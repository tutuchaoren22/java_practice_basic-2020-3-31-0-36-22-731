package repositories;

import entities.Course;
import entities.RoleInfo;
import entities.Student;
import entities.Teacher;
import util.QueryTable;
import util.UpdateTable;

import java.util.List;

public class ExamRepository implements ExamRepositoryI {
    @Override
    public RoleInfo userLogin(String name, String password) {
        String sql = "SELECT loginName,password,roleName FROM login WHERE loginName=? AND password=? ";
        return QueryTable.queryForLogin(sql, name, password);
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT id,name,gender,age FROM student";
        return QueryTable.queryForStudent(sql);
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT id,name,gender,age FROM student WHERE id=?";
        List<Student> student = QueryTable.queryForStudent(sql, id);
        assert student != null;
        return 0 == student.size() ? null : student.get(0);
    }

    @Override
    public Student getStudentByName(String name) {
        String sql = "SELECT id,name,gender,age FROM student WHERE name=?";
        List<Student> student = QueryTable.queryForStudent(sql, name);
        assert student != null;
        return 0 == student.size() ? null : student.get(0);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        String sql = "SELECT id,name,gender,age FROM teacher";
        return QueryTable.queryForTeacher(sql);
    }

    @Override
    public Teacher getTeacherById(int id) {
        String sql = "SELECT id,name,gender,age FROM teacher WHERE id=?";
        List<Teacher> teacher = QueryTable.queryForTeacher(sql, id);
        assert teacher != null;
        return 0 == teacher.size() ? null : teacher.get(0);
    }

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT id,courseName,teacherId FROM course";
        return QueryTable.queryForCourse(sql);
    }

    @Override
    public Course getCourseByName(String courseName) {
        String sql = "SELECT id,courseName,teacherId FROM course WHERE courseName=?";
        List<Course> courses = QueryTable.queryForCourse(sql, courseName);
        assert courses != null;
        return 0 == courses.size() ? null : courses.get(0);
    }

    @Override
    public List<Course> getCourseByTeacher(int teacherId) {
        String sql = "SELECT id,courseName,teacherId FROM course WHERE teacherId=?";
        return QueryTable.queryForCourse(sql, teacherId);
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO student(name,gender,age) values(?,?,?)";
        UpdateTable.update(sql, student.getName(), student.getGender(), student.getAge());
    }

    @Override
    public void addCourse(Course course) {
        String sql = "INSERT INTO course(courseName,teacherId) values(?,?)";
        UpdateTable.update(sql, course.getCourseName(), course.getTeacherId());
    }

    @Override
    public void deleteStudentById(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        UpdateTable.update(sql, id);
    }

    @Override
    public void deleteCourseById(int id) {
        String sql = "DELETE FROM course WHERE id=?";
        UpdateTable.update(sql, id);
    }

    @Override
    public void deleteTeacherById(int id) {
        String sql = "DELETE FROM teacher WHERE id=?";
        UpdateTable.update(sql, id);
    }

    @Override
    public void updateScoreByStudentId(int score, int id) {
        String sql = "UPDATE score SET score=? WHERE id=?";
        UpdateTable.update(sql, score, id);
    }
}
