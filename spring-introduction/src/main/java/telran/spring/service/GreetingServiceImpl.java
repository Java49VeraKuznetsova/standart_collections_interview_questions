package telran.spring.service;
import java.util.*;

@Service
public class GreetingServiceImpl implements GreetingService {

Map<Long, String> greetingsMap = Map.of(123l, "David", 124l, "Sara", 125l, "Rivka");

@Override
public String getGreetings(long id) {
		
		String name =  greetingsMap.getOrDefault(id, "Unknow Guest");
	return "Hello, " + name;
}

}
