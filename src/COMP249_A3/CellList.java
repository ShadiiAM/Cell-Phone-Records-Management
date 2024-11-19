// -----------------------------------------------------
// Name and ID: Shadi Marzouk, 27231466
// COMP249
// Assignment #: 3
// Due Date: December 2, 2024
// -----------------------------------------------------

package COMP249_A3;

import java.util.NoSuchElementException;

/**
 * The COMP249_A3.CellList class represents a linked list of COMP249_A3.CellPhone objects.
 */
public class CellList {
    /**
     * The CellNode class represents a node in the COMP249_A3.CellList, holding a COMP249_A3.CellPhone object and a reference to the next node.
     */
    private class CellNode {
        private CellPhone phone;
        private CellNode next;

        /**
         * Default constructor that initializes a CellNode with null values.
         */
        public CellNode() {
            this.phone = null;
            this.next = null;
        }

        /**
         * Parameterized constructor that initializes a CellNode with a COMP249_A3.CellPhone and a reference to the next node.
         *
         * @param phone the COMP249_A3.CellPhone object to store in this node
         * @param next the reference to the next node
         */
        public CellNode(CellPhone phone, CellNode next) {
            this.phone = new CellPhone(phone, phone.getSerialNum());
            this.next = next;
        }

        /**
         * Copy constructor that creates a deep copy of the specified CellNode.
         *
         * @param node the CellNode to copy
         */
        public CellNode(CellNode node) {
            this.phone = new CellPhone(node.phone, node.phone.getSerialNum());
            this.next = node.next;
        }

        /**
         * Clones the current CellNode and returns the new clone.
         *
         * @return a cloned CellNode
         */
        public CellNode clone() {
            return new CellNode(this);
        }
    }

    private CellNode head;
    private int size;

    /**
     * Constructs an empty COMP249_A3.CellList.
     */
    public CellList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Copy constructor that creates a deep copy of the specified COMP249_A3.CellList.
     *
     * @param otherList the COMP249_A3.CellList to copy
     */
    public CellList(CellList otherList) {
        if (otherList.head == null) {
            this.head = null;
            this.size = 0;
        } else {
            this.head = new CellNode(otherList.head);
            CellNode current = head;
            CellNode otherCurrent = otherList.head.next;
            while (otherCurrent != null) {
                current.next = new CellNode(otherCurrent);
                current = current.next;
                otherCurrent = otherCurrent.next;
            }
            this.size = otherList.size;
        }
    }

    /**
     * Adds a COMP249_A3.CellPhone to the start of the list.
     *
     * @param phone the COMP249_A3.CellPhone object to add
     */
    public void addToStart(CellPhone phone) {
        head = new CellNode(phone, head);
        size++;
    }

    /**
     * Inserts a COMP249_A3.CellPhone at the specified index in the list.
     *
     * @param phone the COMP249_A3.CellPhone object to insert
     * @param index the index at which to insert
     * @throws NoSuchElementException if the index is invalid
     */
    public void insertAtIndex(CellPhone phone, int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException("Invalid index");
        }
        if (index == 0) {
            addToStart(phone);
            return;
        }
        CellNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = new CellNode(phone, current.next);
        size++;
    }

    /**
     * Deletes a node from the list at the specified index.
     *
     * @param index the index of the node to delete
     * @throws NoSuchElementException if the index is invalid
     */
    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Invalid index");
        }
        if (index == 0) {
            deleteFromStart();
            return;
        }
        CellNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    /**
     * Deletes the first node from the list.
     */
    public void deleteFromStart() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

    /**
     * Replaces the COMP249_A3.CellPhone at the specified index with a new COMP249_A3.CellPhone.
     *
     * @param phone the new COMP249_A3.CellPhone object
     * @param index the index to replace
     */
    public void replaceAtIndex(CellPhone phone, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        CellNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.phone = new CellPhone(phone, phone.getSerialNum());
    }

    /**
     * Finds a node in the list by its serial number.
     *
     * @param serialNum the serial number to search for
     * @return the node containing the matching COMP249_A3.CellPhone, or null if not found
     */
    public CellNode find(long serialNum) {
        CellNode current = head;
        int iterations = 0;
        while (current != null) {
            iterations++;
            if (current.phone.getSerialNum() == serialNum) {
                System.out.println("Iterations: " + iterations);
                return current;
            }
            current = current.next;
        }
        System.out.println("Iterations: " + iterations);
        return null;
    }

    /**
     * Checks if a COMP249_A3.CellPhone with the given serial number exists in the list.
     *
     * @param serialNum the serial number to check
     * @return true if found, false otherwise
     */
    public boolean contains(long serialNum) {
        return find(serialNum) != null;
    }

    /**
     * Displays the contents of the list.
     */
    public void showContents() {
        CellNode current = head;
        System.out.println("The current list size is " + size + ". Here are the contents:");
        while (current != null) {
            System.out.print(current.phone + " --> ");
            current = current.next;
        }
        System.out.println("X");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CellList otherList = (CellList) obj;
        if (this.size != otherList.size) return false;
        CellNode current1 = this.head;
        CellNode current2 = otherList.head;
        while (current1 != null) {
            if (!current1.phone.equals(current2.phone)) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }
}
