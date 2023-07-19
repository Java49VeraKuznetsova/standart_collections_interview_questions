package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapTests {
	final static int MAX_SIZE = 4;
Integer[] values = {100,  5, 8, 7,  10};
String[] keys = {"t", "a", "b", "c", "d"};
LinkedHashMap<String, Integer> map;
	@BeforeEach
	void setUp() throws Exception {
		map = new LinkedHashMap<>(16, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<String, Integer> eldext ) {
				return size() > MAX_SIZE;
			}
		};
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
		}
	}
@Test
void linkedHashMapTest() {
	String[] expected = { "a", "b", "c", "d"};
	assertArrayEquals(expected, map.keySet().toArray(String[]::new));
	assertEquals(5, map.get("a"));
	map.put("t", 100);
	map.get("c");
System.out.println(map.keySet());
	//assertArrayEquals(values, map.values().toArray(Integer[]::new));
	//assertArrayEquals(keys, map.keySet().toArray(String[]::new));
}
	@Test
	void displayOccurencesTest() {
		displayOccurences(new String[] {
				"lmn", "ab", "lmn", "a", "cd", "lmn", "cd"
		});
		//lmn -> 3
		//cd -> 2
		//a -> 1
		//ab -> 1
		
	}

	private void displayOccurences(String[] strings) {
		HashMap<String, Integer> mapOccurences = getMap(strings);
		ArrayList<Map.Entry<String, Integer>> list = 
				new ArrayList<>(mapOccurences.entrySet());
		list.sort((e1, e2) -> {
			int res = Integer.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
		});
		list.stream().forEach(e -> System.out.printf("%s -> %d\n", 
				e.getKey(), e.getValue()));
	}

	private HashMap<String, Integer> getMap(String[] strings) {
		HashMap<String, Integer> res = new HashMap<>();
		for(String str: strings) {
			res.merge(str,  1,  (a,b) -> a+b);
		}
		return res;
	}

}
