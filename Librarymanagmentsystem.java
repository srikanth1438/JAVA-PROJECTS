class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    Book(String t, String a) {
        title = t;
        author = a;
        isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean getIsAvailable() { return isAvailable; }

    void issueBook() {
        if(isAvailable) {
            isAvailable = false;
            System.out.println(title + " issued successfully!");
        } else {
            System.out.println(title + " is not available!");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned successfully!");
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}

class Member {
    private String name;
    private int memberId;

    Member(String n, int id) {
        name = n;
        memberId = id;
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }

    void displayDetails() {
        System.out.println("Member: " + name);
        System.out.println("ID: " + memberId);
    }
}

public class Librarymanagmentsystem {
    public static void main(String[] args) {
        // create books
        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Data Structures", "Mark Allen");

        // create members
        Member m1 = new Member("Srikanth", 1001);
        Member m2 = new Member("Abhishek", 1002);

        // display details
        System.out.println("=== Library Books ===");
        b1.displayDetails();
        b2.displayDetails();

        // issue books
        System.out.println("\n=== Issuing Books ===");
        b1.issueBook();  // issued!
        b1.issueBook();  // already issued!

        // return book
        System.out.println("\n=== Returning Book ===");
        b1.returnBook();
        b1.issueBook();  // available again!

        // member details
        System.out.println("\n=== Members ===");
        m1.displayDetails();
        m2.displayDetails();
    }
}