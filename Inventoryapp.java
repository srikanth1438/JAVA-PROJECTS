import java.util.ArrayList;
import java.util.Scanner;

// 1. The Product Class (Note: It does not have the 'public' keyword here)
class Product {
    private String id;
    private String name;
    private int quantity;
    private double price;

    // Constructor
    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Setters
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    // Formatting for console output
    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-15s | Qty: %-5d | Price: $%.2f", 
                             id, name, quantity, price);
    }
}

// 2. The Main Application Class (This must match the filename: InventoryApp.java)
public class Inventoryapp {
    // In-memory database and scanner setup
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== INVENTORY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline character

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    updateQuantity();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to add a new product
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Initial Quantity: ");
        int quantity = scanner.nextInt();
        
        System.out.print("Enter Price: $");
        double price = scanner.nextDouble();

        Product newProduct = new Product(id, name, quantity, price);
        inventory.add(newProduct);
        
        System.out.println("✅ Product added successfully!");
    }

    // Method to display everything in the inventory
    private static void viewProducts() {
        if (inventory.isEmpty()) {
            System.out.println("The inventory is currently empty.");
            return;
        }
        
        System.out.println("\n--- Current Inventory ---");
        for (Product p : inventory) {
            System.out.println(p.toString());
        }
        System.out.println("-------------------------");
    }

    // Method to find a product by ID and change its stock level
    private static void updateQuantity() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty. Add products first.");
            return;
        }

        System.out.print("Enter the ID of the product to update: ");
        String targetId = scanner.nextLine();

        boolean found = false;
        
        for (Product p : inventory) {
            if (p.getId().equalsIgnoreCase(targetId)) {
                System.out.print("Enter the new quantity for " + p.getName() + ": ");
                int newQuantity = scanner.nextInt();
                
                p.setQuantity(newQuantity);
                System.out.println("✅ Quantity updated successfully!");
                found = true;
                break; 
            }
        }

        if (!found) {
            System.out.println("❌ Product with ID '" + targetId + "' not found.");
        }
    }
}