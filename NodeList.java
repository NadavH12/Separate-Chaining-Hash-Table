/* Nadav Horowitz 5/22/2023 NodeList.java
 * This class includes implementation details for a LinkedList-style NodeList object.
 * Implemented methods include get, add, update, and getSize.
*/
public class NodeList {

    Node root = null;
    int listSize = 0;

    NodeList(){}

    //get method takes an ssn String as an argument and searches NodeList object for matching value.
    //If NodeList contains matching value, method returns corresponding name, if doesn't contain then returns null.
    String get(String ssn){
        Node pointer = root;
        while(pointer != null){
            if(pointer.ssn.equals(ssn))
                return pointer.name;
            pointer = pointer.next;
        }
        return null;
    }

    
    //add method adds a new Node to the root of the NodeList object.
    //Method takes ssn String and name String as arguments needed to construct added Node.
    void add(String ssn, String name){
        if(this.get(ssn) != null)
            this.update(ssn, name);
        else {
            if (root == null)
                root = new Node(ssn,name);
            else {
                Node pointer = root;
                root = new Node(ssn,name);
                root.next = pointer;
            }
            listSize++;
        }
    }

    //update method takes ssn String and name String as arguments.
    //updates name String for existing ssn String in NodeList.
    void update(String ssn, String name){
        Node pointer = root;
        while(!pointer.ssn.equals(ssn))
            pointer = pointer.next;
        pointer.name = name;
    }    

    //getSize method returns current size of NodeList object.
    int getSize(){
        return listSize;
    }
}