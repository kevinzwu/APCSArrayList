/**
 * Interface for implementation of ArrayList using array.
 * Object oriented assignment for CS 1.
 * 
 * @author zukowskig, Dmitriy Cheryak
 * @version 0.1
 */
public interface APIntList {
	/**
	 * Add item to the end
	 * @param item
	 */
	public void add(int item);
	
	/**
	 * Add item to the specified index, move everything else up
	 * @param index
	 * @param item
	 */
	public void add(int index, int item);
	
	/**
	 * Gets item at specified index
	 * @param index
	 * @return
	 */
	public int get(int index);
	
	/**
	 * Returns number of items
	 * @return
	 */
	public int size();
	
	/**
	 * Replaces item at index with specified item and returns old value
	 * @param index
	 * @param item
	 * @return
	 */
	public int set(int index, int item);
	
	/**
	 * Searches through array to find item
	 * @param item
	 * @return
	 */
	public boolean contains(int item);
	
	/**
	 * Removes item at specified index
	 * @param index
	 * @return
	 */
	public int remove(int index);
	

}
