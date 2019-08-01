package a4New;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.NoSuchElementException;


public class Heap<E,P> implements PriorityQueue<E,P> {

	private Comparator<? super P> c;
	int size;
	ArrayList<E> list;
	HashMap<E, P> map;
	
	/**
	 * constructor, build a empty heap
	 * @param com the comparator of the heap
	 */
	public Heap(Comparator<? super P> com)
	{
		this.c=com;
		size=0;
		list=new ArrayList<E>();
		map=new HashMap<E,P>();
	}
	
	@Override
	public Comparator<? super P> comparator() {
		return c;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E poll() throws NoSuchElementException {
		if(size==0)
			throw new NoSuchElementException();
		int x=0;
		int i;
		while(hasChildren(x))
		{
			i=findBiggestChildren(x);
			swap(x,i);
			x=i;
		}
		swap(x,size-1);
		moveUp(x);
		map.remove(list.get(size-1));
		E e=list.remove(size-1);
		size--;
		return e;
		
	}

	@Override
	public E peek() throws NoSuchElementException {
		if(size==0)
			throw new NoSuchElementException();
		return list.get(0);
	}

	@Override
	public void add(E e, P p) throws IllegalArgumentException {
		if(map.containsKey(e))
				throw new IllegalArgumentException();
		
		list.add(e);
		size++;
		map.put(e, p);
		moveUp(size-1);
		
	}

	@Override
	public void changePriority(E e, P p) throws NoSuchElementException {
		for(int i=0;i<size;i++)
		{
			if(list.get(i).equals(e))
			{
				P prog=map.get(e);
				map.replace(e, p);
				if(c.compare(prog, p)>0)
				{
					moveDown(i);
					return;
				}
				else
				{
					moveUp(i);
					return;
				}
			}
		}
		
		throw new NoSuchElementException();
	}
	//////////////////Method I added for project5////////
	public boolean contain(E e){
		for(int i=0;i<size;i++) {
			if(list.get(i).equals(e))
				return true;
		}
		return false;
	}
	
	public P getPriority(E e){
		return map.get(e);
	}
	//////////////Methods down below are all additional methods that might be useful/////////////
	
	/**
	 * merge two heaps together
	 * @param h the another heap to merge
	 */
	public void merge(Heap<E,P> h)
	{
		for(int i=0;i<h.size();i++)
		{
			add(h.get(i),h.getPriority(i));
		}
		
		this.size+=h.size();
	}
	
	/**
	 * 
	 * change the element of priority p to e
	 * 
	 * @throws NoSuchElementException
	 */
	public void changeElement(P p,E e) throws NoSuchElementException
	{
		for(int i=0;i<size;i++)
		{
			if(getPriority(i).equals(p))
			{
				list.remove(i);
				list.add(i,e);
				return;
			}
		}
		
		throw new NoSuchElementException();
	}
	
	/**
	 * return in form of "[Element: e1, Priority: p1; Element: e2, Priority: p2...]"
	 */
	public String toString()
	{
		String s="[";
		for(int i=0;i<size;i++)
		{
			s+="Element: "+get(i)+", Priority: "+getPriority(i);
			if(i!=size-1)
				s+="; ";
		}
		s+="]";
		return s;
	}

	//////////////////// Methods below are all helper methods/////////////////////
	
	
	/**
	 *this is a helper method
	 * @param i the index of a element
	 * @return the index of the bigger children of a element
	 * return the right children if two are equal
	 */
	private int findBiggestChildren(int i)
	{
		if(size-1==i*2+1)
			return i*2+1;
		if(c.compare(map.get(list.get(i*2+1)) , map.get(list.get(i*2+2)))>0)
			return i*2+1;
		else
			return i*2+2;
	}
	
	/**
	 * swap two element in the arraylist
	 * 
	 * @param a the index of a swaping element
	 * @param b the index of another swaping element
	 * 
	 */
	private void swap(int a, int b)
	{
		E ea=list.get(a);
		E eb=list.get(b);
		list.remove(a);
		list.add(a,eb);
		list.remove(b);
		list.add(b, ea);
	}
	
	/**
	 * 
	 * @param i the index to be checked
	 * @return true if i has at least one child, false otherwise
	 */
	private boolean hasChildren(int i)
	{
		return (list.size()-1>=i*2+1);
	}
	
	/**
	 * 
	 * @param i the index to be checked
	 * @return true if element of i is bigger than its parent
	 */
	private boolean isBiggerThanParent(int i)
	{
		if(i==0)
			return false;
		return c.compare(map.get(list.get(i)),map.get(list.get((i-1)/2)))>0;
	}
	
	/**
	 * 
	 * @param i the index to be moved
	 * 
	 * move the element of i up until it reach a right place (which its parent is bigger than it)
	 */
	private void moveUp(int i)
	{
		while(i>0&&isBiggerThanParent(i))
		{
			swap(i,(i-1)/2);
			i=(i-1/2);
		}
	}
	
	private void moveDown(int i)
	{
		while(hasChildren(i) && c.compare(map.get(list.get(findBiggestChildren(i))),map.get(list.get(i)))>0)
		 {
			int temp=findBiggestChildren(i);
			swap(i,temp);
			i=temp;
		 }
	}
	
	public E get(int i)
	{
		return list.get(i);
	}
	
	public P getPriority(int i)
	{
		return map.get(get(i));
	}
}