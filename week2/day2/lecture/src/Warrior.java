
public class Warrior extends Human {
	private Weapon weapon;
	
	public Warrior(String name, Weapon weapon) {
		super(name);
		this.weapon = weapon;
	}

	public Warrior(String name, int level) {
		super(name, level);
	}
	
	
	public void attack(Human target) {
		if(this.getWeapon() != null) {
			int attackPower = this.getWeapon().getAttackPower();
			target.setHealth(target.getHealth() - attackPower);
			this.setStamina(this.getStamina() - 5);
		}
	}
	
	public void defend() {
		this.setStamina(this.getStamina() - 5);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	

}
