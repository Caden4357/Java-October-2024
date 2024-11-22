public class DLL {
    public Node head;
    public Node tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be
        // the head and tail of the list
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we
        // found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }

    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;

        // while the current node exists...
        while (current != null) {
            // print its value
            System.out.println(current.value);
            // and move on to its next node.
            current = current.next;
        }
    }

    // This method prints the values of the nodes from the tail to the head.
    public void printValuesBackwards() {
        // find the last node, aka tail.
        if(tail == null){
            System.out.println("The list is empty");
        }
        Node runner = tail;
        while(runner != null){
            System.out.println(runner.value);
            runner = runner.previous;
        }
    }

    // This method removes the last node of our DLL and returns it.
    public Node pop() {
        if (tail == null) {
            System.out.println("The list is empty");
            return new Node(0);
        } else {
            Node nodeToReturn = this.tail;
            tail = tail.previous;
            tail.next = null;
            return nodeToReturn;
        }
    }

    public Boolean contains(Integer value) {
        if (head == null) {
            System.out.println("The list is empty");
            return false;
        } else {
            // itterate through the list and check if the value exists
            Node runner = this.head;
            while (runner != null) {
                if (runner.value == value) {
                    System.out.println("FOUND");
                    return true;
                }
                runner = runner.next;
            }
            return false;
        }
    }
    // Returns the number of nodes in the list.
    public int size(){
        if(head == null){
            return 0;
        }else{
            int numberOfNodes = 0;
            Node runner = head;
            while(runner != null){
                numberOfNodes++;
                runner = runner.next;
            }
            return numberOfNodes;
        }
    }
}
