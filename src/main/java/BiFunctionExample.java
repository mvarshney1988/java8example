

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class BiFunctionExample {
public static void main(String[] args) {
	Map<String,String> m = new TreeMap<>();
	m.put(null, null);
	String[] arrr={"bangalore","pune","new york"};
	Arrays.sort(arrr,new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		
	});
	System.out.println(Arrays.binarySearch(arrr, "new york"));
	PriorityQueue t = new PriorityQueue<>();
	t.add("laundary");
	t.add("bills");
	t.offer("bills");
	System.out.println(t.poll());
	System.out.println(t.peek()+""+t.poll());
}
}
