package telran.interviews;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * All methods have to have the Complexity O[1]
 *
 */
public class StackInt {
	private LinkedList<Integer> numbers = new LinkedList<>();
	private LinkedList<Integer> maxNumbers = new LinkedList<>();
	/**
	 * 
	 * @param num
	 * adds num in the stack
	 */
	public void push(int num) {
		numbers.add(num);
		if (maxNumbers.isEmpty() || num >= maxNumbers.getLast()) {
			maxNumbers.add(num);
		}
	}
	/**
	 * 
	 * @return
	 * takes out and returns the top stack number
	 * in the case the stack is empty the exception of the class NoSuchElement should be thrown
	 */
	public int pop() {
		
		int res = numbers.removeLast();
		if (res == maxNumbers.getLast()) {
			maxNumbers.removeLast();
		}
		return res;
	}
	/**
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		return numbers.isEmpty();
	}
	/**
	 * 
	 * @return maximal value existing in the stack
	 * throws NoSuchElementException in the case the stack is empty
	 */
	public int max() {
		
		return maxNumbers.getLast();
	}
}
