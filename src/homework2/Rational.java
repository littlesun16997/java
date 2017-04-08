package homework2;

public class Rational {
	private int num, den;
	
	public Rational() {
		this.num = 0;
		this.den = 1;
	}
	
	public Rational(int num, int den) {
		if (den == 0) {
			System.err.println("Denominator cannot be 0, change it to 1");
			this.den = 1;
			this.num = num;
		}
		else {
			this.num = num;
			this.den = den;
		}
	}
	
	public String display() {
		return (num + "/" + den);
	}
	
	public double decimal() {
		return (double)num/den;
	}
	
	public Rational multiply(Rational another) {
		Rational result = new Rational();
		result.num = this.num * another.num;
		result.den = this.den * another.den;
		return result;
	}
}
