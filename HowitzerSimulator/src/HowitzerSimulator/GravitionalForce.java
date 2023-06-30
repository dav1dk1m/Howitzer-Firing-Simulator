package HowitzerSimulator;

public class GravitionalForce {
	private static double GRAVITY = -9.8;
	private int mass;
	
	public GravitionalForce(int mass) {
		this.mass = mass;
	}
	
	public double calculate( ) {
		return mass * GRAVITY;
	}
}
