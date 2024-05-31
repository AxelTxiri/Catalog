import java.util.ArrayList;

public class Catalog {
    public static ArrayList<Product> products = new ArrayList<>();

    public void addProduct(int id, String name, double price, String description) {
        products.add(new Product(id, name, price, description));
        System.out.println("Product added");
        System.out.println();
    }

    public void removeProduct(int id) {
        if(products.isEmpty()) {
            System.out.println("There is no product to remove");
        } else {
            products.removeIf(product -> product.getId() == id);
            System.out.println("Product removed");
            System.out.println();
        }
    }

    public void showProducts() {
        if(products.isEmpty()) {
            System.out.println("There is no product to remove");
        } else {
            for(Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public void findById(int id) {
        if(products.isEmpty()) {
            System.out.println("There is no product to find");
        } else {
            for(Product product : products) {
                if(product.getId() == id) {
                    System.out.println(product.toString());
                }
            }
        }
    }

    public void findByName(String name) {
        if(products.isEmpty()) {
            System.out.println("There is no product to find");
        } else {
            for(Product product : products) {
                if(product.getName().equals(name)) System.out.println(product.toString());
            }
        }
    }

    public void searchByDescription(String description) {
        if(products.isEmpty()) {
            System.out.println("There is no product to find");
        } else {
            for(Product product : products) {
                if(product.getDescription().equals(description)) System.out.println(product.toString());
            }
        }
    }
}
