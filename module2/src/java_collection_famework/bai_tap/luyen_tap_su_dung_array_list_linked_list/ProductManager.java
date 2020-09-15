package java_collection_famework.bai_tap.luyen_tap_su_dung_array_list_linked_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        int choose;

        do {
            System.out.println("-------------Menu------------" + "\n" +
                    "1. Thêm sản phẩm." + "\n" +
                    "2. Sửa thông tin sản phẩm theo ID." + "\n" +
                    "3. Xóa sản phẩm theo ID." + "\n" +
                    "4. Hiển thị danh sách sản phẩm." + "\n" +
                    "5. Tìm kiếm sản phẩm theo tên." + "\n" +
                    "6. Sắp xếp sản phẩm theo giá tăng dần ." + "\n" +
                    "7. Sắp xêp sản Phẩm theo giá giảm dần .");
            System.out.println("");
            System.out.print("Bạn hãy chọn một mục: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addProduct(scanner, products);
                    break;
                case 2:
                    displayProduct(products);
                    editProduct(scanner, products);
                    break;
                case 3:
                    delProduct(scanner, products);
                    break;
                case 4:
                    displayProduct(products);
                    break;
                case 5:
                    searchProduct(scanner, products);
                    break;
                case 6:
                    decreasePrice(products);
                    break;
                case 7:
                    ascendingPrice(products);
                    break;
            }


        } while (choose != 0);
    }

    public static boolean isNumber(String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static void addProduct(Scanner scanner, ArrayList<Product> products) {
        scanner.nextLine();
        boolean check = true;
        int id = 0;
        double price = 0.0;
        do {
            System.out.println("Nhập Id của sản phẩm mới(Nhập số nguyên)");
            String tmp = scanner.nextLine();

            if (isNumber(tmp)) {
                id = Integer.parseInt(tmp);

                check = true;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng số vào");
                check = false;
            }
            for (int i = 0; i < products.size(); i++) {
                if (id == products.get(i).getId() || id < 0) {
                    check = false;
                    System.out.println("Bạn nhập chưa đúng, vui lòng nhập lại: ");
                    System.out.println("dm Tay mon khanh");
                } else {
                    check = true;
                }
            }
        } while (!check);
        System.out.println("Nhập tên sản phẩm muốn thêm: ");
        String nameProduct = scanner.nextLine();


        System.out.println("Nhập giá của sản phẩm mới");
        do {
           price=scanner.nextDouble();

            if (price < 0) {
                check = true;
                System.out.println("Nhập lại giá của sản phẩm");

            } else {
                check = false;
            }
        } while (check);

        Product productNewName = new Product(nameProduct, id, price);
        products.add(productNewName);
        System.out.println("Bạn đã thêm sản phẩm thành công, có thông tin như sau:  ");
        System.out.println(productNewName);
    }

    private static void ascendingPrice(ArrayList<Product> products) {
        DecreasePrice decreasePrice = new DecreasePrice();
        Collections.sort(products, decreasePrice);
        System.out.println("So sánh theo giá giảm dần: ");
        System.out.println(products);
    }

    private static void decreasePrice(ArrayList<Product> products) {
        AscendingPrice ascendingPrice = new AscendingPrice();
        Collections.sort(products, ascendingPrice);
        System.out.println("So sánh theo giá tăng dần: ");
        System.out.println(products);
    }

    private static void searchProduct(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Nhập tên sản phẩm bạn muốn tìm: ");
        String searchName = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (searchName.equals(products.get(i).getNameProduct())) {
                System.out.println(products.get(i));
            }
            System.out.println("Không thấy tìm thấy tên sản phẩm phù hợp");
        }
    }

    private static void editProduct(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Nhập vào ID sản phẩm bạn muốn sửa thông tin : ");
        int editId = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        for (int i = 0; i < products.size(); i++) {
            if (editId == products.get(i).getId()) {
                System.out.println("Nhập thông tin sản phẩm cần sửa: ");
                String newNameProduct = scanner.nextLine();
                products.get(i).setNameProduct(newNameProduct);

                System.out.println("Nhập ID  cần sửa");
                int newId = scanner.nextInt();
                products.get(i).setId(newId);

                System.out.println("Nhập giá  cần sửa");
                int newPrice = scanner.nextInt();
                products.get(i).setId(newPrice);

                System.out.println("Thay đổi thông tin thành công , sản phẩm mới thay đổi có thông tin là:");
                System.out.println(products.get(i));
            }
            System.out.println("Không tìm thấy ID phù hợp");
        }
    }

    private static void delProduct(Scanner scanner, ArrayList<Product> products) {
        System.out.println("Nhập vào ID muốn xóa: ");
        int delId = scanner.nextInt();
        for (int i = 0; i < products.size(); i++) {
            if (delId == products.get(i).getId()) {
                products.remove(i);
            }
            System.out.println("Khong tim thay id can xoa: ");

        }
    }

    private static void displayProduct(ArrayList<Product> products) {
        System.out.println("Danh sách sản phẩm :");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

