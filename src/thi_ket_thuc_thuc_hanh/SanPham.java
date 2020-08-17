package thi_ket_thuc_thuc_hanh;

public abstract class SanPham {
    private int idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private double giaSanPham;

    private int soLuongSanPham;
    private String nhaSanXuat;

    public SanPham(int idSanPham, String maSanPham, String tenSanPham,
                   double giaSanPham,  int soLuongSanPham, String nhaSanXuat) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;

        this.soLuongSanPham = soLuongSanPham;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    @Override
    public String toString() {
        return
                "idSanPham='" + idSanPham + '\'' +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaSanPham='" + giaSanPham + '\'' +
                ", soLuongSanPham=" + soLuongSanPham +
                ", nhaSanXuat='" + nhaSanXuat + '\''
                ;
    }
}
