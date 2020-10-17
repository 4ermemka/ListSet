package com.company;

/**
 * Single NodeList of the List
*/

class NodeList <E> {
	/** any number/symbol/word */
    E value;
    /** switching to the next element of the list */
    NodeList<E> next;
}

/**
 * List of objects
 */

class ListSet <E> {
	    /** switch to the head of the list (first element)*/
	    private NodeList<E> head;
	    /** switch to the tail of the list (last element)*/
	    private NodeList<E> tail;

	    /**
	     * Initializing the list with the first element
	     * @param data any type of data
	     */

	    void init (E data) {
	        NodeList<E> elem = new NodeList<E>();
	        elem.next = null;
	        elem.value = data;
	        head = elem;
	        tail = elem;
	    }
	    
	    /**
	     * Sets new head to the list
	     * @param t new Head
	     */
	    
	    void setHead(NodeList<E> t) {
	    	head = t;
	    }
	    
	    /**
	     * Sets new tail to the list
	     * @param t new Tail
	     */
	    
	    void setTail(NodeList<E> t) {
	    	tail = t;
	    }
	    
	    /**
	     * Getting list's first element
	     * @return head of the list
	     */
	    
	    NodeList<E> getHead() {
	    	return head;
	    }
	    
	    /**
	     * Getting list's last element
	     * @return tail of the list
	     */
	    
	    NodeList<E> getTail() {
	    	return tail;
	    }

	    /**
	     * Adding new element to the left part of the list
	     * (only adds items that are not already in the list)
	     * @param data any type of data
	     */

	    void addition_head (E data) {
	        if (!search(data)) {
	            NodeList<E> temp = new NodeList<E>();
	            temp.value = data;
	            if (head == null) init (data);
	            else {
	                temp.next = head;
	                head = temp;
	            }
	        }
	    }

	    /**
	     * Adding new element to the right part of the list
	     * (only adds items that are not already in the list)
	     * @param data any type of data
	     */

	    void addition_tail (E data) {
	        if (!search(data)){
	            NodeList<E> temp = new NodeList<E>();
	            temp.value = data;
	            if (tail == null) init (data);
	            else {
	                tail.next = temp;
	                tail = temp;
	            }
	        }
	    }

	    /**
	     * Checks if an item is in the list
	     * @param data any type of data
	     * @return true if element is in the list and false if not
	     */

	    boolean search (E data) {
	        NodeList<E> tmp = head;
	        while (tmp != null) {
	            if (tmp.value == data) return true;
	            tmp = tmp.next;
	        }
	        return false;
	    }

	    /**
	     * Removes the element with the value = data, if any
	     * @param data any type of data
	     */

	    void delete_elem(E data) {
	        if(head == null)
	            return;

	        if (head == tail) {
	            head = null;
	            tail = null;
	            return;
	        }

	        if (head.value == data) {
	            head = head.next;
	            return;
	        }

	        NodeList<E> tmp = head;
	        while (tmp.next != null) {
	            if (tmp.next.value == data) {
	                if (tail == tmp.next) {
	                    tail = tmp;
	                }
	                tmp.next = tmp.next.next;
	                return;
	            }
	            tmp = tmp.next;
	        }
	    }
	    
	    /**
	     * Comparing this list with another one
	     * @param list List to compare this with
	     * @return true if list's are equal and false if not
	     */
	    
	    boolean comp(ListSet<E> list){
	    	NodeList<E> a = new NodeList<E>();
	    	NodeList<E> b = new NodeList<E>();
	    	
	    	a = list.head;
	    	b = head;
	    	
	    	while (a != null && b != null){
	    		if (a.value != b.value) return false;
	    		a = a.next;
	    		b = b.next;
	    	}
	    	if (a == null && b == null) return true;
	    	return false;
	    }

	    /**
	     * Displays values from a list to the screen
	     */

	    void print_list () {
	        NodeList<E> tmp = head;
	        while (tmp != null) {
	            System.out.print (tmp.value + " ");
	            tmp = tmp.next;
	        }
	        System.out.println();
	    }
}
