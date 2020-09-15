package dao;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IDAOMatBang {
    List<MatBang> danhSachMatBang();

    void themMoiThongTin(MatBang matBang) throws SQLException;

    MatBang findByID(String maMatBang);

//    void update(MatBang matBang);

    void delete(String MaMatBang);

    List<MatBang> searchByName(String matBang);
    List<MatBang> searchTang(String tang);
    List<MatBang> searchTheoGia(String gia);

}
