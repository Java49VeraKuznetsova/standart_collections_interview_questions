package telran.interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
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
	   new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
	   .boxed()
	   .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd",
			   Collectors.summingLong(x -> x)))
	   .forEach((k, v) -> System.out.printf("%s -> %d\n", k, v));
   }
   static public void displayOccurancesFigures (int nNumbers) {
	   new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
	   .boxed()
	   .flatMap(num -> getArraysFig(num).stream())
	   .collect(Collectors.groupingBy(d -> d,
			   Collectors.counting()))
	   .entrySet()
	   .stream()
	   .sorted((e1, e2) -> 
		   Long.compare(e2.getValue(), e1.getValue()))
	   .forEach(e -> System.out.printf("%d: %d\n", e.getKey(), e.getValue()));
	 
   }
   
  static public void displayDigitStatistics() {
	  int nNumbers = 1_000_000;
	  new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
	  .flatMap(num -> Integer.toString(num).chars())
	  .boxed()
	  .collect(Collectors.groupingBy(d -> d,
			  Collectors.counting()))
	  .entrySet()
	  .stream()
	  .sorted((e1, e2) -> 
	    Long.compare(e2.getValue(), e1.getValue()))
	  .forEach(e -> System.out.printf("%c: %d\n",e.getKey(), e.getValue()));
  }
  
  static public void displayDigitStatistics2() {
	  int nNumbers = 1_000_000;
	  new Random().ints(nNumbers, 0, Integer.MAX_VALUE)
	  .mapToObj(Integer::toString)
	  .flatMap (s -> Arrays.stream(s.split("")))
	  .collect(Collectors.groupingBy(s -> s,
			  Collectors.counting()))
	  .entrySet()
	  .stream()
	  .sorted((e1, e2) -> 
	    Long.compare(e2.getValue(), e1.getValue()))
	  .forEach(e -> System.out.printf("%s: %d\n",e.getKey(), e.getValue()));
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
   /*
   class Person {
		public Person(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Integer id;
		public String name;
	}
	*/
   record Person(int id, String name) {}
   
   public static Map<Integer, Person> getRandomPersonMap(int nPersons) {
	   return new Random().ints(1000, 2001)
			   .distinct()
			   .limit(nPersons)
			   .mapToObj (id -> new Person(id, "name" + id))
			  .collect(Collectors.toMap(p->p.id(), p -> p, 
					  (p, u) -> p, TreeMap::new));
   }
}


