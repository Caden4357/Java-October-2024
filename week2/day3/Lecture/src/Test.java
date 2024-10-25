import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Double> expectedDeposits = new ArrayList<>();
	
		expectedDeposits.add(500.00);
		expectedDeposits.add(700.00);
		expectedDeposits.add(99.97);
		Employee greg = new Employee(1, "Greg");
		Manager tom = new Manager(2, "Tom", "Shift Lead");
//		System.out.println(greg.assignPin(999));
//		System.out.println(greg.assignPin(1234));
		System.out.println(greg.assignPin(0001));
		System.out.println(greg.getPin());
//		System.out.println(tom.assignPin(123456));
//		System.out.println(tom.assignPin(1234567));
//		tom.makeDeposit(500.00);
//		tom.makeDeposit(700.00);
//		tom.makeDeposit(99.99);
//		System.out.println(tom.validateShiftReports(expectedDeposits));
	}
}
