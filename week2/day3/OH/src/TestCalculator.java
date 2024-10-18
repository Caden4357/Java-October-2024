
public class TestCalculator {
	public static void main(String[] args) {
		Calculator calculator = new Calculator(44.0, 30.0, '-');
		Calculator calculator2 = new Calculator(44.0, 30.0, '+');
		Calculator calculator3 = new Calculator(4.0, 3.0, '*');
		Calculator calculator4 = new Calculator(50.0, 5.0, '/');
		System.out.println(calculator.performOperation()); // 14
		System.out.println(calculator2.performOperation()); // 74 
		System.out.println(calculator3.performOperation()); // 12
		System.out.println(calculator4.performOperation()); // 10
	}
}
