package SupershopManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SuperShop superShop = new SuperShop("Shwapno SuperShop");
        Store store = new Store();

        while(true){
            System.out.println("1. Administrative Control");
            System.out.println("2. Customer Interface");
            System.out.println("3. Exit from System");

            System.out.print("Enter your role: ");
            int choice = scanner.nextInt();

            if(choice == 1){
                System.out.print("Enter Username: ");
                String username = scanner.next();
                System.out.print("Enter Password: ");
                String password = scanner.next();
                //adminLogin adminLogin = new adminLogin();
                if(new adminLogin().logIn(username, password)){
                    adminInterface(superShop, store);
                }
                else System.out.println("Invalid Username or Password!\n");
            }
            else if(choice == 2){
                customerInterface(store);
            }
            else if(choice == 3){
                break;
            }
            else{
                System.out.println("Invalid role, Please choose a valid role\n");
            }
        }
    }

    public static void adminInterface(SuperShop superShop, Store store){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = scanner.next();
        System.out.print("Enter your Email: ");
        String email = scanner.next();
        System.out.print("Enter your Address: ");
        String address = scanner.next();
        System.out.print("Enter your Phone Number: ");
        int phone = scanner.nextInt();

        Admin admin = new Admin(name, email, address, phone);

        while(true){
            System.out.println();
            System.out.println(name + ", Welcome to the Admin panel!");

            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. View Employee");
            System.out.println("4. Add new Product");
            System.out.println("5. Remove Product");
            System.out.println("6. Modify Product");
            System.out.println("7. Show All Products");
            System.out.println("8. Exit from Admin Panel!\n");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();

            if(choice == 1){
                admin.AddEmployee(superShop);
            }
            else if(choice == 2){
                admin.RemoveEmployee(superShop);
            }
            else if(choice == 3){
                admin.viewEmployee(superShop);
            }
            else if(choice == 4){
                admin.addNewProduct(store);
            }
            else if(choice == 5){
                admin.removeProduct(store);
            }
            else if(choice == 6){
                admin.modifyProduct(store);
            }
            else if(choice == 7){
                admin.showAllProducts(store);
            }
            else if(choice == 8){
                break;
            }
            else{
                System.out.println("Enter a valid choice!\n");
            }
        }
    }


    public static void customerInterface(Store store){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter your Name: ");
        String name = scanner.next();
        System.out.print("Enter your Email: ");
        String email = scanner.next();
        System.out.print("Enter your Address: ");
        String address = scanner.next();
        System.out.print("Enter your Phone Number: ");
        int phone = scanner.nextInt();

        Customer customer = new Customer(name, email, address, phone);

        while(true){
            System.out.println();
            System.out.println(name + ", Welcome to our Shop!");

            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Remove from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Back to previous Interface\n");

            System.out.print("Enter Your Choice: ");
            int choice = scanner.nextInt();

            if(choice == 1){
                customer.viewProduct(store);
            }
            else if(choice == 2){
                customer.addToCart(store);
            }
            else if(choice == 3){
                customer.removeFromCart(store);
            }
            else if(choice == 4){
                customer.viewCart();
            }
            else if(choice == 5){
                customer.checkOut(customer);
            }
            else if(choice == 6){
                break;
            }
            else System.out.println("Please enter a valid number.");
        }
    }
}
