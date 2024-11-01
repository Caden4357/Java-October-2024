
public class Human {
	private String name;
	private double health = 100;
	private double stamina = 100;
	private int level = 5;
	private boolean isAlive = true;
	
	
	public Human(String name) {
		this.name = name;
	}
	
	

	public Human(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public void defend() {
		this.setStamina(this.getStamina() - 10);
	}

	public void attack(Human target) {
//		this refers to the attacker 
//		target is the target 
		this.setStamina(this.getStamina() - 10);
		target.setHealth(this.getHealth() - 10);
	}

	public void rest() {
		System.out.println(this.getName() + " Is resting.");
		this.setStamina(this.getStamina() + 10);
		this.setHealth(this.getHealth() + 10);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getHealth() {
		return health;
	}


	public void setHealth(double health) {
		if(health <= 0) {
			this.setAlive(false);
			this.health = 0;
			System.out.println("Your dead");
			System.out.println(this.getHealth());
			System.out.println(this.isAlive);
		}else {
			this.health = health;
		}
	}


	public double getStamina() {
		return stamina;
	}


	public void setStamina(double stamina) {
		this.stamina = stamina;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}



	public boolean isAlive() {
		return isAlive;
	}



	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
	
	
}
