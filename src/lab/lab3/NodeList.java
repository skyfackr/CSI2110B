package lab.lab3;// ==========================================================================
// $Id: addTemplate.cpp,v 1.1 2005/11/02 23:13:32 jlang Exp $
// CSI2110 Lab code Node List skeleton class
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: addTemplate.cpp,v $
//
// ==========================================================================
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class NodeList<E> {
  // The linked list which is to be adapted
  protected LinkedList<E> linkedList = new LinkedList<E>();

  // Directly available
  public int size() {
    return linkedList.size();
  }

  // Directly available
  public boolean isEmpty() {
     return linkedList.isEmpty();
  }

  // fix me!
  public boolean isFirst(E element) {
    return element.equals(this.first());
  }

  // fix me!
  public boolean isLast(E element) {
    return element.equals(this.last());
  }

  // Directly available
  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }


  // Directly available
  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  // fix me!
  E prev(E element)
    throws NoSuchElementException {
    if (this.isFirst(element)) {
      return null;
    }
    if (linkedList.contains(element)) {
      return linkedList.get(linkedList.indexOf(element) - 1);
    }
    throw new NoSuchElementException();
  }


  // fix me!
  E next(E element)
    throws NoSuchElementException {
    if (this.isLast(element)) {
      return null;
    }
    if (linkedList.contains(element)) {
      return linkedList.get(linkedList.indexOf(element) + 1);
    }
    throw new NoSuchElementException();
  }

  // fix me!
  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
    if (!linkedList.contains(element1) || !linkedList.contains(element2)) {
      throw new NoSuchElementException();
    }
    int index1 = linkedList.indexOf(element1);
    int index2 = linkedList.indexOf(element2);
    linkedList.set(index1, element2);
    linkedList.set(index2, element1);
  }
  

  // fix me!
  public void set(E currElement, E repElement)
    throws NoSuchElementException {
    if (!linkedList.contains(currElement)) {
      throw new NoSuchElementException();
    }
    linkedList.set(linkedList.indexOf(currElement), repElement);
  }


  // Directly available
  public void addFirst(E element) {
    linkedList.addFirst(element);
    return;
  }

  // Directly available
  public void addLast(E element) {
    linkedList.addLast(element);
    return;
  }

  // fix me!
  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
    if (!linkedList.contains(currElement)) {
      throw new NoSuchElementException();
    }
    linkedList.add(linkedList.indexOf(currElement), addElement);
  }

  // fix me!
  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
    if (!linkedList.contains(currElement)) {
      throw new NoSuchElementException();
    }
    if(this.isLast(currElement)) {
      linkedList.addLast(addElement);
    } else {
      linkedList.add(linkedList.indexOf(currElement) + 1, addElement);
    }
  }
  
  // fix me!
  public E remove(E element) 
    throws NoSuchElementException {
    if (!linkedList.contains(element)) {
      throw new NoSuchElementException();
    }
    return linkedList.remove(linkedList.indexOf(element));
  }
}
