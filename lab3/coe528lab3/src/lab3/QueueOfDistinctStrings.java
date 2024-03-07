/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author Haque
 */
import java.util.ArrayList;
public class QueueOfDistinctStrings {
// Overview: QueueOfDistinctStrings are mutable, bounded
//           collection of distinct strings that operate in
//           FIFO (First-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
//    AF(c) = an abstract queue d (where c is a QueueOfDistinctStrings Java object) 
//    where d.front = c.items.get(0)
//          d.end = c.items.get(items.size()- 1)   
//          d.collection = c.items
//
// The rep invariant is:
// b) Write the rep invariant here
//    RI(c) = if c.items has no repeated elements and no null elements then it is true
//          = otherwise it is false
//
//
//
//the rep

    private ArrayList<String> items;
// constructor

    public QueueOfDistinctStrings() {
// EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
// MODIFIES: this
// EFFECTS : Appends the element at the end of the queue
//           if the element is not in the queue, otherwise
//           does nothing.

    public void enqueue(String element) throws Exception {
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }
    
    public String dequeue() throws Exception {
// MODIFIES: this
// EFFECTS : Removes an element from the front of the queue
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(0);
    }
    
    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
//          object; otherwise returns false
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                if ((items.get(i) != null) && (false == items.get(i).equals(j))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
//          queue, the front element and the end element.
//          Implements the abstraction function.
        String front = items.get(0);
        String end = items.get(items.size() - 1);
        
        return ("Front element: " + front + "\nEnd element: " + end + "\nQueue: " + items);
    }
    
    public static void main(String[] args) {
        
        QueueOfDistinctStrings tester = new QueueOfDistinctStrings();
        
        try {
            tester.enqueue("ab");
            tester.enqueue("cd");
            tester.enqueue("ef");
            tester.enqueue("gh");
            tester.dequeue();
            System.out.println(tester.toString());
            System.out.println("RepOK: " + tester.repOK());
        } catch (Exception x) {
            System.out.println("ERROR");
        }
    }
}