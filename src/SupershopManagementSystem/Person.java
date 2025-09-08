package SupershopManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Person {
    private String name;
    private String email;
    private String address;
    private int phone;

    public Person(String name, String email, String address, int phone){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public int getPhone() {
        return phone;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }
}

class Employee extends Person{
    int id;
    int age;
    String designation;
    Double salary;
    public Employee(int id, String name, String email, String address, int phone, int age, String designation, Double salary){
        super(name, email, address, phone);
        this.id = id;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }
}

class adminLogin{
    String username;
    String password;
    adminLogin(){
        this.username = "tushar404";
        this.password = "TU$HAR";
    }

    public boolean logIn(String username, String password){
        if(username.equals(this.username) && password.equals(this.password)){
            System.out.println("Login Successful!\n");
            return true;
        }
        else return false;
    }
}


class Admin extends Person{
    Scanner scanner = new Scanner(System.in);
    public Admin(String name, String email, String address, int phone){
        super(name, email, address, phone);
    }

    public void AddEmployee(SuperShop sp){
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.next();
        System.out.print("Enter Employee Email: ");
        String employeeEmail = scanner.next();
        System.out.print("Enter Employee Address: ");
        String employeeAddress = scanner.next();
        System.out.print("Enter Employee Phone Number: ");
        int employeePhone = scanner.nextInt();
        System.out.print("Enter Employee Age: ");
        int employeeAge = scanner.nextInt();
        System.out.print("Enter Employee Designation: ");
        String employeeDesignation = scanner.next();
        System.out.print("Enter Employee Salary: ");
        Double employeeSalary = scanner.nextDouble();

        Employee employee = new Employee(id, employeeName, employeeEmail, employeeAddress, employeePhone, employeeAge, employeeDesignation, employeeSalary);

        sp.AddEmployee(employee);
    }
    public void RemoveEmployee(SuperShop sp){
        System.out.print("Enter Employee ID to Remove: ");
        int id = scanner.nextInt();
        sp.RemoveEmployee(id);
    }
    public void viewEmployee(SuperShop sp){
        sp.viewEmployee();
    }
    public void addNewProduct(Store store){
        System.out.print("Define Product ID: ");
        int id = scanner.nextInt();
        System.out.print("Define Product Name: ");
        String name = scanner.next();
        System.out.print("Define Product Price: ");
        Double price = scanner.nextDouble();
        System.out.print("Define Product Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Define Product Category: ");
        String category = scanner.next();
        Product product = new Product(id, name, price, quantity, category);

        store.addProduct(product);
    }
    public void removeProduct(Store store){
        System.out.print("Enter Product ID to Remove: ");
        int id = scanner.nextInt();
        store.removeProduct(id);
    }
    public void modifyProduct(Store store){
        System.out.print("Enter Product ID to Modify Name: ");
        int id = scanner.nextInt();
        store.modifyProduct(id);
    }
    public void showAllProducts(Store store){
        store.showAllProducts();
    }
}















