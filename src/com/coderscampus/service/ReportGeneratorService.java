package com.coderscampus.service;

import java.util.ArrayList;

import com.coderscampus.domain.Product;

public class ReportGeneratorService {

    public ReportGeneratorService() {
        // TODO Auto-generated constructor stub
    }

    public void generateLowInventoryReport(ArrayList<Product> products) {

        for (Product product : products) {
            if ((product.getPrice() >= .99) && (product.getPrice() <= 100.00)) {
                if (product.getQuantity() <= 20) {
                    System.out.println(product.toString() + " -> *** re-order ***");
                }
            } else if (product.getPrice() > 100.00) {
                if (product.getQuantity() <= 10) {
                    System.out.println(product.toString() + " -> *** re-order ***");
                }
            }
        }
    }
}
