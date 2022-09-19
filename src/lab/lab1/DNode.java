package lab.lab1;

/**
 * A simple node class for a singly-linked list.  Each node has a
 * reference to a stored element and a next node.
 * This class is based on the <code>DNode</code> class by Roberto Tamassia.
 *
 * @author Jochen Lang
 */

public class DNode {
    private Object element;
    private DNode next;
    private DNode prev;

    DNode() {
        this(null, null, null);
    }

    DNode(Object e, DNode n, DNode p) {
        element = e;
        next = n;
        prev = p;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object newElem) {
        element = newElem;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode newNext) {
        next = newNext;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode newPrev) {
        prev = newPrev;
    }
}