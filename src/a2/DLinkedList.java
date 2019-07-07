package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.AssertionFailedError;

/**
 * An instance is a doubly linked list. It provides much of the functionality
 * of Java class java.util.LinkedList.
 */
public class DLinkedList<E> extends java.util.AbstractList<E> {
    /** Number of nodes in the linked list. */
    private int size;

    /** first node of the linked list (null if the list is empty) */
    private Node head;

    /** last  node of the linked list (null if the list is empty) */
    private Node tail;
    
    /** Constructor: an empty linked list. */
    public DLinkedList() {
        // Look at the class invariant to determine how to implement this.
    	this.head = null;
    	this.tail = null;
    	this.size = 0;
    }

    /**
     * Return the number of elements in this list.
     * This operation must take constant time.
     */
    public @Override int size() {
        // This is an extremely small method
        return size;
    }

    /**
     * Return "[s0, s1, .., sn]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[6, 3, 8]".
     */
    public @Override String toString() {
        String res= "[";
        // invariant: res = "[s0, s1, .., sk" where sk is the object before node n
        for (Node n = head; n != null; n= n.succ) {
            if (n != head)
                res= res + ", ";
            res= res + n.data;
        }
        return res + "]";
    }

    /**
     * Return "[sn, .., s1, s0]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[8, 3, 6]".
     */
    public String toStringRev() {
        // This should use field tail and the pred fields in nodes.
        // Do NOT use field size.
       String res = "[";
    	for (Node n = tail; n!=null; n=n.pred) {
    		if(n!=tail)
    			res = res+ ", ";
    		res = res+n.data;
    		
    	}
    	
    	return res + "]";
    }
    
    /**
     * Place element in a new node at the end of the list and return the new node.
     * This operation must take constant time.
     */
    private Node append(E element) {
        // This mid-size helper function will be used by other methods
    	
    	if (size == 0) {
    		Node newNode = new Node(null,element,null);
    		head = newNode;
    		tail = head;
    		size++;
    		return newNode;
    	}else {
    		Node newNode = new Node(tail, element, null);
    		tail.succ = newNode;
    		tail = newNode;
    		size++;
    		return newNode;
    	}
   	    	
    }
    
    /** Append element to the end of this list and return true. */
    public @Override boolean add(E element) {
        // TODO item #5
        // Rely on helper methods to keep this method small
        // This is THE MOST IMPORTANT method to get right because it will be used
        // in nearly every test
        append(element);
        return (tail.data == element);
    }
    
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    private Node getNode(int index) {
        // TODO item #6
        // This large helper method is used more than any other helper method
        // It is used by other public methods or for testing.
        // Note that there are two ways to get to a node: from the head or from the tail.
        // This MUST use the fastest way for index.
        // (If h is exactly the middle, then either way is ok.)
    		if(index <= size/2) {
    			int i = 0;
    			Node nodeNow = head;
    			while(i< index) {
    				nodeNow = nodeNow.succ;
    				i++;
    			}
    			return nodeNow;
    		} else {
    			int i = size-1;
    			Node nodeNow = tail;
    			while(i!=index) {
    				nodeNow = nodeNow.pred;
    				i--;
    			}
    			return nodeNow;
    		}
    }
    
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E get(int index) {
        // TODO item #7
        // Rely on helper methods to keep this method small.
        // Note that the helper method could throw the exception; doesn't
        // have to be done here.
        throw new NotImplementedError();
    }
    
    /**
     * Replace the element at the given index of this list with e.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @param e     the new value to place in the list
     * @return      the former value stored at the index
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E set(int index, E element) {
        // TODO item #8
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        throw new NotImplementedError();
    }
    
    /**
     * Insert element in a new node at the beginning of the list and return the
     * new node.
     * Runs in constant time.
     */
    private Node prepend(E element) {
        // TODO item #9
        // This mid-size helper function will be used by other methods
        throw new NotImplementedError();
    }
    
    /**
     * Insert element into a new node before Node node and return the new node.
     * Takes constant time.
     *
     * @param element the element to insert
     * @param node a non-null Node that must be in this list
     */
    private Node insertBefore(E element, Node node) {
        // TODO item #10
        // This mid-size helper function will be used by other methods.
        // Do NOT test whether node is actually a Node of this list because
        // it will then not be a constant-time operation.
        throw new NotImplementedError();
    }
    
    /**
     * Insert e into this list at position i.
     * The element currently at index i, as well as all later elements, are
     * shifted down to make room for element.
     * Takes time proportional to min (index, size - index).
     *
     * @param e the element to insert
     * @param i the place to put e, in [0..size] (note: i == size is allowed!)
     * @throws IndexOutOfBoundsException if i is not in [0..size]
     */
    public @Override void add(int index, E element) {
        // TODO item #11
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        throw new NotImplementedError();
    }
    
    /**
     * Remove n from this list and return its data.
     *
     * @param  n the node to remove.  It must be in this list and non-null.
     * @return the data inside of n
     */
    private E removeNode(Node n) {
        // TODO item #12
        // This is a large helper method
        throw new NotImplementedError();
    }
    
    /**
     * Remove and return the element at index i.
     * Takes time proportional to min(i, size - i).
     *
     * @param i the index of the element to remove, in [0..size).
     *          0 is the first element, 1 is the second, etc.
     * @return the removed element
     * @throws IndexOutOfBoundsException if i is not in [0..size)
     */
    public @Override E remove(int i) {
        // TODO item #13
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        throw new NotImplementedError();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    /** An instance is a node of this list. */
    private class Node {
        /** Predecessor of this node on list (null if this is the first node). */
        private Node pred;
        
        /** The data in this element. */
        private E data;
        
        /** Successor of this node on list. (null if this is the last node). */
        private Node succ;
        
        /** Constructor: an instance with predecessor node p (can be null),
          * successor node s (can be null), and data e. */
        private Node(Node p, E e, Node s) {
            this.pred = p;
            this.succ = s;
            this.data = e;
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Glass-box tests for DLinkedList.  Since this is an inner
     * class, it has access to DLinkedList's private types, fields, and methods.
     */
    public static class Tests {

        /**
         * Asserts that list satisfies its invariants.  It is useful to call
         * this after any tests that modify a linked list to ensure that the
         * list remains well-formed.
         *
         * @throws AssertionFailedError if the list is not well-formed
         */
        private static void assertInvariants(DLinkedList<?> list) {
            try{
            assertEquals(list.getNode(0), list.head);
            assertEquals(list.getNode(list.size-1),list.tail);
            assertEquals(list.size(), list.size);
            }catch(AssertionFailedError e) {
            	throw new AssertionFailedError("list is not well-formed");
            }
       
        }
        
        @Test
        public void testConstructor() {
        	DLinkedList<Integer> intList = new DLinkedList<Integer>();
        	assertInvariants(intList);
        	intList.append(2);
        	assertInvariants(intList);
        	intList.append(50);
        	intList.append(222);
        	intList.append(456);
        	intList.append(10000);
        	intList.append(2);
        	assertInvariants(intList);
        	
        }
        
        @Test
        public void testAdd() {
        	DLinkedList<String> strList = new DLinkedList<String>();
        	strList.add("kurt");
        	strList.add("chua");
        	strList.add("zeen");
        	strList.add("wang");
        	strList.add("bob");
        	strList.add("cornell");
        	strList.add("ezra");
        	strList.add("andrew");
        	strList.add("mary");
        	strList.add("nancy");
        	
        	System.out.println(strList.toString());
        	System.out.println(strList.toStringRev());
        	
        	assertEquals("kurt",strList.getNode(0).data);
        	assertEquals("chua",strList.getNode(1).data);
        	assertEquals("zeen",strList.getNode(2).data);
        	assertEquals("wang",strList.getNode(3).data);
        	assertEquals("bob",strList.getNode(4).data);
        	assertEquals("cornell",strList.getNode(5).data);
        	assertEquals("ezra",strList.getNode(6).data);
        	assertEquals("andrew",strList.getNode(7).data);
        	assertEquals("mary",strList.getNode(8).data);
        	assertEquals("nancy",strList.getNode(9).data);
        	
        	
        	
        	
        }
        @Test
        public void testAppend() {
            DLinkedList<String> ll     = new DLinkedList<String>();
            DLinkedList<String>.Node n = ll.append("Mike");
            assertEquals("[Mike]", ll.toString());
            assertEquals("[Mike]", ll.toStringRev());
            assertEquals(1, ll.size());
            assertEquals(ll.tail, n);   
        }

        /** Compare DLinkedList to standard library list */
        @Test
        public void testToString() {
            List<Integer>  ll = new java.util.LinkedList<Integer>();
            List<Integer> dll = new DLinkedList<Integer>();
            
            assertEquals(dll.toString(), ll.toString());

            dll.add(5); ll.add(5);
            assertEquals(dll.toString(), ll.toString());
            
            dll.add(4); ll.add(4);
            assertEquals(dll.toString(), ll.toString());
            
        }
        
        @Test
        public void testToStringRev() {
     
        }
    }
}