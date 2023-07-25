package telran.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTasks {
	static public void displayOccurences(String strings[]) {
		Arrays.stream(strings)
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet().stream().sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res != 0 ? res : e1.getKey().compareTo(e2.getKey());
		})
		.forEach(e  -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
		
	}
   static public long sumGroups(int [][] groups) {
	  return Arrays.stream(groups)
			  .flatMapToInt(g -> Arrays.stream(g))
			  .asLongStream()
			  .sum();
   }
   static public void displayOddEvenGrouping(int nNumbers) {
	   new Random().ints(nNumbers, 0, Integer.MAX_VALUE).boxed()
	   .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd",
			   Collectors.summingLong(x -> x)))
	   .forEach((k, v) -> System.out.printf("%s -> %d\n", k, v));
   }
   static public void displayOccurancesFigures (int nNumbers) {
	   new Random().ints(nNumbers, 0, Integer.MAX_VALUE).boxed()
	   .flatMap(num -> getArraysFig(num).stream())
	   .collect(Collectors.groupingBy(d -> d,
			   Collectors.counting()))
	  	   .forEach((k, v) -> System.out.printf("%d: %d\n", k, v));
	
	 
   }
   
   static private List<Integer> getArraysFig(int num) {
	   int temp=num;
	   List<Integer> digits = new ArrayList<>();
	   while(temp>0) {
		   digits.add(temp % 10);
		   temp /= 10;
	   }
	   return digits;
   }
}
