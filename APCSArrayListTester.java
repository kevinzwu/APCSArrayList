/*
* Tester code for APCSArrayList.
*/
public class APCSArrayListTester {
    public static void main (String[] args) {

        BasicAddTest();
        LargeAddTest();
        IndexedAddTest(); 
        IndexedAddTestErrorCases();
    }
 
    /*
    * Tests the basic functionality of add(int item) method
    */
    public static void BasicAddTest()
    {
        System.out.println("------------------------ START BasicAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        VerifyListSize(list, 0); 
        
        System.out.println("Calling list.add(5) ");
        list.add(5);
        VerifyListSize(list, 1);
        VerifyValueAtIndex(list, 0, 5);
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        VerifyListSize(list, 2);
        VerifyValueAtIndex(list, 1, 2);
        
        System.out.println("------------------------ END BasicAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /*
    * Tests the functionality of add(int item) method with a lot of values
    */
    public static void LargeAddTest()
    {
        System.out.println("------------------------ START LargeAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        VerifyListSize(list, 0); 
        
        int size = 0;
        for(int index = 0; index < 100; index++) {
            System.out.println("Calling list.add(" + index + ")");
            list.add(index);
            VerifyListSize(list, ++size);
            VerifyValueAtIndex(list, index, index);
        }
        
        System.out.println("------------------------ END LargeAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /*
    * Tests the functionality of add(int index, int item) method
    */
    public static void IndexedAddTest()
    {
        System.out.println("------------------------ START IndexedAddTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        VerifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        VerifyListSize(list, 1);
        VerifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.add(1, 4) ");
        list.add(1, 4);
        VerifyListSize(list, 2);
        VerifyValueAtIndex(list, 0, 2);
        VerifyValueAtIndex(list, 1, 4);
        
        System.out.println("Calling list.add(0, 10)");
        list.add(0, 10);
        VerifyListSize(list, 3);
        VerifyValueAtIndex(list, 0, 10);
        VerifyValueAtIndex(list, 1, 2);
        VerifyValueAtIndex(list, 2, 4);    
        
        System.out.println("Calling list.add(1, 12)");
        list.add(1, 12);
        VerifyListSize(list, 4);
        VerifyValueAtIndex(list, 0, 10);
        VerifyValueAtIndex(list, 1, 12);
        VerifyValueAtIndex(list, 2, 2);
        VerifyValueAtIndex(list, 3, 4);
        
        System.out.println("------------------------ END IndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }

    /*
    * Tests the error functionality of add(int index, int item method)
    */
    public static void IndexedAddTestErrorCases()
    {
        System.out.println("------------------------ START IndexedAddTestErrorCases() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        VerifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        VerifyListSize(list, 1);
        VerifyValueAtIndex(list, 0, 2);
        
        System.out.println("Calling list.add(-1, 4) ");
        try {
            list.add(-1, 4);
            PrintExceptionThrown(false, "index < 0");
        }
        catch(IndexOutOfBoundsException e) {
            PrintExceptionThrown(true, "index < 0");
            VerifyListSize(list, 1);
            VerifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("Calling list.add(2, 10)");
        try {
            list.add(2, 10);
            PrintExceptionThrown(false, "index > size()");
        }
        catch(IndexOutOfBoundsException e) {
            PrintExceptionThrown(true, "index > size()");
            VerifyListSize(list, 1);
            VerifyValueAtIndex(list, 0, 2);
        }
        
        System.out.println("------------------------ END IndexedAddTestErrorCases() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /*
    * Prints whether or not the proper exception was thrown
    */
    public static void PrintExceptionThrown(boolean exceptionThrown, String index)
    {
        System.out.println(getPassFailFromBool(exceptionThrown) + "    Verify that list.add(index, value) when " + index + " throws IndexOutOfBoundsException");
    }
    
    /*
    * Checks and prints whether the value at the specified index in the list is the expected value.
    */
    public static void VerifyValueAtIndex(APIntList list, int index, int expectedItem)
    {
        System.out.println(getPassFailFromBool(list.get(index) == expectedItem) + "     Verify list.get(int index) [Expected at index " + index + ": " + expectedItem + ", Actual at index " + index + ": " + list.get(index) + "]");
    }


    /*
    * Checks and prints whether the list is the expected size
    */
    public static void VerifyListSize(APIntList list, int expectedSize)
    {
        System.out.println(getPassFailFromBool(list.size() == expectedSize) + "     Verify list.size() [Expected: " + expectedSize + ", Actual " + list.size() + "]");
    }
    
    /*
    * Helper method to print "   PASS   " or "***FAIL***" based on a boolean value
    * Asterisks used to help student spot failing tests better.
    */
    private static String getPassFailFromBool(boolean pass)
    {
        if(pass){    
            return "   PASS   ";
        }
        return "***FAIL***";
    }
}
