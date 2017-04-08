package exercise3_1;

public class Rectangle {
	private double leftx, lefty, rightx, righty;
	
	public Rectangle() {
        this.leftx = 0;
        this.lefty = 0;
        this.rightx = 1;
        this.righty = 1;
    }
	
	public Rectangle(double rightx, double righty) {
        this.leftx = 0;
        this.lefty = 0;
        this.rightx = rightx;
        this.righty = righty;
    }
	
	public Rectangle(double leftx, double lefty, double rightx, double righty) {
        this.leftx = leftx;
        this.lefty = lefty;
        this.rightx = rightx;
        this.righty = righty;
    }
	
	public double width() {
		return Math.abs(rightx - leftx);
	}
	
	public double height() {
		return Math.abs(righty - lefty);
	}
	
	public double area() {
		return width()*height();
	}
}
