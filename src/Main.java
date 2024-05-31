public class Main {
    public static void main(String[] args) {
        //Seeder.fillProgram();
        //Catalog.products.addAll(Seeder.readProducts("C:\\Users\\Axel\\Desktop\\Products.txt"));
        //Catalog.products.addAll(Seeder.readProductsBinary("productsBin.bin"));
        Catalog.products.addAll(Seeder.readProductsObjects("productsObj.dat"));
        Menu.mainMenu();
        //Seeder.saveProductsBinary(Catalog.products,"productsBin.bin");
        Seeder.saveProductsObjects(Catalog.products,"productsObj.dat");
    }
}
