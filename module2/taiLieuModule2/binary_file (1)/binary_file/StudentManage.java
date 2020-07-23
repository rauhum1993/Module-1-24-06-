package binary_file;

import java.util.ArrayList;
import java.util.List;

public class StudentManage {

    private List<Student> studentList;


    public StudentManage() {
        studentList = new ArrayList<>();
    }

    public StudentManage(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;

    }

    public void showStudentList() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public boolean addNewStudent(Student student) {
        return this.studentList.add(student);
    }

    public boolean updateStudent(String name, Student newStudent) {
        // lay ra index cua Student co name la XXX trong List student
        int index = this.studentList.indexOf(new Student(name));

        // neu co ten student trong danh sach thi update
        if (index != -1) {
            this.studentList.set(index, newStudent);
            return true;
        }
        return false;
    }
}
