import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class Seeder {
    public static void fillProgram(){
        Product product1 = new Product(1,"Doritos",20,"Chips");
        Catalog.products.add(product1);

        Product product2 = new Product(2, "Coca-Cola", 15, "Beverage");
        Catalog.products.add(product2);

        Product product3 = new Product(3, "Oreo", 10, "Cookies");
        Catalog.products.add(product3);

        Product product4 = new Product(4, "Pringles", 25, "Chips");
        Catalog.products.add(product4);

        Product product5 = new Product(5, "Sprite", 12, "Beverage");
        Catalog.products.add(product5);

        Product product6 = new Product(6, "KitKat", 18, "Chocolate");
        Catalog.products.add(product6);

        Product product7 = new Product(7, "Lay's", 22, "Chips");
        Catalog.products.add(product7);

        Product product8 = new Product(8, "Mountain Dew", 14, "Beverage");
        Catalog.products.add(product8);

        Product product9 = new Product(9, "Twix", 16, "Chocolate");
        Catalog.products.add(product9);

        Product product10 = new Product(10, "Pepsi", 13, "Beverage");
        Catalog.products.add(product10);
    }
    public static ArrayList<Product> readProducts(String filename) {
        ArrayList<Product> productList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (headers == null) {
                    headers = fields;
                    continue;
                }

                Map<String, String> fieldMap = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    if (i < fields.length) {
                        fieldMap.put(headers[i], fields[i]);
                    } else {
                        fieldMap.put(headers[i], "");
                    }
                }

                int id = Integer.parseInt(fieldMap.getOrDefault("ID", "-1"));
                String name = fieldMap.getOrDefault("Name", "");
                double price = Double.parseDouble(fieldMap.getOrDefault("Price", "0.0"));
                String description = fieldMap.getOrDefault("Description", "");

                Product product = new Product(id, name, price, description);
                productList.add(product);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return productList;
    }
    public static ArrayList<Product> readProductsBinary(String filename){
        ArrayList<Product> productList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filename);
             DataInputStream dis = new DataInputStream(fis)) {
            while (dis.available() > 0) {
                int id = dis.readInt();
                String name = dis.readUTF();
                double price = dis.readDouble();
                String description = dis.readUTF();

                Product product = new Product(id, name, price, description);
                productList.add(product);
            }
            System.out.println("Products loaded from products.bin");
            for (Product product : productList) {
                System.out.println(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading products from file: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }
    public static void saveProductsBinary(ArrayList<Product> products, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             DataOutputStream dos = new DataOutputStream(fos)) {
            for (Product product : products) {
                dos.writeInt(product.getId());
                dos.writeUTF(product.getName());
                dos.writeDouble(product.getPrice());
                dos.writeUTF(product.getDescription());
            }
            System.out.println("Products saved to "+ filename);
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void saveProductsObjects(ArrayList<Product> products, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
            System.out.println("Products saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static ArrayList<Product> readProductsObjects(String filename) {
        ArrayList<Product> productList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            productList = (ArrayList<Product>) ois.readObject();
            System.out.println("Products loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading products from file: " + e.getMessage());
            e.printStackTrace();
        }
        return productList;
    }
}
