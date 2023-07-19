package teltan.interviews;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * 
 * All methods have to have the Complexity O[1]
 */
public class StackInt {
	// fields
	private LinkedList<Integer> stackList = new LinkedList<>();
	private LinkedList<Integer> maxList = new LinkedList<>();
	
	/**
	 * 
	 * 
	 * @param num
	 * adds num in this stack
	 */
	public void push(int num) {
		//TODO
	
		stackList.add(num);
		
		if(maxList.isEmpty() || maxList.getLast() <= num) {
			maxList.add(num);
		}
	}
	/**
	 * 
	 * @return
	 * takes out and returns the top  stack number
	 * in the case the stack is empty the exception of the class
	 * NoSuchElement should be throw
	 * 
	 */
	
	public int pop() {
		//
		if (stackList.isEmpty()) {
			throw new NoSuchElementException();
		}
		int top = stackList.removeLast();
		if (top == maxList.getLast()) {
			maxList.removeLast();
		}
		return top;
	}
	/**
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty() {
		//
		
		return stackList.isEmpty();
	}
	/**
	 * 
	 * @return maximal value existing in the stack
	 * throws NoSuchElementException in the case the stack is empty
	 */
	public int max() {
		//TODO
		if (maxList.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		return maxList.getLast();
	}

}
