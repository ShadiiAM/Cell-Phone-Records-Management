// -----------------------------------------------------
// Assignment 3
// Written by: [Your Name] [Your Student ID]
// -----------------------------------------------------
public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    // Parameterized constructor
    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    // Copy constructor with unique serial number
    public CellPhone(CellPhone phone, long newSerialNum) {
        this.serialNum = newSerialNum;
        this.brand = phone.brand;
        this.year = phone.year;
        this.price = phone.price;
    }

    // Clone method
    public CellPhone clone() {
        System.out.print("Enter new serial number for the cloned phone: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        long newSerialNum = scanner.nextLong();
        return new CellPhone(this, newSerialNum);
    }

    @Override
    public String toString() {
        return "Serial Number: " + serialNum + ", Brand: " + brand + ", Year: " + year + ", Price: $" + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CellPhone phone = (CellPhone) obj;
        return year == phone.year && Double.compare(phone.price, price) == 0 && brand.equals(phone.brand);
    }

    // Getters and setters as needed
    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
