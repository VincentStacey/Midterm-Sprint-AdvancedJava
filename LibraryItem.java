abstract class LibraryItem {
    protected String id;
    protected String title;
    protected Author author;
    protected String isbn;
    protected String publisher;
    protected int numberOfCopies;

    public LibraryItem(String id, String title, Author author, String isbn, String publisher, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
    }

    // Common methods like getters, setters, display item info
    public abstract void displayInfo();
}

class Book extends LibraryItem {
    private String format; // printed, electronic, audio

    public Book(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            String format) {
        super(id, title, author, isbn, publisher, numberOfCopies);
        this.format = format;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + title + " by " + author.getName() + " (" + format + ")");
    }
}

class Periodical extends LibraryItem {
    private String type; // printed, electronic

    public Periodical(String id, String title, Author author, String isbn, String publisher, int numberOfCopies,
            String type) {
        super(id, title, author, isbn, publisher, numberOfCopies);
        this.type = type;
    }

    @Override
    public void displayInfo() {
        System.out.println("Periodical: " + title + " (" + type + ")");
    }
}
