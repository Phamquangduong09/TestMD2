package test.service;

import test.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements Manager, Feature {
    private List<Product> productList;
    private Scanner scanner;

    public ProductManager() {
        scanner = new Scanner(System.in);
        productList = new ArrayList<>();
        checkDefaultIndex();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void sort() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                else if (o1.getPrice() < o2.getPrice()) return -1;
                else return 0;
            }
        });
        display();
    }

    @Override
    public void searchByPrice() {
        double max = 0;
        for (Product p : productList) {
            if (p.getPrice() > max) {
                max = p.getPrice();
            }
        }
        for (Product p : productList) {
            if (p.getPrice() == max) {
                System.out.println("The product with the highest price is:" + p);
            }
        }
    }

    @Override
    public List add() {
        System.out.println("Enter code");
        String code = scanner.nextLine();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        double price;
        while (true) {
            System.out.println("Enter price");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        int quantity;
        while (true) {
            System.out.println("Enter quantity");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter describe ");
        String describe = scanner.nextLine();
        Product product = new Product(code, name, price, quantity, describe);
        productList.add(product);
        return productList;
    }

    @Override
    public List update() {
        Product product = getById();
        if (product != null) {
            System.out.println("Enter name");
            String name = scanner.nextLine();
            if (!name.equals("")) {
                product.setName(name);
            }
            double price;
            while (true) {
                System.out.println("Enter price");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    if (price > 0) {
                        product.setPrice(price);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please re-enter the number!");
                }
            }
            int quantity;
            while (true) {
                System.out.println("Enter quantity");
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity > 0) {
                        product.setPrice(quantity);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please re-enter the number!");
                }
            }

            System.out.println("Enter describe");
            String describe = scanner.nextLine();
            product.setDescribe(describe);
        }
        display();
        return productList;
    }

    @Override
    public List delete() {
        Product product = getById();
        if (product != null) {
            productList.remove(product);
        }
        display();
        return productList;
    }


    @Override
    public void display() {
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    public Product getById() {
        int id;
        do {
            try {
                System.out.println("Enter id you want: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Have error, please try again!");
            }
        } while (true);
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    private void checkDefaultIndex() {
        if (productList.isEmpty()) {
            Product.idUp = 0;
        } else {
            Product.idUp = productList.get(productList.size() - 1).getId();
        }
    }

}
