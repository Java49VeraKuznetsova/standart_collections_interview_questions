package telran.interviews;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * All methods of the class should have complexity O[1]
 * @author User
 *
 * @param <T>
 */
public class MyArray<T> {
	//TODO
	private T value;
	private T[] values;
	public MyArray(int size) {
		//TODO
		values = (T[])(new Object[size]);
	}
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		//TODO
		
		for (int i = 0; i<values.length; i++) {
		this.values[i] = value;
		}
	}
	/**
	 * 
	 * @param index
	 * @return value at given index or null if index is wrong
	 */
	public T get(int index) {
		//TODO
		boolean correctIndex = checkIndex(index);
		
		return correctIndex ? values[index] : null;
	}
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundsException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		//TODO
		boolean correctIndex = checkIndex(index);
		if (correctIndex) {
			values[index] = value;
		}
	}
	
	private boolean checkIndex (int index) {
		boolean correctIndex = false;
		if (index >= values.length || index <0) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		correctIndex = true;
		return correctIndex;
	}
}