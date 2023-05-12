package test.service;

import test.model.Product;

import java.io.*;
import java.util.List;

public class IOManager {
    public void readFileProduct(List<Product> productList) {
        File file = new File("C:\\Test\\test\\data\\Product");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] arrProduct = string.split(",");
                Product product = new Product(Integer.parseInt(arrProduct[0]), arrProduct[1], arrProduct[2],
                        Double.parseDouble(arrProduct[3]), Integer.parseInt(arrProduct[4]), arrProduct[5]);
                productList.add(product);
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println();
        }

    }

    public void writeFileProduct(List<Product> productList) {
        File file = new File("C:\\Test\\test\\data\\Product");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : productList) {
                bufferedWriter.write(p.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
