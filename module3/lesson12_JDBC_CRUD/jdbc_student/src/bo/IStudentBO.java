package bo;

import model.Student;

import java.util.List;

public interface IStudentBO {
    public List<Student> sellectAllStudent ();

    public void inserStudent(Student student);
}
