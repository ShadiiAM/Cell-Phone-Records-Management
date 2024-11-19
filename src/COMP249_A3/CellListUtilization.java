// -----------------------------------------------------
// Name and ID: Shadi Marzouk, 27231466
// COMP249
// Assignment #: 3
// Due Date: December 2, 2024
// -----------------------------------------------------

package COMP249_A3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The COMP249_A3.CellListUtilization class is the main driver program that demonstrates the functionality of the COMP249_A3.CellList class.
 */
public class CellListUtilization {
    public static void main(String[] args) {
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        /**
         * Reads cell phone records from Cell_Info.txt, adds them to a COMP249_A3.CellList, and ensures no duplicate serial numbers are added.
         */
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

        // Shows the contents of the list
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

        // Goodbye message
        System.out.println("Thank you for using the COMP249_A3.CellList program. Goodbye!");
    }
}
