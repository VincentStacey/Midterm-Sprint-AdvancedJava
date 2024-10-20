import java.util.ArrayList;

public class Author {
    private String name;
    private String dateOfBirth;
    private ArrayList<LibraryItem> itemsWritten;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        itemsWritten.add(item);
    }

    public String getName() {
        return name;
    }

    // Display author info
    public void displayInfo() {
        System.out.println("Author: " + name + ", Date of Birth: " + dateOfBirth);
        for (LibraryItem item : itemsWritten) {
            item.displayInfo();
        }
    }
}
