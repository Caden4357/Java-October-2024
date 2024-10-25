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
		System.out.println(pin);
//		check if the pin is exactly 4 digits
		String stringNum = String.valueOf(pin);
		System.out.println(stringNum);
		int numDigits = String.valueOf(pin).length();
		System.out.println("NUM OF DIGITS: " + numDigits);
		if(numDigits == 4 ) {
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
