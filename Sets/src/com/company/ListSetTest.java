package com.company;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListSetTest {

	@Test
	public void init() {
		int data = 5;
		ListSet<Integer> expected = new ListSet<Integer>();
		expected.init(data);
		
		ListSet<Integer> actual = new ListSet<Integer>();
		NodeList<Integer> tmp = new NodeList<Integer>();
		tmp.next = null;
		tmp.value = data;
		actual.setHead(tmp);
		actual.setTail(tmp);
		
		assertTrue("Error in init!", actual.comp(expected));
	}
	
	@Test
	public void addition_head() {
		int data = 5;
		ListSet<Integer> expected = new ListSet<Integer>();
		expected.init(3);
		expected.addition_head(data);
		
		ListSet<Integer> actual = new ListSet<Integer>();
		actual.init(3);
		NodeList<Integer> tmp = new NodeList<Integer>();
		tmp.next = actual.getHead();
		tmp.value = data;
		actual.setHead(tmp);
		
		assertTrue("Error in add head!", actual.comp(expected));
	}
	
	@Test
	public void addition_tail() {
		int data = 5;
		ListSet<Integer> expected = new ListSet<Integer>();
		expected.init(3);
		expected.addition_tail(data);
		
		ListSet<Integer> actual = new ListSet<Integer>();
		actual.init(3);
		
		NodeList<Integer> tmp = new NodeList<Integer>();
		tmp.next = null;
		tmp.value = data;
		actual.getTail().next = tmp;
		actual.setTail(tmp);
		
		assertTrue("Error in add tail!", actual.comp(expected));
	}
	
	@Test
	public void search() {
		
		int data = 3;
		boolean exp1;
		boolean exp2;
		
		ListSet<Integer> arr = new ListSet<Integer>();
		arr.init(1);
		for (int i = 2; i<6; i++) arr.addition_tail(i);
		
		
		NodeList<Integer> it = new NodeList<Integer>();
		it = arr.getHead();
		boolean flag = false;
		while(it != null && !flag) {
			if (it.value == data) flag = true;
			it = it.next;
			}
		
		exp1 = arr.search(data) == flag;
		
		data = 6;
		
		it = new NodeList<Integer>();
		it = arr.getHead();
		flag = false;
		while(it != null && !flag) {
			if (it.value == data) flag = true;
			it = it.next;
			}
		
		exp2 = arr.search(data) == flag;
		
		assertTrue("Error in add search!", exp1 == exp2);
	}
	
	@Test
	public void delete_elem() {
		
		int data = 5;
		
		ListSet<Integer> expected = new ListSet<Integer>();
		for (int i = 2; i<6; i++) expected.addition_tail(i);
		
		expected.delete_elem(data);
		
		ListSet<Integer> actual = new ListSet<Integer>();
		for (int i = 2; i<5; i++) actual.addition_tail(i);
		
		assertTrue("Error in delete!", actual.comp(expected));
	}
	
	@Test
	public void comp() {
		
		int data = 5;
		
		ListSet<Integer> arr1 = new ListSet<Integer>();
		for (int i = 2; i<6; i++) arr1.addition_tail(i);
		
		ListSet<Integer> arr2 = new ListSet<Integer>();
		for (int i = 2; i<5; i++) arr2.addition_tail(i);
		
		boolean test1 = arr1.comp(arr2);
		
		arr1.delete_elem(data);
		
		boolean test2 = arr1.comp(arr2);
		
		assertTrue("Error in comp!", !test1 && test2);
	}
}
