package bo;

import dao.IStudentDAO;
import dao.StudentDAO;
import model.Student;

import java.util.List;

public class StudentBO implements IStudentBO {
    IStudentDAO iStudentDAO = new StudentDAO();
    @Override
    public List<Student> sellectAllStudent() {
        return iStudentDAO.sellectAllStudent();
    }

    @Override
    public void inserStudent( Student student) {

    }

}
