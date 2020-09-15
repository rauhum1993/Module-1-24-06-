package dao;

import model.MatBang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMatBang implements IDAOMatBang {
    private BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_MAT_BANG= "select * from mat_bang";
    private static final String CREATE_NEW_MAT_BANG= "INSERT INTO mat_bang" + "  (ma_mat_bang,trang_thai,dien_tich,tang,loai_van_phong,gia_tien,ngay_bat_dau,ngay_ket_thuc)" +
            " VALUES " + " (?,?,?,?,?,?,?,?);";
    private static String DELETE_MAT_HANG_BY_ID = "delete from mat_bang where ma_mat_bang=?";
    private static String SEARCH_LOAI_MAT_BANG = "select * from mat_bang where loai_van_phong like ?";
    private static String SEARCH_TANG = "select * from mat_bang where tang like ?";
    private static String SEARCH_GIA_CHO_THUE = "select * from mat_bang where gia_tien like ?";

    @Override
    public List<MatBang> danhSachMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_MAT_BANG);
            ResultSet rs = preparedStatement.executeQuery();
//            ma_mat_bang,trang_thai,dien_tich,tang,loai_van_phong,gia_tien,ngay_bat_dau,ngay_ket_thuc)
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                String dienTich = rs.getString("dien_tich");
                String tang = rs.getString("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String giaTien = rs.getString("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");

                matBangList.add(new MatBang(maMatBang, trangThai, dienTich, tang, loaiVanPhong, giaTien, ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return matBangList;
    }

    @Override
    public void themMoiThongTin(MatBang matBang) throws SQLException {
        PreparedStatement  preparedStatement = this.baseDAO.getConnection().prepareStatement(CREATE_NEW_MAT_BANG);
        preparedStatement.setString(1, matBang.getMaMatBang());
        preparedStatement.setString(2, matBang.getTrangThai());
        preparedStatement.setString(3, matBang.getDienTich());
        preparedStatement.setString(4, matBang.getTang());
        preparedStatement.setString(5, matBang.getLoaiVanPhong());
        preparedStatement.setString(6, matBang.getGiaTien());
        preparedStatement.setString(7, matBang.getNgayBatDau());
        preparedStatement.setString(8, matBang.getNgayKetThuc());

        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    @Override
    public MatBang findByID(String maMatBang) {
        return null;
    }

    @Override
    public void delete(String maMatBang) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_MAT_HANG_BY_ID);
            preparedStatement.setString(1,maMatBang);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MatBang> searchByName(String loaiMatBang) {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_LOAI_MAT_BANG);
            preparedStatement.setString(1, "%" + loaiMatBang + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                String dienTich = rs.getString("dien_tich");
                String tang = rs.getString("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String giaTien = rs.getString("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");

                matBangList.add(new MatBang(maMatBang, trangThai, dienTich, tang, loaiVanPhong, giaTien, ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> searchTang(String tang) {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_TANG);
            preparedStatement.setString(1, "%" + tang + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                String dienTich = rs.getString("dien_tich");
                String tang1 = rs.getString("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String giaTien = rs.getString("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");

                matBangList.add(new MatBang(maMatBang, trangThai, dienTich, tang1, loaiVanPhong, giaTien, ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public List<MatBang> searchTheoGia(String gia) {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SEARCH_GIA_CHO_THUE);
            preparedStatement.setString(1, "%" + gia + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String maMatBang = rs.getString("ma_mat_bang");
                String trangThai = rs.getString("trang_thai");
                String dienTich = rs.getString("dien_tich");
                String tang1 = rs.getString("tang");
                String loaiVanPhong = rs.getString("loai_van_phong");
                String giaTien = rs.getString("gia_tien");
                String ngayBatDau = rs.getString("ngay_bat_dau");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");

                matBangList.add(new MatBang(maMatBang, trangThai, dienTich, tang1, loaiVanPhong, giaTien, ngayBatDau,ngayKetThuc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }
}
