package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ConnectionsPoolImpl implements ConnectionsPool {

	/*
LinkedHashMap<String, Integer> map;
//TODO
 new LinkedHashMap<>(16, 0.75f, true) {
	protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
		return map.size() > limit;
	}

*/
	private Map<Integer, Connection> map;
	int limit; //limit of connections number in a pool
	public ConnectionsPoolImpl(int limit) {
		if (limit <1) {
			throw new IllegalArgumentException("limit must be > 0");
		}
		//this.limit = limit; this is from Yuri;
		map = new LinkedHashMap<>(16, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Connection> eldest) {
				return size() > limit;
		}
		};
		
		
	}
	@Override
	public boolean addConnection(Connection connection) {
		// TODO Auto-generated method stub
		/* THIS is my
		if (connection == null) {
			throw new NullPointerException("connection is null");
		}
		*/
		// this is from Vladimir
		boolean res = map.put(connection.getId(), connection) == null ? false : true;
		
		Objects.requireNonNull(connection, "null in connection");
		
		return map.put(connection.getId(), connection) == null;
	}

	@Override
	public Connection getConnection(int id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

	

}