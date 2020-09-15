package thi_ket_thuc_thuc_hanh;

public class SanPhamNhapKhau extends SanPham {
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau(int idSanPham, String maSanPham, String tenSanPham, double giaSanPham,
                           int soLuongSanPham, String nhaSanXuat,
                           double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(idSanPham, maSanPham, tenSanPham, giaSanPham, soLuongSanPham, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }


    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "giaNhapKhau='" + giaNhapKhau + '\'' +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau='" + thueNhapKhau + '\''
                ;
    }
}
