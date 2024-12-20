
public class Duck {
//	attributes or member variables 
	private String name;
	private String color;
	private int energyLevel = 100;
	private boolean isHelpful = true;
	private static int numberOfDucks;
	
//	constructor 
	public Duck(String name, String color, int energyLevel, boolean isHelpful) {
		this.name = name;
		this.color = color;
		this.energyLevel = energyLevel;
		this.isHelpful = isHelpful;
		numberOfDucks++;
	}
//	constructor overloading
	public Duck() {
		numberOfDucks++;
	}
	
	public Duck(String name, String color) {
		this.name = name;
		this.color = color;
		numberOfDucks++;
	}
	
//	custom methods
	public void quack() {
		System.out.println(this.getName() + " Quacks Loudly");
		this.setEnergyLevel(this.getEnergyLevel() - 10);
	}
	
	public void fightGeese() {
		this.setEnergyLevel(this.getEnergyLevel() - 20);
		this.isHelpful = false;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		if(energyLevel <= 0) {
			this.energyLevel = 0;
			System.out.println("Your too tired");
		}else {
			this.energyLevel = energyLevel;
		}
	}
	
	public boolean isHelpful() {
		return isHelpful;
	}
	public void setHelpful(boolean isHelpful) {
		this.isHelpful = isHelpful;
	}
	public static int getNumberOfDucks() {
		return numberOfDucks;
	}
	public static void setNumberOfDucks(int numberOfDucks) {
		Duck.numberOfDucks = numberOfDucks;
	}
	
}
