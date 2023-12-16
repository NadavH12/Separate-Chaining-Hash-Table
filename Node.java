/* Nadav Horowitz 5/22/2023 Node.java
 * This class is serves as an ssn and name Node for the NodeList class used in the HashTable implementation.
*/
public class Node {

    //Node object fields
    String ssn;
    String name;
    Node next;

    //Node object constructor
    Node(String ssn, String name){
        this.ssn = ssn;
        this.name = name;
    }
} 