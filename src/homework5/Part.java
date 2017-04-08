package homework5;

public abstract class Part {
	private String name;
	private int num;
	
	public Part(String name, int num) {
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return num;
	}
	public abstract String toString();
	public abstract double inventory();
}
