package bo;

import dao.DAOMatBang;
import dao.IDAOMatBang;
import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public class BOMatBang implements IBOMatBang {
    IDAOMatBang idaoMatBang = new DAOMatBang();
    @Override
    public List<MatBang> danhSachMatBang() {
        return idaoMatBang.danhSachMatBang();
    }

    @Override
    public void themMoiThongTin(MatBang matBang) throws SQLException {
        idaoMatBang.themMoiThongTin(matBang);
    }

    @Override
    public MatBang findByID(String maMatBang) {
        return null;
    }

    @Override
    public void delete(String maMatBang) {
        idaoMatBang.delete(maMatBang);
    }

    @Override
    public List<MatBang> searchByName(String matBang) {

        return idaoMatBang.searchByName(matBang);
    }

    @Override
    public List<MatBang> searchTang(String matBang) {
        return idaoMatBang.searchTang(matBang);
    }

    @Override
    public List<MatBang> searchGia(String gia) {
        return idaoMatBang.searchTheoGia(gia);
    }
}
