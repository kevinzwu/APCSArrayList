For this project, we're going to write a special kind of class called a *data structure*. A data structure is a class used to organize data. 

Right now the only data structure we know is an array. The array has one major downside, it has a fixed length. We will build a list which is similar to an array -- it can store multiple elements of the same type, and elements can be read and written using indices. However, we can also insert to the end of the list and into the middle of the list, and the list will automatically grow in size as needed.

The class should be named `APArrayIntList` and it should implement the interface `APIntList`. An interface is like a contract. When a class implements an interface, it promises to implement all the methods in the interface. We will use this promise to write test cases for your class. 

The syntax for implementing an interface is 

`public class <class name> implements <interface name>`

If you add this line to your class, you will notice the class no longer compiles because you are breaking the contract, since you don't implement the methods in the interface. You can add empty methods that do nothing to make the class compile.

The methods in the interface are

`int size()`

Returns the size of the list. For example, if our list is [-4, 27, 4, 8] then `size()` should return 4.

`void add(int item)`

Adds an element to the end of the list. For example, if our list is [3, 5, 7] then `add(-1)` should modify the list to be [3, 5, 7, -1]

`void add(int index, int item)`

Adds an element to the list at the provided index, possibly shifting some elements to higher indices. For example, if our list is [3, 5, 7] then `add(1, -1)` should modify the list to be [3, -1, 5, 7]. Note that -1 is now at index 1 and the elements 5 and 7 have shifted to higher indices. 

The size of the list is a valid value for index. If the list is [3, 5, 7] then `add(3, -1)` should modify the list to be [3, 5, 7, -1].

If `index < 0` or `index > size()`, then the method should throw an `IndexOutOfBoundsException`.

`void set(int index, int item)`

Changes the element of the list at index to be item. For example, if the list is [1, 2, 3] then `set(2, 5)` should modify the list to be [1, 2, 5].

If `index < 0` or `index >= size()`, then the method should throw an `IndexOutOfBoundsException`.

`int get(int index)`

Returns the value in the list at index. For example, if the list is [10, 20, 30] then `get(0)` should return 10 and not modify the list.

If `index < 0` or `index >= size()`, then the method should throw an `IndexOutOfBoundsException`.

That defines the behavior of the class, so next let's talk about the state.

We will use an array to keep track of the data of our list. Note that since an array has a fixed size and the list has a variable size, the size of the underlying array *is not* the same as the number of elements in the array list. You should keep track of these two different concepts -- the underlying array used by our class, and the list it represents. At first, we might initialize an array of length 5, but this will represent an empty list. We will draw this in the following format:

Array: {0, 0, 0, 0, 0}

List: []

If we then call `add(1)`, our representation should look like this:

Array: {1, 0, 0, 0, 0}

List: [1]

`add(2)` will result in

Array: {1, 2, 0, 0, 0}

List: [1, 2]

`add(1, 3)` will result in

Array: {1, 3, 2, 0, 0}

List: [1, 3, 2]

`add(0)` will result in

Array: {1, 3, 2, 0, 0}

List: [1, 3, 2, 0]

At this point you see that the same underlying array could represent two different lists. If we just keep track of the array, we don't know if the 0s in the array are simply default values, or if they actually represent 0s that we inserted into our list. The best way to solve this problem is to have another field to keep track of the size is of the list we are representing. Remember, this is different from the length of the array! In our final example, the underlying array has length 5 and the list has size 4.

Continuing, `add(-1)` will result in

Array: {1, 3, 2, 0, -1}

List: [1, 3, 2, 0, -1]

At this point, our array is full. If we try to add any more items, we will need a bigger array. The class should handle this automatically for us! If we try to use add again, the underlying array should *double* in size to make room for new elements.

So, `add(10)` will result in

Array: {1, 3, 2, 0, -1, 10, 0, 0, 0, 0}

List: [1, 3, 2, 0, -1, 10]

Your class must have a `resize()` method that will perform this functionality, and it must be called from the two add methods appropriately.

Your class must also have a constructor that takes no parameters and initializes the state appropriately.

To use the class, we will build a client class called `APArrayIntListClient` solve a variant of a problem we've already solved -- we will replicate this behavior:

Enter a temperature (or "quit" to stop): 70

Enter a temperature (or "quit" to stop): 80

Enter a temperature (or "quit" to stop): 73

Enter a temperature (or "quit" to stop): 64

Enter a temperature (or "quit" to stop): quit

The average temperature was 71.75.

2 temperatures were above average.

Note that in this problem, we do not ask up front for the number of temperatures we're looking for. Because we do not know the exact number, a list is a good choice for a problem like this because it will handle any amount of entries for us automatically.

Checkpoint (Friday 1/27) Rubric:

1 point: Correct class header which implements the interface.

2 points: Fields that keep track of state, declared appropriately using the correct access specifiers.

2 points: Constructor that initializes the fields

2 points: `int size()` method

2 point: `void add(int item)` method (for < 5 items)

2 points: `int get(int index)` method

4 points: Passes the provided tests.

Final Submission (Friday 2/3) Rubric:

5 points: Follow all style conventions introduced so far. Use good comments explaining what you are doing and why. At the very least, comment every public method to describe its behavior.

1 point: Correct class header which implements the interface.

2 points: Fields that keep track of state, declared appropriately using the correct access specifiers.

2 points: Constructor that initializes the fields.

2 points: `int size()` method

2 points: `void add(int item)` method 

2 points: `void add(int index, int item)` method

2 points: `void set(int index, int item)` method

2 points: `int get(int index)` method

5 points: `resize()` method

5 points: Client class fits specifications

20 points: Passes the provided tests.

Extra credit:

2 points: Look up the Java api with your favorite search engine, read the `java.util.List` documentation and implement `int remove(int index)` and `void clear()` methods appropriately.

3 points: Investigate options for the resize method and answer the below questions.
When you add an element to your list, you are writing to the underlying array (executing a statement that looks like `arr[2] = 5;`) at least once, but you might have to do extra array writes if you need to resize the underlying array. Starting from an array of length 5, and doubling the array on each resize, how many array writes total will happen if you call add 5 times? 10 times? 20 times? 40 times? 100 times? 1000 times? 10000 times? How many array writes happen per add call if you call add 5 times, 10 times, 20 times, 40 times, 100 times, 1000 times, 10000 times?

Suppose now that instead of doubling the array on each resize, you only increased the length of the array by 1. How many array writes total will happen if you call add 5 times? 10 times? 20 times? 40 times? 100 times? 1000 times? 10000 times? How many array writes happen per add call if you call add 5 times, 10 times, 20 times, 40 times, 100 times, 1000 times, 10000 times? 

Suppose now that instead of doubling the array on each resize, you multiply the length by 1.5. How many array writes total will happen if you call add 5 times, 10 times, 20 times, 40 times, 100 times, 1000 times, 10000 times? How many writes happen per add call if you call add 5 times, 10 times, 20 times, 40 times, 100 times, 1000 times, 10000 times?

Compare the performance (as measured by array writes) of doubling, adding 1 element, and multiplying by 1.5. Which is faster, which is slower? How much faster or slower? Can you think of any advantages of using a slower method for resizing?
