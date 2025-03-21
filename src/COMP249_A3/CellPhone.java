// -----------------------------------------------------
// Author: Shadi Marzouk
// -----------------------------------------------------

package COMP249_A3;

/**
 * The COMP249_A3.CellPhone class represents a cell phone with attributes such as serial number, brand, year of manufacture, and price.
 */
public class CellPhone {
    private long serialNum;
    private String brand;
    private int year;
    private double price;

    /**
     * Constructs a new COMP249_A3.CellPhone with the specified serial number, brand, year, and price.
     *
     * @param serialNum the serial number of the cell phone
     * @param brand the brand of the cell phone
     * @param year the manufacturing year of the cell phone
     * @param price the price of the cell phone
     */
    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * Constructs a copy of the specified COMP249_A3.CellPhone object with a new serial number.
     *
     * @param phone the COMP249_A3.CellPhone object to copy
     * @param newSerialNum the new serial number for the copied phone
     */
    public CellPhone(CellPhone phone, long newSerialNum) {
        this.serialNum = newSerialNum;
        this.brand = phone.brand;
        this.year = phone.year;
        this.price = phone.price;
    }

    /**
     * Prompts the user to enter a new serial number and returns a cloned COMP249_A3.CellPhone with the new serial number.
     *
     * @return a cloned COMP249_A3.CellPhone object with a new serial number
     */
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

    // Getters and setters

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
