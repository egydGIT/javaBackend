package ioconvert.products;

import java.io.*;
import java.util.List;

public class ProductWriter {

    public void saveProductMy(OutputStream os, List<Product> products) {
        try (PrintWriter pw = new PrintWriter(new BufferedOutputStream(os))) {
            for (Product p : products) {
                pw.print(p.getName());
                pw.print(";");
                pw.println(p.getPrice());
            }
        }
    }

    public void saveProduct(OutputStream os, List<Product> products) {      // Solution
        try (PrintStream pw = new PrintStream(os)) {
            for (Product product : products) {
                pw.print(product.getName());
                pw.print(";");
                pw.print(product.getPrice());
                pw.println();
            }
        }
    }

}
