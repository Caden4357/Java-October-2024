
public class TestGame {
	public static void main(String[] args) {
		Sword longSword = new Sword(20, "Long Sword");
		Human bob = new Human("Bob");
		Warrior joe = new Warrior("Joe", longSword);
		
		bob.setHealth(30);
		joe.attack(bob);
		bob.rest();
		bob.rest();
		joe.attack(bob);
		System.out.println(bob.getHealth());
		System.out.println(joe.getStamina());
		System.out.println(joe.getWeapon().getName());
		
 	}
}
