package HowitzerSimulator;
/**
 * GravitionalForce class
 *
 */
public class GravitionalForce {
	public static double GRAVITY = 9.8;
	private int mass;
	
	public GravitionalForce(int mass) {
		this.mass = mass;
	}
	/**
	 * calculates the acceleration due to gravity
	 * @return double acceleration due to gravity
	 */
	public double calculate( ) {
		return mass * GRAVITY;
	}
}
;
