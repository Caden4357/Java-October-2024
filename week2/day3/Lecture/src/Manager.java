import java.util.ArrayList;

public class Manager extends User implements EmployeeManagement, ManagerManagement{
	private String managerRole;
	private ArrayList<Double> deposits = new ArrayList<Double>();
	
	public Manager(Integer id, String name, String role) {
		super(id, name);
		this.managerRole = role;
	}

	public String getManagerRole() {
		return managerRole;
	}

	public void setManagerRole(String managerRole) {
		this.managerRole = managerRole;
	}

	public ArrayList<Double> getDeposits() {
		return deposits;
	}

	public void setDeposits(ArrayList<Double> deposits) {
		this.deposits = deposits;
	}

	@Override
	public boolean assignPin(int pin) {
//		check if the pin is exactly 4 digits
		if(pin > 99999 & pin < 1000000) {
			this.setPin(pin);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public ArrayList<Double> EODReports() {
		return deposits;
	}
	
	public void makeDeposit(Double deposit) {
		this.deposits.add(deposit);
	}

	@Override
	public boolean authorizePin(int pin) {
		if(this.getPin() == pin) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
