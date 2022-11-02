package lab.lab2.dLinkList;/*  CSI2114 Lab 2 - DLinkedList.java
 *
 *  Class doubly linked list
 *
 *  by Jeff Souza
 *
 */

class DLinkedList {

    ListNode firstNode;
    ListNode lastNode;

    // Appends a node to the end of the list
    void AppendNode(ListNode nNode) {
        InsertNode(nNode, lastNode);
    }

    // Inserts a node into the list after pAfter
    void InsertNode(ListNode nNode, ListNode pAfter) {
        if (pAfter == null) {
            nNode.next = firstNode;
            firstNode = nNode;
            return;
        }
        if (pAfter == lastNode) {
            lastNode.next = nNode;
            lastNode = nNode;
            return;
        }
        ListNode now = firstNode;
        while (now != null) {
            if (now == pAfter) {
                nNode.next = now.next;
                now.next = nNode;
                return;
            }
            now = now.next;
        }
        throw new IllegalArgumentException("pAfter not found in list");

    }

    // Removes the specified node from the list
    void RemoveNode(ListNode nNode) {
        if (nNode == firstNode) {
            firstNode = firstNode.next;
            return;
        }
        ListNode now = firstNode;
        while (now != null) {
            if (now.next == nNode) {
                now.next = nNode.next;
                return;
            }
            now = now.next;
        }
        throw new IllegalArgumentException("nNode not found in list");

    }

    // print the content of the list
    void print() {
        ListNode nNode = null;
        System.out.print("Current list: ");
        for (nNode = firstNode; nNode != null; nNode = nNode.next) {
            System.out.print(nNode.data + " ");
        }
        System.out.println();
    }

}