import java.util.*;

/**
 *
 * Tester code for APArrayIntList.
 * This code will run as long as there is a APArrayIntList
 * class defined in the same folder as this file.
 * 
 * You should NOT need to modify this code 
 * 
*/
public class APArrayIntListTester
{
    public static final int TOTAL_TESTS = 4;
    public static final double TOTAL_TEST_POINTS = 4;
    public static final int PSEUDO_RANDOM_SEED = 0x5f3759df;
    
    public static int pseudoRandomNumber = PSEUDO_RANDOM_SEED;
    
    public static void main (String[] args)
    {
        double successfulTestPoints = 0;
        
        successfulTestPoints += initializeTest();
        successfulTestPoints += singleAddTest();
        successfulTestPoints += basicAddTest();
        /*successfulTestPoints += largeAddTest();
        successfulTestPoints += singleIndexedAddTest();
        successfulTestPoints += basicIndexedAddTest();
        successfulTestPoints += largeIndexedAddTest();
        successfulTestPoints += singleAddAndSetTest();
        successfulTestPoints += basicAddAndSetTest();
        successfulTestPoints += largeAddAndSetTest();
        successfulTestPoints += largeMixedTest();
        successfulTestPoints += indexedAddErrorCasesTest();
        successfulTestPoints += getErrorCasesTest();
        successfulTestPoints += setErrorCasesTest();*/
        successfulTestPoints += singleAddMultipleArrayListTest();
        /*successfulTestPoints += basicAddMultipleArrayListTest();
        successfulTestPoints += largeAddMultipleArrayListTest();
        successfulTestPoints += reverseListTest();
        successfulTestPoints += sieveOfEratosthenesTest();
        successfulTestPoints += quickSortTest();
        */
        double percentage = successfulTestPoints / TOTAL_TEST_POINTS * 100;
        System.out.println(String.format("%.2f", successfulTestPoints) + " / " + String.format("%.2f", TOTAL_TEST_POINTS) + " = " + String.format("%.2f", percentage) + "%");
    }

    /**
    * Tests the constructor
    * @return the amount of points earned for the test
    */
    public static double initializeTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START initializeTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        System.out.println("------------------------ END initializeTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests calling add(int item) method once
    * @return the amount of points earned for the test
    */
    public static double singleAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START singleAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);
        
        System.out.println("Calling list.add(-1) ");
        list.add(-1);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, -1);
        
        System.out.println("------------------------ END singleAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
 
    /**
    * Tests the basic functionality of add(int item) method
    * @return the amount of points earned for the test
    */
    public static double basicAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START basicAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(5) ");
        list.add(5);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 5);
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 1, 2);
        
        System.out.println("Calling list.add(5)");
        list.add(5);
        testPass &= verifyListSize(list, 3);
        testPass &= verifyValueAtIndex(list, 2, 5);
        
        System.out.println("------------------------ END basicAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the functionality of add(int item) method with a lot of values
    * @return the amount of points earned for the test
    */
    public static double largeAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START largeAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        int size = 0;
        for(int index = 0; index < 1000; index++) 
        {
            int value = getPseudoRandomInt();
            System.out.println("Calling list.add(" + value + ")");
            list.add(value);
            testPass &= verifyListSize(list, ++size);
            testPass &= verifyValueAtIndex(list, index, value);
        }
        
        System.out.println("------------------------ END largeAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests calling add(int index, int item) method once
    * @return the amount of points earned for the test
    */
    public static double singleIndexedAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START singleIndexedAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);
        
        System.out.println("Calling list.add(0, 42) ");
        list.add(0, 42);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 42);
        
        System.out.println("------------------------ END singleIndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the basic functionality of add(int index, int item) method
    * @return the amount of points earned for the test
    */
    public static double basicIndexedAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START basicIndexedAddTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(0, 2)");
        list.add(0, 2);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.add(1, 4) ");
        list.add(1, 4);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, 2);
        testPass &= verifyValueAtIndex(list, 1, 4);
        
        System.out.println("Calling list.add(0, 10)");
        list.add(0, 10);
        testPass &= verifyListSize(list, 3);
        testPass &= verifyValueAtIndex(list, 0, 10);
        testPass &= verifyValueAtIndex(list, 1, 2);
        testPass &= verifyValueAtIndex(list, 2, 4);    
        
        System.out.println("Calling list.add(1, 12)");
        list.add(1, 12);
        testPass &= verifyListSize(list, 4);
        testPass &= verifyValueAtIndex(list, 0, 10);
        testPass &= verifyValueAtIndex(list, 1, 12);
        testPass &= verifyValueAtIndex(list, 2, 2);
        testPass &= verifyValueAtIndex(list, 3, 4);
        
        System.out.println("------------------------ END basicIndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the functionality of add(int index, int item) method with a lot of values
    * @return the amount of points earned for the test
    */
    public static double largeIndexedAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START largeIndexedAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        
        int size = 0;
        for(int i = 0; i < 1000; i++) 
        {
            int value = getPseudoRandomInt();
            // size is a valid index to add to, so convert to range from 0 to < size + 1
            int index = convertToIntInRange(getPseudoRandomInt(), javaList.size() + 1);
            System.out.println("Calling list.add(" + index + "," + value + ")");
            list.add(index, value);
            javaList.add(index, value);
            testPass &= verifyListsMatch(list, javaList);
        }
        
        System.out.println("------------------------ END largeIndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests the functionality of set(int index, int item) method by calling it once
    * @return the amount of points earned for the test
    */
    public static double singleAddAndSetTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START singleAddAndSetTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);
        
        System.out.println("Calling list.add(1337) ");
        list.add(1337);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 1337);
        
        System.out.println("Calling list.set(0, 1234) ");
        list.set(0, 1234);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 1234);
        
        System.out.println("------------------------ END singleAddAndSetTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the basic functionality of set(int index, int item) method
    * @return the amount of points earned for the test
    */
    public static double basicAddAndSetTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START basicAddAndSetTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);
        
        System.out.println("Calling list.add(4) ");
        list.add(4);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 4);
        
        System.out.println("Calling list.add(6) ");
        list.add(6);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 1, 6);
        
        System.out.println("Calling list.set(0, 5) ");
        list.set(0, 5);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, 5);
        testPass &= verifyValueAtIndex(list, 1, 6);
        
        System.out.println("Calling list.set(0, 5) ");
        list.set(0, 5);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, 5);
        testPass &= verifyValueAtIndex(list, 1, 6);
        
        System.out.println("Calling list.set(1, 2) ");
        list.set(1, 2);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, 5);
        testPass &= verifyValueAtIndex(list, 1, 2);
        
        System.out.println("Calling list.add(1) ");
        list.add(1);
        testPass &= verifyListSize(list, 3);
        testPass &= verifyValueAtIndex(list, 0, 5);
        testPass &= verifyValueAtIndex(list, 1, 2);
        testPass &= verifyValueAtIndex(list, 2, 1);
        
        System.out.println("Calling list.set(2, -3) ");
        list.set(2, -3);
        testPass &= verifyListSize(list, 3);
        testPass &= verifyValueAtIndex(list, 0, 5);
        testPass &= verifyValueAtIndex(list, 1, 2);
        testPass &= verifyValueAtIndex(list, 2, -3);
        
        System.out.println("------------------------ END basicAddAndSetTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the functionality of set(int index, int item) method with a lot of values
    * @return the amount of points earned for the test
    */
    public static double largeAddAndSetTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START largeAddAndSetTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        
        int size = 0;
        for(int i = 0; i < 1000; i++) 
        {
            int value = getPseudoRandomInt();
            // size is a valid index to add to, so convert to range from 0 to < size + 1
            int index = convertToIntInRange(getPseudoRandomInt(), javaList.size() + 1);
            System.out.println("Calling list.add(" + index + "," + value + ")");
            list.add(index, value);
            javaList.add(index, value);
            testPass &= verifyListsMatch(list, javaList);
            
            value = getPseudoRandomInt();
            index = convertToIntInRange(getPseudoRandomInt(), javaList.size());
            System.out.println("Calling list.set(" + index + "," + value + ")");
            list.set(index, value);
            javaList.set(index, value);
            testPass &= verifyListsMatch(list, javaList);
        }
        
        System.out.println("------------------------ END largeAddAndSetTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the functionality of add(int item, add(int index, int item), and set(int index, int item) methods with a lot of values
    * @return the amount of points earned for the test
    */
    public static double largeMixedTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START largeAddAndSetTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        
        int size = 0;
        for(int i = 0; i < 1000; i++) 
        {
            int value = getPseudoRandomInt();
            // size is a valid index to add to, so convert to range from 0 to < size + 1
            int index = convertToIntInRange(getPseudoRandomInt(), javaList.size() + 1);
            if (convertToIntInRange(getPseudoRandomInt(), 2) == 0)
            {
                System.out.println("Calling list.add(" + index + "," + value + ")");
                list.add(index, value);
                javaList.add(index, value);
                testPass &= verifyListsMatch(list, javaList);
            }
            else
            {
                System.out.println("Calling list.add(" + value + ")");
                list.add(value);
                javaList.add(value);
                testPass &= verifyListsMatch(list, javaList);
            }
            
            value = getPseudoRandomInt();
            index = convertToIntInRange(getPseudoRandomInt(), javaList.size());
            System.out.println("Calling list.set(" + index + "," + value + ")");
            list.set(index, value);
            javaList.set(index, value);
            testPass &= verifyListsMatch(list, javaList);
        }
        
        System.out.println("------------------------ END largeAddAndSetTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    

    /**
    * Tests the error functionality of add(int index, int item)
    * @return the amount of points earned for the test
    */
    public static double indexedAddErrorCasesTest()
    {
        boolean testPass = true;
        String method = "list.add(item, index)";
        
        System.out.println("------------------------ START indexedAddErrorCasesTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.add(-1, 4) ");
        try 
        {
            list.add(-1, 4);
            testPass &= verifyExceptionThrown(false, method, "index < 0");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index < 0");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.add(2, 10)");
        try 
        {
            list.add(2, 10);
            testPass &= verifyExceptionThrown(false, method, "index > size()");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index > size()");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("------------------------ END indexedAddErrorCasesTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests the error functionality of get(int index) method
    * @return the amount of points earned for the test
    */
    public static double getErrorCasesTest()
    {
        boolean testPass = true;
        String method = "get(int index)";
        
        System.out.println("------------------------ START getErrorCasesTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.get(-1) ");
        try 
        {
            list.get(-1);
            testPass &= verifyExceptionThrown(false, method, "index < 0");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index < 0");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.get(1)");
        try 
        {
            list.get(1);
            testPass &= verifyExceptionThrown(false, method, "index == size()");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index == size()");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.get(100)");
        try 
        {
            list.get(100);
            testPass &= verifyExceptionThrown(false, method, "index > size()");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index > size()");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("------------------------ END getErrorCasesTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests the error functionality of set(int index, int item) method
    * @return the amount of points earned for the test
    */
    public static double setErrorCasesTest()
    {
        boolean testPass = true;
        String method = "set(int index, int item)";
        
        System.out.println("------------------------ START setErrorCasesTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.set(-1, 0) ");
        try 
        {
            list.set(-1, 0);
            testPass &= verifyExceptionThrown(false, method, "index < 0");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index < 0");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.set(1, 0)");
        try 
        {
            list.set(1, 0);
            testPass &= verifyExceptionThrown(false, method, "index == size()");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index == size()");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.set(100, 0)");
        try 
        {
            list.set(100, 0);
            testPass &= verifyExceptionThrown(false, method, "index > size()");
        }
        catch(IndexOutOfBoundsException e) {
            testPass &= verifyExceptionThrown(true, method, "index > size()");
            testPass &= verifyListSize(list, 1);
            testPass &= verifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("------------------------ END setErrorCasesTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests calling add(int item) method once on two different array lists
    * @return the amount of points earned for the test
    */
    public static double singleAddMultipleArrayListTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START singleAddMultipleArrayListTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);

        System.out.println("Creating new APArrayIntList");
        APIntList list2 = new APArrayIntList();
        testPass &= verifyListSize(list2, 0);
        
        System.out.println("Calling list.add(-1) ");
        list.add(-1);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyListSize(list2, 0);

        System.out.println("Calling list2.add(1) ");
        list2.add(1);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyListSize(list2, 1);
        testPass &= verifyValueAtIndex(list2, 0, 1);
        
        System.out.println("------------------------ END singleAddMultipleArrayListTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
 
    /**
    * Tests the basic functionality of add(int item) method on two different array lists
    * @return the amount of points earned for the test
    */
    public static double basicAddMultipleArrayListTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START basicAddMultipleArrayListTest() ------------------------");

        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0);

        System.out.println("Creating new APArrayIntList");
        APIntList list2 = new APArrayIntList();
        testPass &= verifyListSize(list2, 0);
        
        System.out.println("Calling list.add(-1) ");
        list.add(-1);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyListSize(list2, 0);

        System.out.println("Calling list2.add(1) ");
        list2.add(1);
        testPass &= verifyListSize(list, 1);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyListSize(list2, 1);
        testPass &= verifyValueAtIndex(list2, 0, 1);

        System.out.println("Calling list.add(-1) ");
        list.add(-1);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyValueAtIndex(list, 1, -1);
        testPass &= verifyListSize(list2, 1);
        testPass &= verifyValueAtIndex(list2, 0, 1);

        System.out.println("Calling list2.add(2) ");
        list2.add(2);
        testPass &= verifyListSize(list, 2);
        testPass &= verifyValueAtIndex(list, 0, -1);
        testPass &= verifyValueAtIndex(list, 1, -1);
        testPass &= verifyListSize(list2, 2);
        testPass &= verifyValueAtIndex(list2, 0, 1);
        testPass &= verifyValueAtIndex(list2, 1, 2);
        
        System.out.println("------------------------ END basicAddMultipleArrayListTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    /**
    * Tests the functionality of add(int item) method with a lot of values on two different array lists
    * @return the amount of points earned for the test
    */
    public static double largeAddMultipleArrayListTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START largeAddMultipleArrayListTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 

        System.out.println("Creating new APArrayIntList");
        APIntList list2 = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 

        ArrayList<Integer> javaList = new ArrayList<Integer>();
        ArrayList<Integer> javaList2 = new ArrayList<Integer>();
        
        for(int index = 0; index < 2000; index++) 
        {
            int value = getPseudoRandomInt();

            if (convertToIntInRange(value, 2) == 0)
            {
                System.out.println("Calling list.add(" + value + ")");
                list.add(value);
                javaList.add(value);
                testPass &= verifyListsMatch(list, javaList);
                testPass &= verifyListsMatch(list2, javaList2);
            }
            else
            {
                System.out.println("Calling list2.add(" + value + ")");
                list2.add(value);
                javaList2.add(value);
                testPass &= verifyListsMatch(list, javaList);
                testPass &= verifyListsMatch(list2, javaList2);
            }
        }
        
        System.out.println("------------------------ END largeAddMultipleArrayListTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests by implementing reversing a list
    * @return the amount of points earned for the test
    */
    public static double reverseListTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START reverseListTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        ArrayList<Integer> javaList = new ArrayList<Integer>();

        for (int i = 0; i < 256; i++)
        {
            int value = getPseudoRandomInt();
            list.add(value);
            javaList.add(value);
        }

        Collections.reverse(javaList);

        for (int i = 0; i < list.size() / 2; i++)
        {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }

        testPass &= verifyListsMatch(list, javaList);

        System.out.println("------------------------ END reverseListTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests by implementing Sieve of Eratosthenes
    * @return the amount of points earned for the test
    */
    public static double sieveOfEratosthenesTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START sieveOfEratosthenesTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        for (int i = 0; i < 50; i++)
        {
            list.add(i);
        }
        
        list.set(1, 0);
        
        for (int i = 2; i < list.size(); i++)
        {
            if (list.get(i) != 0)
            {
                for (int num = i + i; num < list.size(); num += i)
                {
                    list.set(num, 0);
                }
            }
        }
        
        String actualPrimesList = "";
        
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) != 0)
            {
                if (actualPrimesList.length() == 0)
                {
                    actualPrimesList += list.get(i);
                }
                else
                {
                    actualPrimesList += ", " + list.get(i);
                }
            }
        }
        
        String expectedPrimesList = "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47";
        boolean result = actualPrimesList.equals(expectedPrimesList);
        System.out.println(getPassFailFromBool(result) + "     Verify primes list [Expected  " + expectedPrimesList + ", Actual " + actualPrimesList);
        testPass &= result;
        
        System.out.println("------------------------ END sieveOfEratosthenesTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }

    /**
    * Tests by implementing quick sort
    * @return the amount of points earned for the test
    */
    public static double quickSortTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START quickSortTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        ArrayList<Integer> javaList = new ArrayList<Integer>();

        for (int i = 0; i < 1024; i++)
        {
            int value = getPseudoRandomInt();
            list.add(value);
            javaList.add(value);
        }
        
        Collections.sort(javaList);
        quickSort(list);
        
        testPass &= verifyListsMatch(list, javaList);
        
        System.out.println("------------------------ END quickSortTest() ------------------------");
        System.out.println();
        System.out.println();
        
        return getPoints(testPass);
    }
    
    private static void quickSort(APIntList list)
    {
        quickSortHelper(list, 0, list.size() - 1);
    }
    
    private static void quickSortHelper(APIntList list, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        
        int pivot = list.get(start);
        int leftIndex = start;
        int rightIndex = end;
        int pivotIndex = start;
        
        while (leftIndex < rightIndex)
        {
            if (pivotIndex == rightIndex)
            {
                int value = list.get(leftIndex);
                if (value > pivot)
                {
                    list.set(pivotIndex, value);
                    list.set(leftIndex, pivot);
                    pivotIndex = leftIndex;
                    rightIndex--;
                }
                else
                {
                    leftIndex++;
                }
            }
            else
            {
                int value = list.get(rightIndex);
                if (value < pivot)
                {
                    list.set(pivotIndex, value);
                    list.set(rightIndex, pivot);
                    pivotIndex = rightIndex;
                    leftIndex++;
                }
                else
                {
                    rightIndex--;
                }
            }
        }
        
        quickSortHelper(list, start, leftIndex - 1);
        quickSortHelper(list, leftIndex + 1, end);
    }

    /**
     * Verifies whether or not the AP list matches the Java list
     * @param list the APIntList
     * @param javaList the Java list
     * @return whether the verification was successful
     */
    private static boolean verifyListsMatch(APIntList list, ArrayList<Integer> javaList)
    {
        int actualSize = list.size();
        int expectedSize = javaList.size();
        if (actualSize != expectedSize)
        {
            System.out.println(getPassFailFromBool(false) + "     Verify list.size() [Expected  " + expectedSize + ", Actual " + actualSize);
            return false;
        }
        
        for (int index = 0; index < actualSize; index++) 
        {
            int actualItem = list.get(index);
            int expectedItem = javaList.get(index);
            boolean result = actualItem == expectedItem;
            if (!result)
            {
                System.out.println(getPassFailFromBool(result) + "     Verify list.get(int index) [Expected at index " + index + ": " + expectedItem + ", Actual at index " + index + ": " + actualItem + "]");
                return result;
            }
        }

        System.out.println(getPassFailFromBool(true) + "     Verify lists match");
        return true;
    }
    
    /**
     * Verifies whether or not the proper exception was thrown
     * @param exceptionThrown determines whether an exception was thrown
     * @param method the method called
     * @param condition the condition that should raise exception
     * @return whether the verification was successful
     */
    private static boolean verifyExceptionThrown(boolean exceptionThrown, String method, String condition)
    {
        System.out.println(getPassFailFromBool(exceptionThrown) + "    Verify that " + method + " when " + condition + " throws IndexOutOfBoundsException");
        return exceptionThrown;
    }
    
    /**
    * Verifies whether the value at the specified index in the list is the expected value.
    * @param list the list to verify value at
    * @param index the index to verify value at
    * @param expectedItem the expected value at index in list
    * @return whether the verification was successful
    */
    private static boolean verifyValueAtIndex(APIntList list, int index, int expectedItem)
    {
        int actualItem = list.get(index);
        boolean result = actualItem == expectedItem;
        System.out.println(getPassFailFromBool(result) + "     Verify list.get(int index) [Expected at index " + index + ": " + expectedItem + ", Actual at index " + index + ": " + actualItem + "]");
        return result;
    }

    /**
    * Verifies whether the list is the expected size
    * @param list the list to verify the size of
    * @param expectedSize the expected size of the list
    * @return whether the verification was successful
    */
    private static boolean verifyListSize(APIntList list, int expectedSize)
    {
        int actualSize = list.size();
        boolean result = actualSize == expectedSize;
        System.out.println(getPassFailFromBool(result) + "     Verify list.size() [Expected: " + expectedSize + ", Actual " + actualSize + "]");
        return result;
    }
    
    /**
    * Helper method to print "   PASS   " or "***FAIL***" based on a boolean value
    * Asterisks used to help student spot failing tests better.
    * @param pass whether or not the test passed
    * @return "   PASS   " or "***FAIL***" based on pass
    */
    private static String getPassFailFromBool(boolean pass)
    {
        if (pass)
        {
            return "   PASS   ";
        }
        return "***FAIL***";
    }
    
    /**
    * Converts whether a test was successful to points
    * @param pass whether or not the test passed
    * @return the default amount of points if a test passed or 0 if it failed
    */
    private static double getPoints(boolean pass)
    {
        if (pass)
        {
            return TOTAL_TEST_POINTS / TOTAL_TESTS;
        }
        
        return 0;
    }
    
    /**
    * Uses a linear congruential generator to generate pseudo random numbers 
    * @return the next pseudo random number.
    */
    private static int getPseudoRandomInt()
    {
        pseudoRandomNumber = pseudoRandomNumber * 1664525 + 1013904223;
        return pseudoRandomNumber;
    }

    /**
    * Converts an integer into another greater than or equal to 0 and less than limit
    * @param i the integer to convert
    * @param limit the limit for the conversion
    * @return the converted int
    */    
    private static int convertToIntInRange(int i, int limit)
    {
        // Negative numbers will be converted to a negative value between 0 and limit. Add limit to make them positive.
        return ((i % limit) + limit) % limit;
    }
}
