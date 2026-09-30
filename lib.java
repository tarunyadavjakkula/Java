class Book {
    // Attributes
    String title;
    String author;
    String publisher;
    int year;
    String isbn;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        publisher = "Unknown";
        year = 0;
        isbn = "N/A";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String title, String author, String publisher,
         int year, String isbn, double price) {

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    // Copy Constructor
    Book(Book b) {
        this.title = b.title;
        this.author = b.author;
        this.publisher = b.publisher;
        this.year = b.year;
        this.isbn = b.isbn;
        this.price = b.price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Publisher  : " + publisher);
        System.out.println("Year       : " + year);
        System.out.println("ISBN       : " + isbn);
        System.out.println("Price      : " + price);
        System.out.println("-----------------------------");
    }

    // Method to search by title or author
    boolean matches(String keyword) {
        keyword = keyword.toLowerCase();

        return title.toLowerCase().contains(keyword) ||
               author.toLowerCase().contains(keyword);
    }

    // Method to apply discount
    void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }
}

// Main Class
public class LibraryCatalog {
    public static void main(String[] args) {

        // Creating array of Book objects
        Book books[] = new Book[4];

        // Using parameterized constructor
        books[0] = new Book(
                "Java Programming",
                "James Gosling",
                "Sun Publications",
                2020,
                "ISBN101",
                500);

        books[1] = new Book(
                "Data Structures",
                "Mark Allen",
                "Tech Books",
                2019,
                "ISBN102",
                450);

        books[2] = new Book(
                "Computer Networks",
                "Andrew Tanenbaum",
                "Pearson",
                2021,
                "ISBN103",
                650);

        // Using copy constructor
        books[3] = new Book(books[0]);

        // Apply discount
        books[1].applyDiscount(10);

        // Display all books
        System.out.println("BOOK DETAILS");
        System.out.println("========================");

        for (Book b : books) {
            b.displayDetails();
        }

        // Search books
        String keyword = "Java";

        System.out.println("SEARCH RESULT FOR : " + keyword);
        System.out.println("========================");

        boolean found = false;

        for (Book b : books) {
            if (b.matches(keyword)) {
                b.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }
}
