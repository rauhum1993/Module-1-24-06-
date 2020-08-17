package thi_ket_thuc_thuc_hanh;

public class SanPhamXuatKhau extends SanPham  {
    private double giaXuatKhau;
    private String quocGiaNhapSanPham;

    public SanPhamXuatKhau(int idSanPham, String maSanPham, String tenSanPham,
                           double giaSanPham, int soLuongSanPham, String nhaSanXuat,
                           double giaXuatKhau, String quocGiaNhapSanPham) {
        super(idSanPham, maSanPham, tenSanPham, giaSanPham, soLuongSanPham, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\tGiá sản phẩm" + getGiaSanPham()+
                "\tQuốc gia nhập sản phẩm" + getGiaSanPham();

    }
}
