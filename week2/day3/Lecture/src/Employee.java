import java.util.ArrayList;

public class Employee extends User implements EmployeeManagement{
	
	private ArrayList<String> timesheet = new ArrayList<String>();
	
	public Employee(Integer id, String name) {
		super(id, name);
	}

	public ArrayList<String> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(ArrayList<String> timesheet) {
		this.timesheet = timesheet;
	}

	@Override
	public boolean assignPin(int pin) {
//		check if the pin is exactly 4 digits
		if(pin > 999 & pin < 10000) {
			this.setPin(pin);
			return true;
		}else {
			return false;
		}
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
