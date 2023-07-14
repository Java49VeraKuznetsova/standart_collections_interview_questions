package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teltan.interviews.StackInt;

class StackTests {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		
	}

	@Test
	void isEmptyTest() {
		StackInt stack1 = new StackInt();
		assertTrue(stack1.isEmpty());
		stack1.push(5);
		assertFalse(stack1.isEmpty());
	}
	@Test
	void pop_push_Test() {
		StackInt stack1 = new StackInt();
		assertThrowsExactly(NoSuchElementException.class,
				() -> stack1.pop());
		stack1.push(5);
		stack1.push(6);
		assertEquals (6, stack1.pop());
		assertEquals (5, stack1.pop());
		assertTrue(stack1.isEmpty());
	}
	@Test
	void maxTest() {
		StackInt stack1 = new StackInt();
		assertThrowsExactly(NoSuchElementException.class,
				() -> stack1.max());
		stack1.push(5);
		stack1.push(6);
		stack1.push(5);
		stack1.push(7);
		assertEquals (7, stack1.max());
		assertEquals (7, stack1.pop());
		
		stack1.pop();
		
		stack1.push(3);
		assertEquals (6, stack1.max());
		
		
		
	}
}
