import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static int option = 0;
    public static Scanner scanner = new Scanner(System.in);
    public static Catalog catalog = new Catalog();
    public static ConsoleReader console = new ConsoleReader();

    public static void mainMenu() {
        do {
            menu();
            switch (option) {
                case 1:
                    System.out.println("Enter the ID of the product:");
                    int id = console.readInt();
                    System.out.println("Enter the name of the product:");
                    String name = console.readString();
                    System.out.println("Enter the price of the product:");
                    double price = console.readDouble();
                    System.out.println("Enter the description of the product:");
                    String description = console.readString();

                    catalog.addProduct(id, name, price, description);
                    break;
                case 2:
                    catalog.showProducts();
                    System.out.println("Enter the ID of the product:");
                    int removeId = console.readInt();
                    scanner.nextLine();

                    catalog.removeProduct(removeId);
                    break;
                case 3:
                    catalog.showProducts();
                    break;
                case 4:
                    catalog.showProducts();
                    System.out.println("Enter the ID of the product:");
                    int findId = console.readInt();
                    scanner.nextLine();

                    catalog.findById(findId);
                    break;
                case 5:
                    catalog.showProducts();
                    System.out.println("Enter the name of the product:");
                    String findName = console.readString();

                    catalog.findByName(findName);
                    break;
                case 6:
                    catalog.showProducts();
                    System.out.println("Enter the description of the product:");
                    String searchDescription= console.readString();

                    catalog.searchByDescription(searchDescription);
                    break;
            }
        } while (option != 7);
    }

    public static void menu() {
        System.out.println("1. ADD PRODUCT");
        System.out.println("2. REMOVE PRODUCT");
        System.out.println("3. SHOW PRODUCTS");
        System.out.println("4. FIND PRODUCT BY ID");
        System.out.println("5. FIND PRODUCT BY NAME");
        System.out.println("6. SEARCH PRODUCT BY DESCRIPTION");
        System.out.println("7. EXIT");
        System.out.println("Enter your choice: ");

        option = console.readInt();

        if (option < 1 || option > 7) {
            System.out.println("Invalid option");
            System.out.println();
            option = 0;
        }

        System.out.println();
    }
}
