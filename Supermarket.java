import java.util.*;

class Product {
    private String name;
    private int productId;
    private double price;
    private int stock;

    Product(String n, int id, double p, int s) {
        name = n;
        productId = id;
        price = p;
        stock = s;
    }

    public String getName() { return name; }
    public int getProductId() { return productId; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    void addStock(int quantity) {
        stock += quantity;
        System.out.println("Stock updated! New stock: " + stock);
    }

    boolean buyProduct(int quantity) {
        if(stock >= quantity) {
            stock -= quantity;
            return true;
        } else {
            System.out.println("Insufficient stock! Available: " + stock);
            return false;
        }
    }

    void displayDetails() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Stock: " + stock);
    }
}

class Cart {
    private String[] items = new String[20];
    private double[] prices = new double[20];
    private int[] quantities = new int[20];
    private int count = 0;

    void addToCart(String name, double price, int quantity) {
        items[count] = name;
        prices[count] = price;
        quantities[count] = quantity;
        count++;
        System.out.println(quantity + " x " + name + " added to cart!");
    }

    void generateBill() {
        if(count == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("\n=============================");
        System.out.println("         BILL RECEIPT        ");
        System.out.println("=============================");
        double total = 0;
        for(int i = 0; i < count; i++) {
            double subtotal = prices[i] * quantities[i];
            System.out.println(items[i] + " x " + quantities[i] + " = Rs." + subtotal);
            total += subtotal;
        }
        System.out.println("=============================");
        System.out.println("Total: Rs." + total);
        System.out.println("=============================");
        count = 0;  // clear cart after billing
    }

    void displayCart() {
        if(count == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        System.out.println("=== Your Cart ===");
        for(int i = 0; i < count; i++) {
            System.out.println(items[i] + " x " + quantities[i] + " = Rs." + (prices[i] * quantities[i]));
        }
    }
}

public class Supermarket {
    static Product[] products = new Product[20];
    static int productCount = 0;
    static Cart cart = new Cart();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // add some default products
        products[productCount++] = new Product("Rice", 101, 50.0, 100);
        products[productCount++] = new Product("Sugar", 102, 40.0, 50);
        products[productCount++] = new Product("Oil", 103, 120.0, 30);

        int choice;
        do {
            System.out.println("\n=== Supermarket Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Buy Product");
            System.out.println("3. Check Stock");
            System.out.println("4. Search Product");
            System.out.println("5. View Cart");
            System.out.println("6. Generate Bill");
            System.out.println("7. Display All Products");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    buyProduct();
                    break;
                case 3:
                    checkStock();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.generateBill();
                    break;
                case 7:
                    displayAllProducts();
                    break;
                case 8:
                    System.out.println("Thank you for shopping!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 8);
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.next();
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.print("Enter stock: ");
        int stock = sc.nextInt();
        products[productCount++] = new Product(name, id, price, stock);
        System.out.println("Product added successfully!");
    }

    static Product findProduct(int id) {
        for(int i = 0; i < productCount; i++) {
            if(products[i].getProductId() == id) {
                return products[i];
            }
        }
        return null;
    }

    static void buyProduct() {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        Product p = findProduct(id);
        if(p == null) {
            System.out.println("Product not found!");
        } else {
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            if(p.buyProduct(qty)) {
                cart.addToCart(p.getName(), p.getPrice(), qty);
            }
        }
    }

    static void checkStock() {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        Product p = findProduct(id);
        if(p == null) {
            System.out.println("Product not found!");
        } else {
            System.out.println("Stock for " + p.getName() + ": " + p.getStock());
        }
    }

    static void searchProduct() {
        System.out.print("Enter product name: ");
        String name = sc.next();
        boolean found = false;
        for(int i = 0; i < productCount; i++) {
            if(products[i].getName().equalsIgnoreCase(name)) {
                products[i].displayDetails();
                found = true;
            }
        }
        if(!found) {
            System.out.println("Product not found!");
        }
    }

    static void displayAllProducts() {
        if(productCount == 0) {
            System.out.println("No products found!");
        } else {
            System.out.println("=== All Products ===");
            for(int i = 0; i < productCount; i++) {
                products[i].displayDetails();
                System.out.println("---");
            }
        }
    }
}