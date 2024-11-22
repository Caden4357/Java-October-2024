public class TestDLL {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        

        Node deletedNode = dll.pop();
        System.out.println(deletedNode.value);
        // System.out.println(dll.contains(60)); // true
        // System.out.println(dll.contains(100)); // false


        dll.printValuesBackwards();

        System.out.println(dll.size());
    }
}
