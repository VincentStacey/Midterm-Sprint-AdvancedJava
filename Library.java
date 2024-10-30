import java.util.ArrayList;

class Library {
    private ArrayList<LibraryItem> items;
    private ArrayList<Author> authors;
    private ArrayList<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem item) {
        items.add(item);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public LibraryItem searchItem(String query) {
        for (LibraryItem item : items) {
            if (item.title.equalsIgnoreCase(query) || item.author.getName().equalsIgnoreCase(query)
                    || item.isbn.equals(query)) {
                return item;
            }
        }
        return null;
    }

    // Borrow and return functionality
    public void borrowItem(Patron patron, String query) {
        LibraryItem item = searchItem(query);
        if (item != null && item.numberOfCopies > 0) {
            patron.borrowItem(item);
            System.out.println("Item borrowed: " + item.title);
        } else {
            System.out.println("Item not available.");
        }
    }

    public void returnItem(Patron patron, String query) {
        LibraryItem item = searchItem(query);
        if (item != null) {
            patron.returnItem(item);
            System.out.println("Item returned: " + item.title);
        } else {
            System.out.println("Item not found.");
        }
    }
}
