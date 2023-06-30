package com.coderscampus.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.coderscampus.domain.Product;

public class CsvReaderService {

    public CsvReaderService() {
    }

    public List<Product> readProductsFromFile(Path path) {

        List<Product> productList = new ArrayList<>();

        try {
            List<String> productListFromFile = Files.readAllLines(path);

            productListFromFile.stream()
                    .skip(1)
                    .forEach((String lineOfData) -> {

                        Product product = new Product();

                        String[] aParcedProductRowArrayOfString = lineOfData.split(",");

                        product.setId(Integer.parseInt(aParcedProductRowArrayOfString[0]));
                        product.setName(aParcedProductRowArrayOfString[1]);
                        product.setQuantity(Integer.parseInt(aParcedProductRowArrayOfString[2]));
                        product.setPrice(Double.parseDouble(aParcedProductRowArrayOfString[3]));

                        productList.add(product);
                    });
        } catch (IOException e) {
            System.out.println("There was a problem reading the file");
            e.printStackTrace();
        }
        return productList;
    }
}
