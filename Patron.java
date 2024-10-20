import java.util.ArrayList;

abstract class Patron {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected ArrayList<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
        item.numberOfCopies--;
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
        item.numberOfCopies++;
    }

    public abstract void displayInfo();
}

class Student extends Patron {
    private String studentID;

    public Student(String name, String address, String phoneNumber, String studentID) {
        super(name, address, phoneNumber);
        this.studentID = studentID;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + ", ID: " + studentID);
    }
}

class Employee extends Patron {
    private String employeeID;

    public Employee(String name, String address, String phoneNumber, String employeeID) {
        super(name, address, phoneNumber);
        this.employeeID = employeeID;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + ", ID: " + employeeID);
    }
}
