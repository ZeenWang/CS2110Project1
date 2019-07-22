package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

class HeapTest {
	
	public class myC implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1==o2)
				return 0;
			return o1>o2?1:-1;
		}
	}
	
	@Test
	void test() {
		//test for Constructor.
		Heap<String, Integer> testHeap= new Heap<String, Integer>(new myC());
		testHeap.add("Hello", 10);
		testHeap.add("Hello1", 2);
		testHeap.add("Hello2", 4);
		testHeap.add("Hello11", 22);
		testHeap.add("Hello12", 233);
		testHeap.add("Hello13", 221);
		testHeap.add("Hello41", 3);
		testHeap.add("Hello3", 74);
		System.out.println(testHeap.peek());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		System.out.println(testHeap.poll());
		
	}

}
