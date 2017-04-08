package homework3;

public class Test {
	private int value1;
	private static int value2;
	public static void method1() {
		Test obj = new Test();
		obj.value1 = 1;
		value2 = 2;
	}
	public void method2() {
		value2 = 1;
		value1 = 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test obj = new Test();
		Test.method1();
		obj.value1 = 1;
		Test.value2 = 0;
		System.out.println(obj.value1 + Test.value2);
	}

}
