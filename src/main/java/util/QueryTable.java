package util;

import entities.Course;
import entities.Student;
import entities.Teacher;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class QueryTable {
    public static List<Student> queryForStudent(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    Field field = Student.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(student, value);
                }
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, preparedStatement, resultSet);
        }
        return null;
    }

    public static List<Teacher> queryForTeacher(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            List<Teacher> teachers = new ArrayList<>();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    Field field = Teacher.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(teacher, value);
                }
                teachers.add(teacher);
            }
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, preparedStatement, resultSet);
        }
        return null;
    }

    public static List<Course> queryForCourse(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int count = resultSetMetaData.getColumnCount();
            List<Course> courses = new ArrayList<>();
            while (resultSet.next()) {
                Course course = new Course();
                for (int i = 0; i < count; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = resultSetMetaData.getColumnName(i + 1);
                    Field field = Course.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(course, value);
                }
                courses.add(course);
            }
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, preparedStatement, resultSet);
        }
        return null;
    }
}
