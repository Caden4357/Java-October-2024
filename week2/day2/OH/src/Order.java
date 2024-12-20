import java.util.ArrayList;

public class Order {
	private String name;
	private double total;
	private boolean isReady;
	private ArrayList<Item> items = new ArrayList<Item>(); // the only reason I put '= new ArrayList<Item>();' is to make items = [] rather than null.
	
	public Order(String name) {
		this.name = name;
	}

	public void addItem(Item item) {
		this.total += item.getPrice();
		this.items.add(item);
	}
	
	public void display() {
		System.out.println("Customer Name: " + this.getName());
		for(int idx = 0; idx < items.size(); idx++) {
			String name = items.get(idx).getName();
			double price = items.get(idx).getPrice();
			System.out.println(name + " - " + "$" + price);
		}
//	    Total: $10.00
		System.out.println("Your total is: $" + this.getTotal());
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	
}
