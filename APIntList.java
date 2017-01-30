/**
 * Interface for implementation of ArrayList using array.
 * Object oriented assignment for CS 1.
 * 
 * @author zukowskig, Dmitriy Cheryak
 * @version 0.1
 */
public interface APIntList {
	/**
	 * Returns the size of the list
	 */
	int size();
	
	/**
	 * Adds the item to the end of the list
	 * @param item
	 */
	void add(int item);

	/**
	 * Add item to the specified index, move everything else up
	 * @param index
	 * @param item
	 */
	void add(int index, int item);

	/**
	 * Replaces element at index with item
	 * @param index
	 * @param item
	 */
	void set(int index, int item);
	
	/**
	 * Gets item at specified index
	 * @param index
	 * @return
	 */
	int get(int index);
	
	/**
	 * Uncomment me if you're doing extra credit
	 * and replace with appropriate documentation
	 */
	// void clear();
	
	/**
	 * Uncomment me if you're doing extra credit
	 * and replace with appropriate documentation
	 * @param index
	 * @return
	 */
	// int remove(int index);
}
