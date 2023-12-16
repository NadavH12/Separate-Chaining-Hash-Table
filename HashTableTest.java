/* Nadav Horowitz 5/22/2023 HashTableTest.java
 * This class includes methods used to test the implementation of HashTable.java.
 * The class also includes methods that generate random ssns and random names.
*/
import java.util.Random;
import java.nio.charset.Charset;
public class HashTableTest {
    public static void main(String[] args){
        testPutAndGet();
        Random rand = new Random();
        testTable(10, rand);
        testTable(20, rand);
        testTable(40, rand);
    }


    //testPutandGet() method tests the implementation of the HashTable class' put() and get() methods.
    //The method also prints testing information to the console.
    public static void testPutAndGet(){
        HashTable ht = new HashTable();
        System.out.println("Hash Table Put and Get Test:\n");

        System.out.println("Test getting item not in table:");
        System.out.println("get(111-11-1111)");
        ht.get("111-11-1111");
        System.out.println();

        System.out.println("Inserting value: 111-11-1111, Arthur Ardvark");
        System.out.println("Inserting value: 222-22-2222, Barry Bonds");
        System.out.println("Inserting value: 333-33-3333, Charlie Chaplin\n");

        ht.put("111-11-1111", "Arthur Ardvark");
        ht.put("222-22-2222", "Barry Bonds");
        ht.put("333-33-3333", "Charlie Chaplin");

        System.out.println("Test getting item in table:");
        System.out.println("get(333-33-3333)");
        ht.get("333-33-3333");
        System.out.println();

        System.out.println("Test updating item in table:");
        System.out.println("Inserting value: 222-22-2222, Darry Daniel");
        System.out.println("get(222-22-2222)");
        ht.put("222-22-2222", "Darry Daniel");
        ht.get("222-22-2222");

        System.out.println("\n\n\n");
    }


    //testTable method constructs and fills a HashTable object with randomly generated names and ssns.
    //testTable method takes an int parameter 'elements' that specifies the N/M ratio wanted for the HashTable.
    //The method also prints testing results to the console.
    public static void testTable(int elements, Random rand){
        HashTable ht = new HashTable();

        for(int i = 0; i < elements * ht.table.length; i++){
            String ssn = generateSSN(rand);
            String name = generateName(rand);
            ht.put(ssn,name);
        }

        System.out.println("Testing HashTable with N/M = " + elements + ":"); 
        ht.printStats();
        System.out.println("\n");
    }
    
    
    //generateSSN method generates and returns an SSN string of the form 'ddd-dd-dddd' where each d is a randomly
    //generated single digit integer
    public static String generateSSN(Random rand){
        String randomDigits = "";
        for(int i = 0; i < 9; i++){
            int digit = rand.nextInt(10);
            randomDigits += digit;
        }
        String ssn = randomDigits.substring(0, 3) + "-" + randomDigits.substring(3, 5) + "-" + randomDigits.substring(5);
        return ssn;
    }


    //generateName method generates and returns a String containing 7 randomly generated characters
    //Possible characters include all characters specified in UTF-8 charset.
    public static String generateName(Random rand){
        byte[] byteArray = new byte[7];
        rand.nextBytes(byteArray);
        String generatedString = new String(byteArray, Charset.forName("UTF-8"));
        return generatedString;
    }
}