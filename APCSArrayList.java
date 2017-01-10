/**
 * Interface for implementation of ArrayList using array.
 * Object oriented assignment for CS 1.
 * 
 * @author zukowskig, Dmitriy Cheryak
 */
public interface APCSArrayList {
	public void add(int item); // Add item to the end
	public void add(int index, int item); // Add item to the specified index, move everything else up
	public int get(int index); // Gets item at specified index
	public int size(); // Returns number of items
	public int set(int index, int item); // Replaces item at index with specified item and returns old value)
	public boolean contains(int item);
	public int remove(int index);
	void resize();
}
