package telran.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class MultiCountersImpl implements MultiCounters {
	private Map <Object,Integer> objects = new HashMap<>();
	private TreeMap <Integer, Set<Object>> counters = new TreeMap<>();
	
	@Override
	public Integer addItem(Object item) {
		// TODO Auto-generated method stub
		Integer nItems = 
				objects.merge(item, 1, (a_prev, b_one)-> a_prev+b_one);
		counters.computeIfAbsent(nItems,
				k -> new HashSet<>()).add(item);
		if(nItems >1) {
			removeFromSet(nItems-1, item);
		}
		
		
		return null;
	}

	private boolean removeFromSet(Integer key, Object item) {
		// TODO Auto-generated method stub
		if (key == null) {
			return false;
		}
		Set<Object> items = counters.get(key);
		items.remove(item);
		if(items.isEmpty() ) {
			counters.remove(key);
		}
		return true;
	}

	@Override
	public Integer getValue(Object item) {
		// TODO Auto-generated method stub
		return objects.get(item);
	}

	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		return removeFromSet(objects.remove(item), item);
	}

	@Override
	public Set<Object> getMaxItems() {
		// TODO Auto-generated method stub
		
		return counters.isEmpty() ? new HashSet<>() :
			counters.get(counters.lastKey());
	}

}
