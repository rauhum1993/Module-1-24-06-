package thi_ket_thuc_thuc_hanh;

import lesson_last_case_study.yeu_cau_7.models.Villa;
import lesson_student.ReadWriteFileStudent;
import lesson_student.Sort;
import lesson_student.Stundent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChayChuongTrinh {


    public static List<SanPhamXuatKhau> sanPhamXuatKhauList = new ArrayList<>();
    public static List<SanPhamNhapKhau> sanPhamNhapKhauList = new ArrayList<>();
    public static int id = 1;

    public static final String THU_MUC_SAN_PHAM = "src/thi_ket_thuc_thuc_hanh/data/products.csv";

    public static void main(String[] args) {
        hienThiDanhMucLuaChon();
    }

    private static void hienThiDanhMucLuaChon() {
        Scanner scanner = new Scanner(System.in);
        int choose;

        do {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM---" + "\n" +
                    "1. Thêm mới." + "\n" +
                    "2. Xóa." + "\n" +
                    "3. Xem danh sách các sản phẩm . " + "\n" +
                    "4. Tìm kiếm . " + "\n" +
                    "5. Thoát ." + "\n");

            System.out.println("");
            System.out.print("Chọn chức năng : ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    themMoiSanPham();
                    break;
                case 2:
                    danhSachSanPham();
                    break;
                case 3:
                    danhSachSanPham();
                    break;
                case 4:
                    danhSachSanPham();
                    timKiemSanPham();

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lại.  ");
            }

        } while (choose != 0);
    }

    private static void timKiemSanPham() {
    }

    private static void danhSachSanPham() {
        sanPhamXuatKhauList.clear();
//        sanPhamNhapKhauList.clear();
        DocVietSanPham.docSanPhamXuatKhau(THU_MUC_SAN_PHAM);
//        DocVietSanPham.docSanPhamNhapKhau(THU_MUC_SAN_PHAM);
//        SanPhamNhapKhau sanPhamNhapKhau = null;
        SanPhamXuatKhau sanPhamXuatKhau = null;
//        for (int i = 0; i < sanPhamNhapKhauList.size(); i++) {
//            sanPhamNhapKhau = sanPhamNhapKhauList.get(i);
//            System.out.println(sanPhamNhapKhau.toString());
//        }
        for (int i = 0; i < sanPhamXuatKhauList.size(); i++) {
            sanPhamXuatKhau = sanPhamXuatKhauList.get(i);
            System.out.println(sanPhamXuatKhau.toString());
        }

    }

//    private static void xoaSanPham() {
//        Scanner scanner= new Scanner(System.in);
//
//
//        sanPhamXuatKhauList.clear();
//        sanPhamNhapKhauList.clear();
//        DocVietSanPham.docSanPhamXuatKhau(THU_MUC_SAN_PHAM);
//        DocVietSanPham.docSanPhamNhapKhau(THU_MUC_SAN_PHAM);
//        SanPhamNhapKhau sanPhamNhapKhau = null;
//        SanPhamXuatKhau sanPhamXuatKhau = null;
//
//        boolean check;
//        System.out.println("Nhập mã sản phẩm muốn xóa: ");
//        String maSP= s;
//        for(int i=0;i<sanPhamNhapKhauList.size();i++){
//            if (maSP==sanPhamNhapKhauList.get(i).getMaSanPham()){
//                System.out.println(sanPhamNhapKhauList.get(i).toString());
//                System.out.println("Begin edit");
//                System.out.println("Enter  name: ");
//                String newName= scanner.nextLine();
//                System.out.println("Enter  age: ");
//                int newAge= Integer.parseInt(scanner.nextLine());
//                System.out.println("Enter name Class: ");
//                String nameClass=scanner.nextLine();
//                stundentList.get(i).setName(newName);
//                stundentList.get(i).setAge(newAge);
//                stundentList.get(i).setNameClass(nameClass);
//                check=true;
//
//            } else {
//                check=false;
//
//            }
//
//
//        }
//        if (check=true){
//            System.out.println("successfully changed");
//            ReadWriteFileStudent.saveFile("",FILE_STUDENT);
//            for(int i=0;i<stundentList.size();i++){
//                ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
//                ReadWriteFileStudent.writerFile(stundentList.get(i).getName()+",",FILE_STUDENT);
//                ReadWriteFileStudent.writerFile(stundentList.get(i).getAge()+",",FILE_STUDENT);
//                ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass()+"\n",FILE_STUDENT);
//            }
//        }else {
//            System.out.println();
//        }
//
//    }

    private static void themMoiSanPham() {
        Scanner scanner = new Scanner(System.in);

        int chooseAdd =0;
        do {
            System.out.println("-------THÊM MỚI SẢN PHẨM---------" + "\n" +
                    "1.\tThêm sản phẩm nhập khẩu\n" +
                    "2.\tThêm sản phẩm xuất khẩu\n" +
                    "3.\tQuay lai danh mục chọn \n" +
                    "4.\tThoát"
            );
            System.out.println("Please select an item: ");
            chooseAdd = Integer.parseInt(scanner.nextLine());
            switch (chooseAdd) {
                case 1:
                    themSanPhamNhapKhau();
                    break;
                case 2:
                    themSanPhamXuatKhau();
                    break;
                case 3:
                    hienThiDanhMucLuaChon();
                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lại.  ");
            }
        }while (chooseAdd!=0);
    }

    private static void themSanPhamXuatKhau() {
        Scanner scanner = new Scanner(System.in);

        boolean check = false;
        String maSP;
        do {
            System.out.println(" Nhập mã sản phẩm :");
            maSP = scanner.nextLine();
            Pattern p = Pattern.compile("SP\\d{5}");
            Matcher m = p.matcher(maSP);
            if (m.find() == false) {
                System.out.println("Nhập sai mã sản phẩm. Vui lòng nhập lại ");
                check = false;
            } else {
                System.out.println(" Nhập thành công mã sản phẩm");
                check = true;
            }
        } while (!check);

        System.out.println(" Nhập tên sản phẩm: ");
        String tenSP = scanner.nextLine();

        check = false;
        double giaSp = 0;
        do {
            try {
                System.out.println(" Nhập giá của sản phẩm ");
                giaSp = Double.parseDouble(scanner.nextLine());
                if (giaSp > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai giá sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);

        check = false;
        int soLuongSP = 0;
        do {
            try {
                System.out.println(" Nhập số lượng sản phẩm ");
                soLuongSP = Integer.parseInt(scanner.nextLine());
                if (soLuongSP > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai số lượng sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);

        System.out.println("Nhập nhà xuất:  ");
        String nhaSanXuat = scanner.nextLine();

        check = false;
        double giaXuatKhau = 0;
        do {
            try {
                System.out.println(" Nhập giá nhập khẩu của sản phẩm ");
                giaXuatKhau = Double.parseDouble(scanner.nextLine());
                if (giaXuatKhau > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai giá sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);


        System.out.println("Nhập quốc gia nhập sản phẩm :");
        String quocGiaNhapSP = scanner.nextLine();


//        stundentList.add(new Stundent(id,name, age, nameClass));
//        for (int i = stundentList.size() - 1; i < stundentList.size(); i++) {
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getName() + ",", FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getAge() + ",", FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass() + "\n", FILE_STUDENT);
//            stundentList.clear();

        sanPhamXuatKhauList.add(new SanPhamXuatKhau(id, maSP, tenSP, giaSp, soLuongSP, nhaSanXuat, giaXuatKhau, quocGiaNhapSP));
        for (int i = sanPhamXuatKhauList.size() - 1; i < sanPhamNhapKhauList.size(); i++) {
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getIdSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getMaSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getTenSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getGiaSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getSoLuongSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getNhaSanXuat() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getGiaNhapKhau() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getTinhThanhNhap() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getThueNhapKhau() + "\n", THU_MUC_SAN_PHAM);
            sanPhamXuatKhauList.clear();
            ++id;
        }

    }


    private static void themSanPhamNhapKhau() {
        Scanner scanner = new Scanner(System.in);

        boolean check = false;
        String maSP;
        do {
            System.out.println(" Nhập mã sản phẩm :");
            maSP = scanner.nextLine();
            Pattern p = Pattern.compile("SP\\d{5}");
            Matcher m = p.matcher(maSP);
            if (m.find() == false) {
                System.out.println("Nhập sai mã sản phẩm. Vui lòng nhập lại ");
                check = false;
            } else {
                System.out.println(" Nhập thành công mã sản phẩm");
                check = true;
            }
        } while (!check);

        System.out.println(" Nhập tên sản phẩm: ");
        String tenSP = scanner.nextLine();
        check = false;
        double giaSp = 0;
        do {
            try {
                System.out.println(" Nhập giá của sản phẩm ");
                giaSp = Double.parseDouble(scanner.nextLine());
                if (giaSp > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai giá sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);

        check = false;
        int soLuongSP = 0;
        do {
            try {
                System.out.println(" Nhập số lượng sản phẩm ");
                soLuongSP = Integer.parseInt(scanner.nextLine());
                if (soLuongSP > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai số lượng sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);

        System.out.println("Nhập nhà xuất:  ");
        String nhaSanXuat = scanner.nextLine();
        check = false;

        double giaNhapKhau = 0;
        do {
            try {
                System.out.println(" Nhập giá nhập khẩu của sản phẩm ");
                giaNhapKhau = Double.parseDouble(scanner.nextLine());
                if (giaNhapKhau > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai giá sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);
        System.out.println("Nhập tỉnh thành nhập :");
        String tinhThanhNhap = scanner.nextLine();


        check = false;
        double thueNhapKhau = 0;
        do {
            try {
                System.out.println(" Nhập giá nhập khẩu của sản phẩm ");
                thueNhapKhau = Double.parseDouble(scanner.nextLine());
                if (thueNhapKhau > 0) {

                    System.out.println("Nhập thành công");
                    check = true;
                } else {
                    System.out.println("Nhập sai giá sản phẩm. Vui lòng nhập lại");
                    check = false;
                }
            } catch (Exception e) {
                System.out.println(" Nhập không phải là số. ");
                check = false;
            }
        } while (!check);


//        stundentList.add(new Stundent(id,name, age, nameClass));
//        for (int i = stundentList.size() - 1; i < stundentList.size(); i++) {
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getId()+",",FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getName() + ",", FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getAge() + ",", FILE_STUDENT);
//            ReadWriteFileStudent.writerFile(stundentList.get(i).getNameClass() + "\n", FILE_STUDENT);
//            stundentList.clear();

        sanPhamNhapKhauList.add(new SanPhamNhapKhau(id, maSP, tenSP, giaSp, soLuongSP, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau));
        for (int i = sanPhamNhapKhauList.size() - 1; i < sanPhamNhapKhauList.size(); i++) {
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getIdSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getMaSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getTenSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getGiaSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getSoLuongSanPham() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getNhaSanXuat() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getGiaNhapKhau() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getTinhThanhNhap() + ",", THU_MUC_SAN_PHAM);
            DocVietSanPham.vietThuMuc(sanPhamNhapKhauList.get(i).getThueNhapKhau() + "\n", THU_MUC_SAN_PHAM);
            sanPhamNhapKhauList.clear();
            ++id;

        }

    }

}



