package bo;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IBOMatBang {
    List<MatBang> danhSachMatBang();

    void themMoiThongTin(MatBang matBang) throws SQLException;

    MatBang findByID(String maMatBang);

//    void update(MatBang matBang);

    void delete(String MaMatBang);

    List<MatBang> searchByName(String matBang);
    List<MatBang> searchTang(String matBang);
    List<MatBang> searchGia(String matBang);
}
