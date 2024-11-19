// -----------------------------------------------------
// Assignment 3
// Written by: [Your Name] [Your Student ID]
// -----------------------------------------------------
import java.util.NoSuchElementException;


public class CellList {
    private class CellNode {
        private CellPhone phone;
        private CellNode next;

        // Default constructor
        public CellNode() {
            this.phone = null;
            this.next = null;
        }

        // Parameterized constructor
        public CellNode(CellPhone phone, CellNode next) {
            this.phone = new CellPhone(phone, phone.getSerialNum());
            this.next = next;
        }

        // Copy constructor
        public CellNode(CellNode node) {
            this.phone = new CellPhone(node.phone, node.phone.getSerialNum());
            this.next = node.next;
        }

        // Clone method
        public CellNode clone() {
            return new CellNode(this);
        }
    }

    private CellNode head;
    private int size;

    // Default constructor
    public CellList() {
        this.head = null;
        this.size = 0;
    }

    // Copy constructor
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

    public void addToStart(CellPhone phone) {
        head = new CellNode(phone, head);
        size++;
    }

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

    public void deleteFromStart() {
        if (head == null) {
            return;
        }
        head = head.next;
        size--;
    }

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

    public boolean contains(long serialNum) {
        return find(serialNum) != null;
    }

    public void showContents() {
        CellNode current = head;
        System.out.println("The current list size is " + size + ". Here are the contents:");
        while (current != null) {
            System.out.print(current.phone + " --> ");
            current = current.next;
        }
        System.out.println("null");
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
