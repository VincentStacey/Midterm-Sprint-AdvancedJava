import java.util.Scanner;

public class LibrarySystemDemo {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Author author1 = new Author("J.K. Rowling", "31 July 1965");
        Book book1 = new Book("1", "Harry Potter", author1, "123456789", "Bloomsbury", 5, "Printed");
        author1.addItem(book1);
        library.addLibraryItem(book1);
        library.addAuthor(author1);

        Patron student1 = new Student("John Doe", "123 Main St", "555-5555", "S001");
        library.addPatron(student1);

        // Menu-based system
        while (true) {
            System.out.println("\nLibrary Management System Menu");
            System.out.println("1. Add Library Item");
            System.out.println("2. Add Author");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addLibraryItem(scanner, library);
                    break;
                case 2:
                    addAuthor(scanner, library);
                    break;
                case 3:
                    System.out.print("Enter item title or ISBN to borrow: ");
                    String borrowQuery = scanner.nextLine();
                    library.borrowItem(student1, borrowQuery);
                    break;
                case 4:
                    System.out.print("Enter item title or ISBN to return: ");
                    String returnQuery = scanner.nextLine();
                    library.returnItem(student1, returnQuery);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addLibraryItem(Scanner scanner, Library library) {
        System.out.println("Add New Library Item:");

        System.out.print("Enter Item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter Author's Birth Date: ");
        String birthDate = scanner.nextLine();

        Author author = new Author(authorName, birthDate);
        library.addAuthor(author);

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        System.out.print("Enter Number of Copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Item Type (e.g., Printed, E-book, etc.): ");
        String itemType = scanner.nextLine();

        // Create and add new Book
        Book newBook = new Book(itemId, title, author, isbn, publisher, copies, itemType);
        library.addLibraryItem(newBook);
        author.addItem(newBook);

        System.out.println("New library item added: " + title);
    }

    private static void addAuthor(Scanner scanner, Library library) {
        System.out.println("Add New Author:");

        System.out.print("Enter Author Name: ");
        String authorName = scanner.nextLine();

        System.out.print("Enter Birth Date: ");
        String birthDate = scanner.nextLine();

        Author newAuthor = new Author(authorName, birthDate);
        library.addAuthor(newAuthor);

        System.out.println("New author added: " + authorName);
    }
}
