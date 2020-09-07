package dao;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_STUDENT = "select* from student";
    private static final String CREATE_NEW_STUDENT = "INSERT INTO student" + "  (id,name,address) VALUES " +
            " (?, ?, ?);";

    @Override
    public void insertStudent(Student student) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_STUDENT);
            preparedStatement.setString(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(1,student.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> sellectAllStudent() {
        List<Student> studentList= new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_STUDENT);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                String id = rs.getString("student_id");
                String name = rs.getString("student_name");
                String address = rs.getString("student_address");
                studentList.add(new Student(id,name,address));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
