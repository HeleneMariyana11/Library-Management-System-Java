import java.util.*;

public class Library {
    static Scanner scanner = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            b.displayInfo();
        }
    }

    static void issueBook() {
        System.out.print("Enter book title to issue: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title) && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}
