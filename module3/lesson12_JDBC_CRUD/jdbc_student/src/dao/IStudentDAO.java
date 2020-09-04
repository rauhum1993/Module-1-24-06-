package dao;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    public void insertStudent(Student student);

    public List<Student> sellectAllStudent();
}
