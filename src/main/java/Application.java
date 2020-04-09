import entities.Course;
import services.ExamService;
import entities.RoleInfo;
import entities.Student;

import java.util.Scanner;

public class Application {
    private static String operationOfAdmin = "您好，超级管理员，请选择你需要进行的操作：\n" +
            "    1. 查询   \n" +
            "      1.1 查询学生信息以及成绩  \n" +
            "        1.1.1 所有学生信息  \n" +
            "        1.1.2 指定学生姓名的信息以及所有课程的成绩  \n" +
            "        1.1.3 指定老师的所有学生及其成绩  \n" +
            "      1.2 查询课程信息  \n" +
            "        1.2.1 所有课程信息  \n" +
            "        1.2.2 指定课程名称的信息  \n" +
            "        1.2.3 指定老师的所有课程信息   \n" +
            "      1.3 查询老师信息  \n" +
            "        1.3.1 所有老师信息  \n" +
            "        1.3.2 指定老师信息  \n" +
            "    2. 新增  \n" +
            "      2.1 新增学生信息  \n" +
            "      2.2 新增课程信息     \n" +
            "    3. 修改    \n" +
            "      3.1 修改指定学生的成绩  \n" +
            "    4. 删除  \n" +
            "      4.1 删除指定学生  \n" +
            "      4.2 删除指定课程  \n" +
            "      4.3 删除指定老师  \n" +
            "    5. 退出  \n";
    private static Scanner scanner = new Scanner(System.in);
    private static ExamService examService = new ExamService();
    private static boolean isExist = false;

    public static void main(String[] args) {
        System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码):");
        String[] input = scanner.nextLine().split(":");
        RoleInfo loginRole = examService.userLogin(input[0], input[1]);
        System.out.println(loginRole);
        if (loginRole != null) {
            if (loginRole.getRoleName().equals("管理员")) {
                while (!isExist) {
                    System.out.println(operationOfAdmin);
                    operateForInput(scanner.nextLine());
                }
            } else {
                System.out.println("该账号没有权限！");
            }
        } else {
            System.out.println("用户名或者密码错误");
        }

    }

    public static void operateForInput(String input) {
        switch (input) {
            case "1.1.1":
                examService.getAllStudents();
                break;
            case "1.1.2":
                System.out.println("请输入学生姓名：");
                examService.getStudentInfoForName(scanner.next());
                break;
            case "1.1.3":
                System.out.println("请输入教师编号：");
                examService.getStudentInfoForTeacher(scanner.nextInt());
                break;
            case "1.2.1":
                examService.getAllCourses();
                break;
            case "1.2.2":
                System.out.println("请输入课程名称：");
                examService.getCourseForName(scanner.next());
                break;
            case "1.2.3":
                System.out.println("请输入教师编号：");
                examService.getCourseForTeacher(scanner.nextInt());
                break;
            case "1.3.1":
                examService.getAllTeachers();
                break;
            case "1.3.2":
                System.out.println("请输入教师编号：");
                examService.getTeacherForId(scanner.nextInt());
                break;
            case "2.1":
                System.out.println("请输入学生信息(例如：学号：1,姓名：小明,年龄：18,性别：男)：");
                String[] inputStudentInfo = scanner.next().split("[：,]");
                Student studentToAdd = new Student(Integer.parseInt(inputStudentInfo[1]), inputStudentInfo[3], inputStudentInfo[7], Integer.parseInt(inputStudentInfo[5]));
                examService.addStudent(studentToAdd);
                System.out.println(String.format("添加学生[%s和%d]成功！", studentToAdd.getName(), studentToAdd.getId()));
                break;
            case "2.2":
                System.out.println("请输入课程信息(例如：课程名称：数学,授课老师编号：2");
                String[] inputCourseInfo = scanner.next().split("[：,]");
                Course courseToAdd = new Course(inputCourseInfo[1], Integer.parseInt(inputCourseInfo[3]));
                examService.addCourse(courseToAdd);
                System.out.println(String.format("添加课程[%s]成功！", courseToAdd.getCourseName()));
                break;
            case "3.1":
                System.out.println("请输入成绩和学生编号信息(例如：99,2");
                String[] inputScoreInfo = scanner.next().split(",");
                examService.updateScoreForStudent(Integer.parseInt(inputScoreInfo[0]), Integer.parseInt(inputScoreInfo[1]));
                System.out.println("修改成功！");
                break;
            case "4.1":
                System.out.println("请输入您需要删除的学生学号：");
                int inputStudentIdToDelete = scanner.nextInt();
                System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？");
                System.out.println("1:是\n2:否");
                if (1 == scanner.nextInt()) {
                    Student studentToDelete = examService.getStudentById(inputStudentIdToDelete);
                    examService.deleteStudentForId(inputStudentIdToDelete);
                    System.out.println(String.format("删除学生[%s和%d]成功！", studentToDelete.getName(), studentToDelete.getId()));
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case "4.2":
                System.out.println("请输入您需要删除的课程编号：");
                int inputCourseIdToDelete = scanner.nextInt();
                System.out.println("删除课程之后，该课程信息将不能恢复，是否要继续删除？");
                System.out.println("1:是\n2:否");
                if (1 == scanner.nextInt()) {
                    examService.deleteCourseForId(inputCourseIdToDelete);
                    System.out.println("删除课程成功！");
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case "4.3":
                System.out.println("请输入您需要删除的教师工号：");
                int inputTeacherIdToDelete = scanner.nextInt();
                System.out.println("删除教师之后，该教师信息将不能恢复，是否要继续删除？");
                System.out.println("1:是\n2:否");
                if (1 == scanner.nextInt()) {
                    examService.deleteTeacherForId(inputTeacherIdToDelete);
                    System.out.println("删除教师成功！");
                } else {
                    System.out.println("删除失败！");
                }
                break;
            case "5":
                isExist = true;
                break;
            default:
                System.out.println("请输入正确的序号");
        }
    }

}
