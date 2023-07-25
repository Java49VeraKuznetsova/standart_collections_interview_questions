package telran.util.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static telran.interviews.StreamTasks.*;
class StreamTasksTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Disabled
	@Test
	void displayOccurencesTest() {
		String [] strings = {"lmn", "ab", "lmn", "c", "ab", "a", "lmn", "aaa"};
		displayOccurences(strings);
		}
	@Disabled	
	@Test
	void displayOddEvenGroupingTest() {
		displayOddEvenGrouping(20);
	}
	@Test
	void displayOccurancesFiguresTest() {
		//displayOccurancesFigures(5);
		displayOccurancesFigures(1_000_000);
	}
	}


