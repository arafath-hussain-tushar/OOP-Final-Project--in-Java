package SupershopManagementSystem;

public class Product{
    int id;
    String name;
    Double price;
    int quantity;
    String category;
    public Product(int id, String name, Double price, int quantity, String category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", Category: " + category;
    }
}
