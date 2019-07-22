package a4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;


public class Heap<E,P> implements PriorityQueue<E, P>{
	//
	private ArrayList<E> data=new ArrayList<E>();
	private ArrayList<P> priority=new ArrayList<P>();
	private Comparator<P> c=null;
	private HashMap<E, Integer> hashMap= new HashMap<E, Integer>();
	
	/**
	 * Constructor: an empty heap with a comparator
	 * @param c the given comparator for this heap
	 * */
	public Heap(Comparator<P> c){
		this.c=c;
	}
	
	/**
	 * Returns the comparator used to order the priorities 
	 * of this heap
	 * */
	@Override
	public Comparator<? super P> comparator() {
		return (Comparator<? super P>) c;
	}
	
	/**
	 * Returns the size of this heap.
	 * Runs in O(1) constant time. 
	 * */
	@Override
	public int size() {
		return data.size();
	}
	
	/**
	 * Removes and returns the highest priority in the heap
	 * Runs in O(log n) time
	 * @throws NoSuchElementException if this heap is empty 
	 * */
	@Override
	public E poll() throws NoSuchElementException {
		if(size()==0)
			throw new NoSuchElementException();
		E returnValue=data.get(0);
		swap(0, size()-1);
		
		//remove the largest one.
		hashMap.remove(data.get(size()-1),size()-1);
		priority.remove(size()-1);
		data.remove(size()-1);
		moveDown(0);
		return returnValue;
		
	}
	
	/**
	 * Return the value of this heap with the highest priority
	 * Runs in O(1) constant time
	 * */
	@Override
	public E peek() throws NoSuchElementException {
		if(size()==0)
			throw new NoSuchElementException();
		return data.get(0);
	}
	
	/**
	 * 
	 * */
	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		if(data.contains(e))
			throw new IllegalArgumentException();
		data.add(e);
		priority.add(p);
		hashMap.put(e,size()-1);
		moveUp(size()-1);
	}


	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		if(size()==0)
			throw new NoSuchElementException();
		priority.set(hashMap.get(e), p);
		moveUp(hashMap.get(e));
		moveDown(hashMap.get(e));
	}
	
	public int left(int i) {
		return 2*i+1;
	}
	
	public int right(int i) {
		return 2*i+2;
	}
	
	public int parent(int i) {
		return (i-1)/2;
	}
	
	/** swap the first element with the second one.*/
	private void swap(int first, int second) {
		E bufferData=data.get(first);
		P bufferPriority= priority.get(first);
		hashMap.replace(data.get(first), second);
		hashMap.replace(data.get(second), first);
		data.set(first, data.get(second));
		priority.set(first, priority.get(second));
		data.set(second, bufferData);
		priority.set(second, bufferPriority);
	}
	
	private void moveDown(int i) {
		int largerOne=0;
		while(larger(i)!=-1 && c.compare(priority.get(i),priority.get(larger(i)) )<0) {
			largerOne=larger(i);
			swap(i, largerOne);
			i=largerOne;
		}
	}
	
	private void moveUp(int i) {
		while(i>=0 && c.compare(priority.get(i), priority.get(parent(i)))>0) {
			swap(i,parent(i));
			i=parent(i);
		}
	}
	
	private int larger(int i) {
		if(left(i)>=size()&& right(i)>=size())
			return -1;
		if(left(i)>=size())
			return right(i);
		if(right(i)>=size())
			return left(i);
		if(c.compare(priority.get(left(i)), priority.get(right(i)))>=0){
			return left(i);
		}else {
			return right(i);
		}
	}
}
