
public class Test {
    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.remove();
        // sll.remove();
        sll.display();
        Node result1 = sll.find(30);
        System.out.println(result1.value);
        Node result2 = sll.find(5);
        System.out.println(result2.value);

    }
}
