package thi_ket_thuc_thuc_hanh;

import lesson_last_case_study.yeu_cau_7.commons.ReadWriteFile;
import lesson_last_case_study.yeu_cau_7.controllers.MainController;
import lesson_last_case_study.yeu_cau_7.models.*;
import lesson_student.MainStudent;
import lesson_student.Stundent;

import java.io.*;
import java.util.List;

public class DocVietSanPham {

    public static String[] mangThongTin;


    public static List<String> docSanPhamXuatKhau(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                mangThongTin = line.split(",");
                if (filePath.equals(ChayChuongTrinh.THU_MUC_SAN_PHAM)) {
                    String id = DocVietSanPham.mangThongTin[0];
                    String maSP = DocVietSanPham.mangThongTin[1];
                    String tenSP = DocVietSanPham.mangThongTin[2];
                    String giaSP = DocVietSanPham.mangThongTin[3];
                    String soLuongSP = DocVietSanPham.mangThongTin[4];
                    String nhaSanXuat = DocVietSanPham.mangThongTin[5];
                    String giaXuatKhau = DocVietSanPham.mangThongTin[6];
                    String quocGiaNhapSanPham = DocVietSanPham.mangThongTin[7];

                    ChayChuongTrinh.sanPhamXuatKhauList.add(new SanPhamXuatKhau(Integer.parseInt(id), maSP, tenSP
                            , Double.parseDouble(giaSP), Integer.parseInt(soLuongSP), nhaSanXuat, Double.parseDouble(giaXuatKhau), quocGiaNhapSanPham)
                    );

                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> docSanPhamNhapKhau(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                mangThongTin = line.split(",");
                if (filePath.equals(ChayChuongTrinh.THU_MUC_SAN_PHAM)) {
                    String id = DocVietSanPham.mangThongTin[0];
                    String maSP = DocVietSanPham.mangThongTin[1];
                    String tenSP = DocVietSanPham.mangThongTin[2];
                    String giaSP = DocVietSanPham.mangThongTin[3];
                    String soLuongSP = DocVietSanPham.mangThongTin[4];
                    String nhaSanXuat = DocVietSanPham.mangThongTin[5];
                    String giaNhapKhau = DocVietSanPham.mangThongTin[6];
                    String tinhThanhNhap = DocVietSanPham.mangThongTin[7];
                    String thueNhapKhau = DocVietSanPham.mangThongTin[8];

                    ChayChuongTrinh.sanPhamNhapKhauList.add(new SanPhamNhapKhau(Integer.parseInt(id), maSP, tenSP
                            , Double.parseDouble(giaSP), Integer.parseInt(soLuongSP), nhaSanXuat, Double.parseDouble(giaNhapKhau), thueNhapKhau, Double.parseDouble(thueNhapKhau)) {
                    });

                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void vietThuMuc(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("Thư mục không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void luuThuMucMoi(String str, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("Thư mục không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

