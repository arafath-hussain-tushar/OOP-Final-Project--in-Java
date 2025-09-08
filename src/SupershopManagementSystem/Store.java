package SupershopManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Product> products;
    public Store(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int id){
        Product productToRemove = null;
        for(Product p: products){
            if(p.id == id){
                productToRemove = p;
                break;
            }
        }
        if(productToRemove != null){
            products.remove(productToRemove);
            System.out.println(productToRemove.name + " removed from store.");
        }
        else{
            System.out.println("Product ID (" + id + ") doesn't exist in the store.");
        }
    }

    public void decreaseQuantity(String name, int quantity){
        for(Product p: products){
            if(p.name.equals(name)){
                p.quantity -= quantity;
            }
        }
    }

    public void increaseQuantity(String name, int quantity){
        for(Product p: products){
            if(p.name.equals(name)){
                p.quantity = p.quantity + quantity;
            }
        }
    }

    public Product searchProduct(String name){
        for(Product p: products){
            if(p.name.equals(name)){
                return p;
            }
        }
        return null;
    }

    public void modifyProduct(int id){
        Scanner scanner = new Scanner(System.in);
        int flag = 0;
        for(Product p: products){
            if(p.id == id){
                flag = 1;
                System.out.print("Enter a new name of Product ID (" + id + "): " );
                String newName = scanner.next();
                System.out.print("Set new Price of Product ID (" + id + "): " );
                Double newPrice = scanner.nextDouble();
                System.out.print("Set new Quantity of Product ID (" + id + "): " );
                int newQuantity = scanner.nextInt();
                System.out.print("Set new Category of Product ID (" + id + "): " );
                String newCategory = scanner.next();

                System.out.println(p.name + " changed to " + newName);
                p.name = newName;
                p.price = newPrice;
                p.quantity = newQuantity;
                p.category = newCategory;
                break;
            }
        }
        if(flag == 0){
            System.out.println("Product ID (" + id + ") doesn't exist in the store.");
        }
    }

    public void showAllProducts(){
        System.out.println("~-----All Products-----~");
        System.out.println("+-----+------------------+-------------+----------+-------------------+");
        System.out.println("| id  | name             | price       | quantity | category          |");
        System.out.println("+-----+------------------+-------------+----------+-------------------+");
        for(Product p: products){
            System.out.printf("| %-3s | %-16s | %-11s | %-8s | %-17s |\n", p.id, p.name, p.price, p.quantity, p.category);
            System.out.println("+-----+------------------+-------------+----------+-------------------+");
        }
    }
}
