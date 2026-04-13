import java.util.*;

class Movie {
    private String title;
    private int movieId;
    private String timing;
    private double ticketPrice;
    private int totalSeats;
    private int availableSeats;

    Movie(String t, int id, String time, double price, int seats) {
        title = t;
        movieId = id;
        timing = time;
        ticketPrice = price;
        totalSeats = seats;
        availableSeats = seats;
    }

    public String getTitle() { return title; }
    public int getMovieId() { return movieId; }
    public String getTiming() { return timing; }
    public double getTicketPrice() { return ticketPrice; }
    public int getAvailableSeats() { return availableSeats; }

    boolean bookSeat() {
        if(availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            System.out.println("No seats available!");
            return false;
        }
    }

    void cancelSeat() {
        if(availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    void displayDetails() {
        System.out.println("ID: " + movieId);
        System.out.println("Title: " + title);
        System.out.println("Timing: " + timing);
        System.out.println("Price: Rs." + ticketPrice);
        System.out.println("Available Seats: " + availableSeats);
    }
}

class Ticket {
    private static int ticketCounter = 1;
    private int ticketId;
    private String customerName;
    private String movieTitle;
    private String timing;
    private String seatNumber;
    private double price;

    Ticket(String name, String movie, String time, String seat, double price) {
        ticketId = ticketCounter++;
        customerName = name;
        movieTitle = movie;
        timing = time;
        seatNumber = seat;
        this.price = price;
    }

    public int getTicketId() { return ticketId; }
    public String getCustomerName() { return customerName; }
    public String getMovieTitle() { return movieTitle; }

    void displayTicket() {
        System.out.println("\n=============================");
        System.out.println("        MOVIE TICKET         ");
        System.out.println("=============================");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Customer: " + customerName);
        System.out.println("Movie: " + movieTitle);
        System.out.println("Timing: " + timing);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: Rs." + price);
        System.out.println("=============================");
    }
}

public class Moviebookingsystem {
    static Movie[] movies = new Movie[10];
    static Ticket[] tickets = new Ticket[50];
    static int movieCount = 0;
    static int ticketCount = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // add default movies
        movies[movieCount++] = new Movie("KGF", 101, "10:00 AM", 150.0, 50);
        movies[movieCount++] = new Movie("Pushpa", 102, "1:00 PM", 200.0, 40);
        movies[movieCount++] = new Movie("RRR", 103, "6:00 PM", 250.0, 30);

        int choice;
        do {
            System.out.println("\n=== Movie Ticket Booking System ===");
            System.out.println("1. View All Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View My Tickets");
            System.out.println("5. Search Movie");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    displayAllMovies();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    viewMyTickets();
                    break;
                case 5:
                    searchMovie();
                    break;
                case 6:
                    System.out.println("Thank you for booking!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while(choice != 6);
    }

    static void displayAllMovies() {
        System.out.println("\n=== Available Movies ===");
        for(int i = 0; i < movieCount; i++) {
            movies[i].displayDetails();
            System.out.println("---");
        }
    }

    static Movie findMovie(int id) {
        for(int i = 0; i < movieCount; i++) {
            if(movies[i].getMovieId() == id) {
                return movies[i];
            }
        }
        return null;
    }

    static void bookTicket() {
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter movie ID: ");
        int id = sc.nextInt();
        Movie m = findMovie(id);
        if(m == null) {
            System.out.println("Movie not found!");
            return;
        }
        System.out.print("Enter seat number (e.g. A1, B2): ");
        String seat = sc.next();
        if(m.bookSeat()) {
            Ticket t = new Ticket(name, m.getTitle(), m.getTiming(), seat, m.getTicketPrice());
            tickets[ticketCount++] = t;
            t.displayTicket();
            System.out.println("Ticket booked successfully!");
        }
    }

    static void cancelTicket() {
        System.out.print("Enter ticket ID to cancel: ");
        int ticketId = sc.nextInt();
        boolean found = false;
        for(int i = 0; i < ticketCount; i++) {
            if(tickets[i].getTicketId() == ticketId) {
                Movie m = findMovie(0);
                System.out.println("Ticket for " + tickets[i].getMovieTitle() + " cancelled!");
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Ticket not found!");
        }
    }

    static void viewMyTickets() {
        System.out.print("Enter your name: ");
        String name = sc.next();
        boolean found = false;
        for(int i = 0; i < ticketCount; i++) {
            if(tickets[i].getCustomerName().equalsIgnoreCase(name)) {
                tickets[i].displayTicket();
                found = true;
            }
        }
        if(!found) {
            System.out.println("No tickets found for " + name);
        }
    }

    static void searchMovie() {
        System.out.print("Enter movie title: ");
        String title = sc.next();
        boolean found = false;
        for(int i = 0; i < movieCount; i++) {
            if(movies[i].getTitle().equalsIgnoreCase(title)) {
                movies[i].displayDetails();
                found = true;
            }
        }
        if(!found) {
            System.out.println("Movie not found!");
        }
    }
}