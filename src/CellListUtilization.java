// -----------------------------------------------------
// Assignment 3
// Written by: [Your Name] [Your Student ID]
// -----------------------------------------------------
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {
    public static void main(String[] args) {
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        // Reading from Cell_Info.txt
        try (Scanner fileScanner = new Scanner(new File("Cell_Info.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split("\\s+");
                long serialNum = Long.parseLong(data[0]);
                String brand = data[1];
                double price = Double.parseDouble(data[2]);
                int year = Integer.parseInt(data[3]);
                CellPhone phone = new CellPhone(serialNum, brand, year, price);

                if (!list1.contains(serialNum)) {
                    list1.addToStart(phone);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Show the contents of the list
        list1.showContents();

        // User interaction for searching serial numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a serial number to search (or -1 to stop): ");
        long serialNum = input.nextLong();
        while (serialNum != -1) {
            if (list1.find(serialNum) != null) {
                System.out.println("Phone found.");
            } else {
                System.out.println("Phone not found.");
            }
            System.out.print("Enter a serial number to search (or -1 to stop): ");
            serialNum = input.nextLong();
        }

    }
}
