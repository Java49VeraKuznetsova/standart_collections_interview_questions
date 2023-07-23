package telran.interviews;

import java.util.*;
import java.util.Map.Entry;

public class MultiCountersImpl implements MultiCounters {
	HashMap<Object, Integer> items = new HashMap<>(); // key - item, counter - counter
	TreeMap<Integer, HashSet<Object>> counters = new TreeMap<>(); // key counter, counter - set of items having the key
																	// -
																	// counter
//consider using the Map method computeIfAbsent	

	@Override
	public Integer addItem(Object item) {
		Integer res = items.merge(item, 1, Integer::sum);
		if (res > 1) {
			counterItemsRemove(res - 1, item);
		}
		counters.computeIfAbsent(res, e -> new HashSet<>()).add(item);
		return res;
	}

	private void counterItemsRemove(int counter, Object item) {
		HashSet<Object> set = counters.get(counter);
		set.remove(item);
		if (set.isEmpty()) {
			counters.remove(counter);
		}
	}

	@Override
	public Integer getValue(Object item) {

		return items.get(item);
	}

	@Override
	public boolean remove(Object item) {
		Integer counter = items.remove(item);
		if (counter != null) {
			counterItemsRemove(counter, item);
		}
		return counter != null;
	}

	@Override
	public Set<Object> getMaxItems() {
		Entry<Integer, HashSet<Object>> maxCounter = counters.lastEntry() ;
		return maxCounter != null ? maxCounter.getValue() : Collections.emptySet();
	}

}