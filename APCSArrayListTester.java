/*
* Tester code for APCSArrayList.
*/
public class APCSArrayListTester {
    public static void main (String[] args) {

        BasicAddTest();
        
        IndexedAddTest(); 
    
    }

    
    /*
    * Tests the basic functionality of add(int item) and add(int index, int item) methods
    */
    public static void BasicAddTest()
    {
        System.out.println("------------------------ START BasicAddTest() ------------------------");
        System.out.println("Creating new APArrayIntList");
        APIntList list = new APArrayIntList();
        VerifyListSize(list, 1); 
        
        System.out.println("Calling list.add(0) ");
        list.add(5);
        VerifyListSize(list, 1);
        
        System.out.println("Calling list.add(2)");
        list.add(2);
        VerifyListSize(list, 2);
        
        System.out.println("------------------------ END BasicAddTest() ------------------------");
        System.out.println();
        System.out.println();
    }
    
    /*
    * Tests the functionality of add(int index, int item method)
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
        VerifyListSize(list, 8);
        VerifyValueAtIndex(list, 0, 10);
        VerifyValueAtIndex(list, 1, 12);
        VerifyValueAtIndex(list, 2, 2);
        VerifyValueAtIndex(list, 3, 4);
        
        System.out.println("------------------------ END IndexedAddTest() ------------------------");
        System.out.println();
        System.out.println();
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
