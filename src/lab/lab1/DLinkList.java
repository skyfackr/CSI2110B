package lab.lab1;

/**
 * Builds a singly linked list of size 5 and prints it to the console.
 *
 * @author Jochen Lang
 */

class DLinkList {
    DNode llist;
    DNode last;

    DLinkList(int sz) {
        if (sz <= 0) {
            llist = null;
        } else {
            // start with list of size 1
            llist = new DNode("0", null, null);
            DNode current = llist; // temp node for loop
            // add further nodes
            for (int i = 1; i < sz; ++i) {
                // create node and attach it to the list
                DNode node2Add = new DNode(Integer.toString(i), null, null);
                node2Add.setPrev(current);
                current.setNext(node2Add);   // add first node
                current = node2Add;
                this.last = current;
            }
        }
    }

    // create and display a linked list
    public static void main(String[] args) {
        /* Create the list */
        DLinkList llist = new DLinkList(5);
        /* Print the list */
        llist.print();
        /* delete first and print */
        llist.deleteFirst();
        llist.print();
        /* delete last and print 5 times */
        for (int i = 0; i < 5; ++i) {
            llist.deleteLast();
            llist.print();
        }
    }

    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
        /* Print the list */
        DNode current = llist; // point to the first node
        while (current != null) {
            System.out.print((String) current.getElement() + " ");
            current = current.getNext(); // move to the next
        }
        System.out.println();
    }

    public void deleteFirst() {
        if (llist != null) {
            llist = llist.getNext();
        }
    }

    public void deleteLast() {
        if (llist != null) {
            if (llist.getNext() == null) {
                this.deleteFirst();
                return;
            }
            this.last = this.last.getPrev();
            this.last.setNext(null);
        }
    }
}
