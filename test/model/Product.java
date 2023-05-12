package test.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    public static int idUp;
    private String code;
    private double price;
    private String name;
    private int quantity;
    private String describe;

    public Product() {
    }

    public Product(String code, String name, double price, int quantity, String describe) {
        this.id = ++idUp;
        this.code = code;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.describe = describe;
    }

    public Product(int id, String code, String name, double price, int quantity, String describe) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return id + "," + code + "," + name + "," + price + "," + quantity + "," + describe;
    }

}

