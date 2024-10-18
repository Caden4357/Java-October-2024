
public class Calculator {
	private Double num1;
	private Double num2;
	private char operand;
	private Double result;
	
	

	public Calculator(Double num1, Double num2, char operand) {
		this.num1 = num1;
		this.num2 = num2;
		this.operand = operand;
	}

	public Double performOperation() {
		switch (this.getOperand()) {
		case '+': {
			return num1 + num2;
		}
		case '-': {
			return num1 - num2;
		}
		case '*' : {
			return num1 * num2;
		}
		case '/' :{
			return num1 / num2;
		}
		default:
			return 0.0;
		}
	}
	public Double getNum1() {
		return num1;
	}

	public void setNum1(Double num1) {
		this.num1 = num1;
	}

	public Double getNum2() {
		return num2;
	}

	public void setNum2(Double num2) {
		this.num2 = num2;
	}

	public char getOperand() {
		return operand;
	}

	public void setOperand(char operand) {
		this.operand = operand;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	
	
	
}
