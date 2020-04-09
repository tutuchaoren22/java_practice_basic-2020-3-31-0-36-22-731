package services;

import entities.Course;
import entities.RoleInfo;
import entities.Student;
import entities.Teacher;
import repositories.ExamRepository;
import repositories.ExamRepositoryI;

import java.util.List;

public class ExamService {
    private ExamRepositoryI examRepository = new ExamRepository();

    public RoleInfo userLogin(String name, String password) {
        return examRepository.userLogin(name, password);
    }

    public Student getStudentById(int id) {
        return examRepository.getStudentById(id);
    }

    //1.1.1 所有学生信息
    public void getAllStudents() {
        List<Student> students = examRepository.getAllStudents();
        System.out.println(students.size());
        for (Student student : students) {
            System.out.println(String.format("学号：%d,姓名：%s, 年龄：%d, 性别：%s",
                    student.getId(), student.getName(), student.getAge(), student.getGender()));
        }
    }

    //1.1.2 指定学生姓名的信息以及所有课程的成绩
    public void getStudentInfoForName(String name) {
        Student student = examRepository.getStudentByName(name);
        System.out.println(String.format("学号：%d,姓名：%s, 年龄：%d, 性别：%s",
                student.getId(), student.getName(), student.getAge(), student.getGender()));
    }

    //1.1.3 指定老师的所有学生及其成绩
    public void getStudentInfoForTeacher(int teacherId) {

    }

    //1.2.1 所有课程信息
    public void getAllCourses() {
        List<Course> courses = examRepository.getAllCourses();
        for (Course course : courses) {
            System.out.println(String.format("课程编号：%d,课程名称：%s, 授课教师：%s",
                    course.getId(), course.getCourseName(), course.getTeacherId()));
        }
    }

    //1.2.2 指定课程名称的信息
    public void getCourseForName(String courseName) {
        Course course = examRepository.getCourseByName(courseName);
        System.out.println(String.format("课程编号：%d,课程名称：%s, 授课教师：%s",
                course.getId(), course.getCourseName(), course.getTeacherId()));
    }

    //1.2.3 指定老师的所有课程信息
    public void getCourseForTeacher(int teacherId) {
        List<Course> courses = examRepository.getCourseByTeacher(teacherId);
        for (Course course : courses) {
            System.out.println(String.format("课程编号：%d,课程名称：%s", course.getId(), course.getCourseName()));
        }
    }

    //1.3.1 所有老师信息
    public void getAllTeachers() {
        List<Teacher> teachers = examRepository.getAllTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(String.format("工号：%d,姓名：%s, 年龄：%d, 性别：%s",
                    teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getGender()));
        }
    }

    //1.3.2 指定老师信息
    public void getTeacherForId(int teacherId) {
        Teacher teacher = examRepository.getTeacherById(teacherId);
        System.out.println(String.format("工号：%d,姓名：%s, 年龄：%d, 性别：%s",
                teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getGender()));
    }

    //2.1 新增学生信息
    public void addStudent(Student student) {
        examRepository.addStudent(student);
    }

    //2.2 新增课程信息
    public void addCourse(Course course) {
        examRepository.addCourse(course);
    }

    //3.1 修改指定学生的成绩
    public void updateScoreForStudent(int score, int studentId) {
        examRepository.updateScoreByStudentId(score, studentId);
    }

    //4.1 删除指定学生
    public void deleteStudentForId(int studentId) {
        examRepository.deleteStudentById(studentId);
    }

    //4.2 删除指定课程
    public void deleteCourseForId(int courseId) {
        examRepository.deleteCourseById(courseId);
    }

    //4.3 删除指定老师
    public void deleteTeacherForId(int teacherId) {
        examRepository.deleteTeacherById(teacherId);
    }

}
