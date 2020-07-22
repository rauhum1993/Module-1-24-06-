package lesson17_binary_file_anh_serialization.bai_tap.product_manage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    public static String filePath = "src/lesson17_binary_file_anh_serialization/bai_tap/product_manage/test_product.txt";


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Product> productList = new ArrayList<>();

        int choose;

        do {
            System.out.println("-------------Menu------------" + "\n" +
                    "1. Thêm sản phẩm." + "\n" +
                    "2. Hiển thị danh sách sản phẩm." + "\n" +
                    "3. Tìm kiếm sản phẩm theo tên." + "\n");
//
            System.out.println("");
            System.out.print("Bạn hãy chọn một mục: ");
            choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    addProduct(scanner, productList);
                    break;
                case 2:
                    displayProduct(productList);
                    break;
                case 3:
                    displayProduct(productList);
                    System.out.println("Choose how to search: " + "\n"
                            + "1. Search by name.\n"
                            + "2. Sreach by Id.");
                    int choose1= Integer.parseInt(scanner.nextLine());
                    if( choose1==1){
                        searchByName(scanner, productList);
                    } else if(choose1==2){
                       searchById(scanner,productList);
                    } else {
                        System.out.println(" Enter Error");
                    }



                    break;
            }

        } while (choose != 0);
    }


    private static void searchByName(Scanner scanner, List<Product> productList) {
        int i;

        System.out.println("Enter Name Of Product To Search: ");
        String productSearch = scanner.nextLine();
        for (i = 0; i < productList.size(); i++) {
            if (productSearch.equals(productList.get(i).getProductName())) {
                System.out.println(productList.get(i));
            }
        }
    }

    private static void searchById(Scanner scanner, List<Product> productList) {
        System.out.println("Enter Id Of Product To Search: ");
        int idSearch = Integer.parseInt(scanner.nextLine());
        int i = 0;
        for (i = 0; i < productList.size(); i++)
            if (idSearch == productList.get(i).getiD()) {
                System.out.println(productList.get(i));
            }
    }

    private static void displayProduct(List<Product> productList) throws IOException {
        ObjectInputStream oIPS = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            oIPS = new ObjectInputStream(fileInputStream);
            List<Product> productList1 = (List<Product>) oIPS.readObject();
            for (Product product1 : productList) {
                System.out.println("ID: \t" + product1.getiD() + ".\t Name Product:\t " + product1.getProductName()
                        + ".\t Price : \t " + product1.getPrice() + ".\t ManuFacturer: \t" + product1.getManufacturer()
                        + ".\t Other Description : \t" + product1.getOtherDescription() + ".\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            oIPS.close();
        }
    }

    private static void addProduct(Scanner scanner, List<Product> productList) throws IOException {
        System.out.println("Enter ID of Product: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Name Of Product : ");
        String name = scanner.nextLine();
        System.out.println("Enter Price Of Product: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Manufacturer Of Product: ");
        String manufacturer = scanner.nextLine();
        System.out.println("Enter Other Descreption Of Product: ");
        String otherDescreption = scanner.nextLine();
        Product product = new Product(id, name, price, manufacturer, otherDescreption);

        productList.add(product);


        FileOutputStream fileOutputStream = null;
        ObjectOutputStream oOPS = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            oOPS = new ObjectOutputStream(fileOutputStream);
            oOPS.writeObject(productList);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            oOPS.flush();
            oOPS.close();

        }
    }
}


