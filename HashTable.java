/* Nadav Horowitz 5/22/2023 HashTable.java
 * This class includes implementation details for a HashTable object.
 * The underlying array holds NodeList objects and is hard-coded to a table size of 97.
 * Implemented methods include put, get, computeHashValue, and printStats.
*/
public class HashTable {

    NodeList[] table;

    //HashTable constructor, initializes HashTable of size 97.
    //Initializes HashTable buckets as empty NodeLists.
    HashTable(){
        table = new NodeList[97];
        for(int i = 0; i < table.length; i++){
            table[i] = new NodeList();
        }
    }

    //put method used for adding and updating values in the HashTable.
    //Takes ssn String and name String as arguments, stores in HashTable.
    public void put(String ssn, String name){
        int hash = computeHashValue(ssn);
        table[hash].add(ssn, name);
    }

    //get method takes ssn String as argument, if exists, prints and returns corresponding name String to console.
    //Otherwise prints notification if not found.
    public String get(String ssn){
        int hash = computeHashValue(ssn);
        String name = table[hash].get(ssn);
        if(name != null)
            System.out.println("Name of SSN " + ssn + " is: " + name);
        else
            System.out.println("SSN not found");
        return name;
    }

    
    //printStats method calculates and prints various HashTable statistics to console. 
    //Implemented statistics include number of HashTable buckets, 
    //total number of elements in HashTable, average elements per bucket, variance, and standard deviation.
    public void printStats(){
        double totalElements = 0;
        for (NodeList bucket : table){
            totalElements += bucket.getSize();
        }
        int n = table.length;
        double averageElements = totalElements / n;

        double numerator = 0;
        for (NodeList bucket : table){
            int bucketSize = bucket.getSize();
            double summandElement = Math.pow((bucketSize - averageElements),2);
            numerator += summandElement;
        }

        double variance =  numerator / (n-1);
        double stdev = Math.sqrt(variance);

        System.out.println("Number of HashTable buckets = " + table.length);
        System.out.println("Number of elements = " + totalElements);
        System.out.println("Average number of elements per HashTable bucket = " + totalElements / table.length);
        System.out.println("Standard deviation of HashTable = " + stdev);
    }


    //computeHashValue method takes ssn String as argument, computes and returns a corresponding HashTable index.
    public int computeHashValue(String ssn){
        int hash = ssn.hashCode();
        hash %= table.length;
        hash = Math.abs(hash);
        return hash;
    }    
}