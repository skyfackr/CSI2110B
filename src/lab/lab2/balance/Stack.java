package lab.lab2.balance;

public interface Stack {

    // Return the number of elements.
    int size();

    // Tests if the stack is empty.
    boolean isEmpty();

    // Inspect the top element, without removing it or otherwise modifying the stack.
    Object top() throws StackEmptyException;

    // Insert an element at the top.
    void push(Object element) throws StackFullException;

    // Remove the top element.
    Object pop() throws StackEmptyException;

}