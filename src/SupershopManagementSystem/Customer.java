package SupershopManagementSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

class Customer extends Person{
    private String name;
    private String email;
    private String address;
    private int phone;
    ArrayList<Product> productsCart;
    public Customer(String name, String email, String address, int phone){
        super(name, email, address, phone);
        productsCart = new ArrayList<>();
    }
    Scanner scanner = new Scanner(System.in);
    public void viewProduct(Store store){
        store.showAllProducts();
    }
    public void addToCart(Store store){
        System.out.print("Enter Product Name: ");
        String productName = scanner.next();
        Product p = store.searchProduct(productName);
        if (p != null){
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            if(quantity <= p.quantity){
                store.decreaseQuantity(productName, quantity);
                //p.quantity = quantity;
                int id = p.id;
                String name = p.name;
                Double price = p.price;
                String category = p.category;
                Product addedProduct = new Product(id, name, price, quantity, category);
                productsCart.add(addedProduct);
                System.out.println("Product added to the cart!");
            }
            else{
                System.out.println("Quantity exceeded!");
            }
        }
        else{
            System.out.println("Product NOT Found");
        }
    }

    public void removeFromCart(Store store){
        if(productsCart == null){
            System.out.print("Nothing to remove, Your cart is empty!");
            return;
        }
        System.out.print("Enter Product Name to Remove: ");
        String productName = scanner.next();
        Product productToRemove = null;
        for(Product p: productsCart){
            if(p.name.equals(productName)){
                productToRemove = p;
                break;
            }
        }
        if(productToRemove != null){
            store.increaseQuantity(productToRemove.name, productToRemove.quantity);
            productsCart.remove(productToRemove);
            System.out.println(productToRemove.name + " removed from the cart!");
        }
        else{
            System.out.println("Failed to remove! Please check the spelling");
        }
    }

    public void viewCart(){
        System.out.println("!-----Your Cart-----!");
        System.out.println("+------------+-----------------+---------------+------------------+----------------------+");
        System.out.println("| product_id | product_name    | product_price | product_quantity | product_category     |");
        System.out.println("+------------+-----------------+---------------+------------------+----------------------+");
        for(Product p: productsCart){
            System.out.printf("| %-10s | %-15s | %-13s | %-16s | %-20s |\n",p.id, p.name, p.price, p.quantity, p.category);
            System.out.println("+------------+-----------------+---------------+------------------+----------------------+");
        }
    }

    public void checkOut(Customer customer){
        Double amount = 0.0;
        System.out.println("\n\n             ~Shwapno SuperShop~\n                Sylhet Branch");
        System.out.println("\n~------------------RECEIPT------------------~\n");
        System.out.println("Customer Name: " + customer.getName());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Date and Time: " + localDateTime);

        System.out.println("+------------------+-------------+----------+");
        System.out.println("| name             | price       | quantity |");
        System.out.println("+------------------+-------------+----------+");

        for(Product p: productsCart){
            amount += p.price * p.quantity;
            System.out.printf("| %-16s | %-11s | %-8s |\n", p.name, p.price, p.quantity);
            System.out.println("+------------------+-------------+----------+");
        }
        System.out.println("Payable Amount: " + amount);
        productsCart = new ArrayList<>();
    }
}