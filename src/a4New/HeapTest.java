package a4New;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
	    Comparator<Integer> com = new Comparator<Integer>() {

	        @Override
	        public int compare(Integer i1, Integer i2) {
	            if(i1>i2)
	            	return 1;
	            else if(i1==i2)
	            	return 0;
	            else
	            	return -1;
	        }
	    };
		Heap<Integer,Integer> h=new Heap(com);
		h.add(1,1);
		h.add(3, 3);
		h.add(0, 0);
		assertEquals("[Element: 3, Priority: 3; Element: 1, Priority: 1; Element: 0, Priority: 0]"
				,(h.toString()));
		
		assertEquals(3,h.poll());
		assertEquals("[Element: 1, Priority: 1; Element: 0, Priority: 0]",(h.toString()));
		
		h.add(3, 3);
		h.changePriority(3, -1);
		assertEquals("[Element: 1, Priority: 1; Element: 0, Priority: 0; Element: 3, Priority: -1]"
				,(h.toString()));
	}

}
