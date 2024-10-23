
public class SLL {
    public Node head;

    public SLL() {
        this.head = null;
    }
    public SLL(Node head){
        this.head = head;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the
    // list.
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head; // think of this as i or idx in a for loop that typically starts at 0 for an array
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    // Create a remove() method that will remove a node from the end of your list.
    public void remove(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node runner = head;
            while(runner.next.next != null){
                System.out.println("Runner: " + runner.value);
                System.out.println("Next: " + runner.next.value);
                // System.out.println("Next Next: " + runner.next.next.value);
                runner = runner.next;
                System.out.println("Runner: " + runner.value);
                System.out.println("Next: " + runner.next.value);
            }
            System.out.println("^^^^^^^^^^^^^^^^");
            System.out.println(runner.next);
            runner.next = null;
        }
    }
    public void display(){
        System.out.println("**********DISPLAY****************");
        if(head == null){
            System.out.println("Empty list");
        }
        Node runner = head;
        while(runner.next != null){
            System.out.println("Runner: " + runner.value);
            System.out.println("Next: " + runner.next.value);
            runner = runner.next;
        }
    }
}
//  r 
// [3 -> 6 -> 9 -> null]
