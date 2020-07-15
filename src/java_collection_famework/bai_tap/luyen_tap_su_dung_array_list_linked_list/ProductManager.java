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
            System.out.println("1. Thêm sản phẩm." + "\n" +
                    "2. Sửa thông tin sản phẩm theo ID." + "\n" +
                    "3. Xóa sản phẩm theo ID." + "\n" +
                    "4. Hiển thị danh sách sản phẩm." + "\n" +
                    "5. Tìm kiếm sản phẩm theo tên." + "\n" +
                    "6. Sắp xếp sản phẩm tăng dần theo giá " + "\n" +
                    "7. Sắp xêp sản Phẩm giảm dần theo giá.");
            System.out.println("");
            System.out.print("Bạn hãy chọn một mục: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addProduct(scanner, products);
                    break;
                case 2:
                    displayProduct(products);
                    suaProduct(scanner, products);
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


    } while (choose!=0);
    }

    private static void addProduct(Scanner scanner, ArrayList<Product> products) {
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm muốn thêm: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập Id của sản phẩm mới");
        int id = scanner.nextInt();
        System.out.println("Nhập giá của sản phẩm mới");
        double price = scanner.nextDouble();
        products.add(new Product(nameProduct, id, price));
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

    private static void suaProduct(Scanner scanner, ArrayList<Product> products) {
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

        }
    }

    private static void displayProduct(ArrayList<Product> products) {
        System.out.println("Danh sách sản phẩm :");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

