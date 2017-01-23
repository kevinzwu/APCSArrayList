/**
 *
 * Tester code for APCSArrayList.
 * This code will run as long as there is a APArrayIntList
 * class defined in the same folder as this file.
 * 
 * You should NOT need to modify this code 
 * 
*/
public class APCSArrayListTester {
    
    public static void main (String[] args) {

        double totalTestPoints = 20;
        double successfulTestPoints = 0;
        
        successfulTestPoints += basicAddTest();
        successfulTestPoints += largeAddTest();
        successfulTestPoints += indexedAddTest(); 
        successfulTestPoints += indexedAddTestErrorCases();
        
        System.out.println(successfulTestPoints + "/" + totalTestPoints + "=" + (successfulTestPoints / totalTestPoints));
    }
 
    /**
    * Tests the basic functionality of add(int item) method
    */    
    public static void basicAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START BasicAddTest() ------------------------");
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
        
        recordTestResult(testPass);
        
        System.out.println("------------------------ END BasicAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /**
    * Tests the functionality of add(int item) method with a lot of values
    */
    public static void largeAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START LargeAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        int size = 0;
        for(int index = 0; index < 100; index++) {
            System.out.println("Calling list.add(" + index + ")");
            list.add(index);
            testPass &= verifyListSize(list, ++size);
            testPass &= verifyValueAtIndex(list, index, index);
        }
        
        recordTestResult(testPass);
        
        System.out.println("------------------------ END LargeAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /**
    * Tests the functionality of add(int index, int item) method
    */
    public static void indexedAddTest()
    {
        boolean testPass = true;
        
        System.out.println("------------------------ START IndexedAddTest() ------------------------");
        
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        testPass &= verifyListSize(list, 0); 
        
        System.out.println("Calling list.add(2)");
        list.add(2);
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
        
        System.out.println("------------------------ END IndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
        
        record
    }

    /**
    * Tests the error functionality of add(int index, int item method)
    */
    public static void indexedAddTestErrorCases()
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
    
    /**
     * Verifies whether or not the proper exception was thrown
     * @param exceptionThrown determines whether an exception was thrown
     * @param method the method called
     * @param condition the condition that should raise exception
     */
    public static boolean verifyExceptionThrown(boolean exceptionThrown, String method, String condition)
    {
        System.out.println(getPassFailFromBool(exceptionThrown) + "    Verify that " + method + " when " + condition + " throws IndexOutOfBoundsException");
        return exceptionThrown;
    }
    
    /**
    * Verifies whether the value at the specified index in the list is the expected value.
    * @param list the list to verify value at
    * @param index the index to verify value at
    * @param expectedItem the expected value at index in list
    */
    public static boolean verifyValueAtIndex(APIntList list, int index, int expectedItem)
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
    */
    public static boolean verifyListSize(APIntList list, int expectedSize)
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
        if(pass){
            return "   PASS   ";
        }
        return "***FAIL***";
    }
    
    private static void recordTestResult(boolean testPass)
    {
        totalTests++;
        if (testPass)
        {
            successfulTests++;
        }
    }
}
