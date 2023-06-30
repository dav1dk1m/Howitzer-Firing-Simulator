package HowitzerSimulator;

public class HowitzerSimulator {
	private double angle;
	private int height;
	private DragForce dragForce;
	public static int INITIAL_VELOCITY = 0;
	
	public HowitzerSimulator(double angle, int height) {
		this.angle = angle;
		this.height = height;
	}
	
	public DragForce getDragForce() {
		return dragForce;
	}
	
	public void setDragForce(DragForce dragForce) {
		this.dragForce = dragForce;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello!");
	}
}
