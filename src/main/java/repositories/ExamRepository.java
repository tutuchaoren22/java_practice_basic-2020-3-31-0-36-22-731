package repositories;

import entities.RoleInfo;
import entities.Student;
import util.QueryTable;
import util.UpdateTable;

import java.util.List;

public class ExamRepository implements ExamRepositoryI{
    @Override
    public RoleInfo userLogin(String name, String password) {
        String sql = "SELECT loginName,password,roleName FROM login WHERE loginName=? AND password=? ";
        return QueryTable.queryForLogin(sql,name,password);
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT id,name,gender,age FROM student";
        return QueryTable.queryForStudent(sql);
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT name,gender,age FROM student WHERE id=?";
        return QueryTable.queryForStudent(sql,id).get(0);
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO student(name,gender,age) values(?,?,?)";
        UpdateTable.update(sql, student.getName(), student.getGender(),student.getAge());
    }

    @Override
    public void deleteStudentById(int id) {
        String sql = "DELETE FROM student WHERE id=?";
        UpdateTable.update(sql, id);
    }
}
