package HowitzerSimulator;

public class GravitionalForce {
	public static double GRAVITY = 9.8;
	private int mass;
	
	public GravitionalForce(int mass) {
		this.mass = mass;
	}
	
	public double calculate( ) {
		return mass * GRAVITY;
	}
}
