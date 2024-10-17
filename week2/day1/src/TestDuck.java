
public class TestDuck {

	public static void main(String[] args) {
		Duck duck1 = new Duck();
		Duck duck2 = new Duck("Bob", "Yellow", 40, false);
		Duck duck3 = new Duck("Stacy", "Blue");
		System.out.println(duck2.getName());
		System.out.println(duck1.getName());
		duck2.quack();
		duck2.fightGeese();
		System.out.println(duck2.getEnergyLevel());
		duck2.fightGeese();
		System.out.println(duck2.getEnergyLevel());
		System.out.println(Duck.getNumberOfDucks());
		
	}

}
