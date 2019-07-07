package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.AssertionFailedError;

/**
 * An instance is a doubly linked list. It provides much of the functionality
 * of Java class java.util.LinkedList.
 * 
 * Author: Kurt Chua
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
    			while(i>index) {
    				nodeNow = nodeNow.pred;
    				i--;
    			}
    			return nodeNow;
    		}
    }
    
    /**
     * Return the element at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E get(int index) {        // Rely on helper methods to keep this method small.
        // Note that the helper method could throw the exception; doesn't
        // have to be done here.
        
    	return getNode(index).data;
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
     if(index<0 || index>=size) {
    	 throw new IndexOutOfBoundsException("index is not in [0..size)");
     }
     E oldVal = get(index);
     getNode(index).data= element;
     return oldVal;
    }
    
    /**
     * Insert element in a new node at the beginning of the list and return the
     * new node.
     * Runs in constant time.
     */
    private Node prepend(E element) {
        // TODO item #9
        // This mid-size helper function will be used by other methods
        if (size==0) {
        	Node newNode = new Node(null,element,null);
        	head = newNode;
        	tail = head;
        	size++;
        	return newNode;
        }else {
        	Node newNode = new Node(null,element,head);
        	head.pred = newNode;
        	head = newNode;
        	size++;
        	return newNode;
        }
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
        if (node==head) {
        	return prepend(element);
        }
        Node prevNode = node.pred;
        Node newNode = new Node(prevNode,element,node);
        prevNode.succ = newNode;
        node.pred = newNode;
        return newNode;
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
        if(index < 0 || index > size) {
        	throw new IndexOutOfBoundsException("i is not in [0..size]");
        }
        insertBefore(element, getNode(index));
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
         if(n==head) {
        	 head.succ = head;
        	 head.pred = null;
        	 return n.data;
         }
         
         if(n==tail) {
        	 tail.pred = tail;
        	 tail.succ = null;
        	 return n.data;
         }else {
        	 Node nextNode = n.succ;
        	 Node predNode = n.pred;
        	 n.succ = null;
        	 n.pred = null;
        	 predNode.succ = nextNode;
        	 nextNode.pred = predNode;
        	 return n.data;
         }
         
         
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
        if(i<0 || i>=size) {
        	throw new IndexOutOfBoundsException("i is not in [0..size)");
        }
        
       return removeNode(getNode(i));
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
        	strList.add("mark");
        	
        	assertInvariants(strList);
        	
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
        public void testGet() {
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
        	strList.add("mark");
        	
        	assertInvariants(strList);
        	
        	assertEquals("kurt",strList.get(0));
        	assertEquals("chua",strList.get(1));
        	assertEquals("zeen",strList.get(2));
        	assertEquals("wang",strList.get(3));
        	assertEquals("bob",strList.get(4));
        	assertEquals("cornell",strList.get(5));
        	assertEquals("ezra",strList.get(6));
        	assertEquals("andrew",strList.get(7));
        	assertEquals("mary",strList.get(8));
        	assertEquals("nancy",strList.get(9));
        	
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
        
        @Test
        public void testSet() {
        	DLinkedList<Integer> intList = new DLinkedList<Integer>();
        	assertInvariants(intList);
        	intList.add(0);
        	intList.add(1);
        	intList.add(2);
        	intList.add(3);
        	intList.add(4);
        	intList.add(5);
        	intList.add(6);
        	intList.add(7);
        	intList.add(8);
        	intList.add(9);
        	intList.add(10);
        	
        	assertInvariants(intList);
        	

        	assertEquals(0, intList.get(0));
        	assertEquals(1, intList.get(1));
        	assertEquals(2, intList.get(2));
        	assertEquals(3, intList.get(3));
        	assertEquals(4, intList.get(4));
        	assertEquals(5, intList.get(5));
        	assertEquals(6, intList.get(6));
        	assertEquals(7, intList.get(7));
        	assertEquals(8, intList.get(8));
        	assertEquals(9, intList.get(9));
        	assertEquals(10, intList.get(10));
        	
        	assertEquals(0,intList.set(0, 10));
        	assertEquals(1,intList.set(1, 9));
        	assertEquals(2,intList.set(2, 8));
        	assertEquals(3,intList.set(3, 7));
        	assertEquals(4,intList.set(4, 6));
        	assertEquals(5,intList.set(5, 5));
        	assertEquals(6,intList.set(6, 4));
        	assertEquals(7,intList.set(7, 3));
        	assertEquals(8,intList.set(8, 2));
        	assertEquals(9,intList.set(9, 1));
        	assertEquals(10,intList.set(10, 0));
        	
        	assertInvariants(intList);
        	
        	assertEquals(10, intList.get(0));
        	assertEquals(9, intList.get(1));
        	assertEquals(8, intList.get(2));
        	assertEquals(7, intList.get(3));
        	assertEquals(6, intList.get(4));
        	assertEquals(5, intList.get(5));
        	assertEquals(4, intList.get(6));
        	assertEquals(3, intList.get(7));
        	assertEquals(2, intList.get(8));
        	assertEquals(1, intList.get(9));
        	assertEquals(0, intList.get(10));
        }
        
       @Test
       public void testPrepend() {
    	   DLinkedList<String> strList = new DLinkedList<String>();
    	   // prepend empty list
    	   strList.prepend("kurt");
    	   System.out.println(strList.toString());
    	   assertInvariants(strList);
    	   strList.add("chua");
       	   strList.add("zeen");
       	   strList.add("wang");
           strList.add("bob");
       	   strList.add("cornell");
       	   strList.add("ezra");
       	   strList.add("andrew");
           strList.add("mary");
       	   strList.add("nancy");
       	   strList.add("mark");
           assertInvariants(strList);
           System.out.println(strList.toString());
           strList.prepend("first");
           assertEquals("first",strList.get(0));
    	   
           System.out.println(strList.toString());
       }
       @Test
       public void testInsertBefore() {
    	   DLinkedList<Integer> intList = new DLinkedList<Integer>();
    	   intList.add(0);
    	   System.out.println(intList);
    	   intList.insertBefore(-1, intList.getNode(0));
    	   System.out.println(intList);
    	   intList.add(1);
	       intList.add(2);
	       intList.add(3);
	       intList.add(4);
	       intList.add(5);
	       intList.add(6);
	       intList.add(7);
	       intList.add(8);
	       intList.add(9);
	       intList.add(10);
	       System.out.println(intList);
	       intList.insertBefore(-2, intList.getNode(0));
	       intList.insertBefore(-3, intList.getNode(0));
	       intList.insertBefore(-4, intList.getNode(0));
	       intList.insertBefore(-5, intList.getNode(0));
	       intList.insertBefore(-6, intList.getNode(0));
	       intList.insertBefore(-7, intList.getNode(0));
	       intList.insertBefore(-8, intList.getNode(0));
	       intList.insertBefore(-9, intList.getNode(0));
	       intList.insertBefore(-10, intList.getNode(0));
	       System.out.println(intList);
	     
	       assertInvariants(intList);
    	   
       }
       
       @Test
       public void addNodeIndex() {
    	   DLinkedList<String> strList = new DLinkedList<String>();
    	   strList.add(0, "b");
    	   System.out.println(strList.toString());
    	   
    	   
    	   
    	   
    	   
       }
    }
}