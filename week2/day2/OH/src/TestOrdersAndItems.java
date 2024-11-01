
public class TestOrdersAndItems {
	public static void main(String[] args) {
//		ITEMS
		Item dripCoffee = new Item("Drip Coffee", 3.5);
		Item latte = new Item("Latte", 4.5);
		Item mocha = new Item("Mocha", 3.75);
		Item italianSoda = new Item("Italian Soda", 5.5);
		
//		ORDERS
		Order cindhuri = new Order("Cindhuri");
		Order jimmy = new Order("Jimmy");
		Order noah = new Order("Noah");
		Order sam = new Order("Sam");
		
		
//		Add drip coffee to jimmy's item list and increment the order's total.
		jimmy.addItem(dripCoffee);
		noah.addItem(latte);
		noah.addItem(italianSoda);
		sam.addItem(latte);
		cindhuri.setReady(true);
		jimmy.setReady(true);
		System.out.println(cindhuri.isReady());
		System.out.println(jimmy.getItems()); // what will this output be??
		System.out.println(noah.getTotal());
		noah.display();
	}
}
