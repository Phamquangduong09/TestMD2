package test.controller;

import test.service.IOManager;
import test.service.ProductManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        IOManager ioManager = new IOManager();
        int choice = -1;
        do {
            System.out.println("--- Chương trình quản lý sản phẩm ---");
            System.out.println(" Chọn chức năng để tiếp tục ");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number !!");
            }
            switch (choice) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.add();
                    break;
                case 3:
                    productManager.update();
                    break;
                case 4:
                    productManager.delete();
                    break;
                case 5:
                    productManager.sort();
                    break;
                case 6:
                    productManager.searchByPrice();
                    break;
                case 7:
                    ioManager.readFileProduct(productManager.getProductList());
                    break;
                case 8:
                    ioManager.writeFileProduct(productManager.getProductList());
                    break;
                case 9:
                    System.exit(9);
            }
        } while (true);
    }
}
