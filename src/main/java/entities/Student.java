package entities;

public class Student {
    int studentId;
    String name;
    String gender;
    String birthday;

    public Student() {
    }

    public Student(int studentId, String name, String gender, String birthday) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
