package HowitzerSimulator;
import java.util.Scanner;

	/**
	 * Howitzer Class
	 */

public class HowitzerSimulator {
	private double angle;
	private int height;
	private static double MASS = 5;
	private static int UNIVERSAL_CONSTANT = 1;
	private DragForce dragForce;
	private GravitionalForce gravForce;
	public static int INITIAL_VELOCITY = 10;

	public HowitzerSimulator(double angle, int height) {
		this.angle = angle;
		this.height = height;
		this.dragForce = new DragForce((double) UNIVERSAL_CONSTANT, UNIVERSAL_CONSTANT, UNIVERSAL_CONSTANT,
				UNIVERSAL_CONSTANT);
		this.gravForce = new GravitionalForce(MASS);
//		this.externalForce = new ExternalForce()
	}
	
	/**	
	* calculates the time the projectile is in the air
	* @return double time in seconds
	*/
	public double calcLandingTime() {
		double sinVelocity = INITIAL_VELOCITY * Math.sin(Math.toRadians(angle));
		return (sinVelocity + Math.sqrt(Math.pow(sinVelocity, 2) + 2 * GravitionalForce.GRAVITY * height))
				/ GravitionalForce.GRAVITY;
	}

	
	public double calcAcceleration() {

		return (gravForce.calculate())/MASS;
	}
	
	
	/**	
	* calculates the velocity of the projectile 
	* @return double in m/s
	*/
	public double calcVelocity() {
		double Vx = INITIAL_VELOCITY * Math.cos(Math.toRadians(angle));
		return  Vx;
	}

	/**	
	* calculates the position of the projectile 
	* @return double in m
	*/
	public double calcPosition() {
//		double Vx = INITIAL_VELOCITY * Math.cos(Math.toRadians(angle));
//		double Vy = INITIAL_VELOCITY * Math.sin(Math.toRadians(angle));
//		
//		return (Vx * (Vy + Math.sqrt(Math.pow(Vy, 2) + 2 * GravitionalForce.GRAVITY * height)))
//				/ GravitionalForce.GRAVITY;
		
		
		return (calcVelocity() * calcLandingTime());
	}
	
	/**	
	* calculates the max height of the projectile 
	* @return double in m
	*/
	public double calcMaxHeight() {
		double Vx = INITIAL_VELOCITY * Math.cos(Math.toRadians(angle));
		double Vy = INITIAL_VELOCITY * Math.sin(Math.toRadians(angle));
		
		return height + ((Math.pow(INITIAL_VELOCITY, 2) * Math.pow( Math.sin(Math.toRadians(angle)), 2))/(2 * GravitionalForce.GRAVITY));
	}

	/**	
	* Gets the drag force on the projectile 
	* @return DragForce in N
	*/
	public DragForce getDragForce() {
		return dragForce;
	}
	/**	
	* Sets the drag force on the projectile 
	* @param DragForce in N
	*/
	public void setDragForce(DragForce dragForce) {
		this.dragForce = dragForce;
	}

	/**	
	* Gets the angle of the projectile 
	* @return angle in degrees
	*/
	public double getAngle() {
		return angle;
	}
	
	/**	
	* Sets the angle of the projectile 
	* @param angle in degrees
	*/
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**	
	* Gets the starting height of the projectile 
	* @return height in m
	*/
	public double getHeight() {
		return height;
	}
	
	/**	
	* Sets the starting height of the projectile 
	* @param height in m
	*/
	public void setHeight(int height) {
		this.height = height;
	}

	public static void main(String[] args) {
		double inputAngle;
		int height;
		Scanner in = new Scanner(System.in);
		System.out.println("Input starting height (m): ");
		height = in.nextInt();
		
		System.out.println("Input starting angle (0-90 degrees):");
		inputAngle = in.nextDouble();
		
		HowitzerSimulator howSim = new HowitzerSimulator(inputAngle, height);
		double position = howSim.calcPosition();
		System.out.println("Position is " + position + "m");
		double airTime = howSim.calcLandingTime();
		System.out.println("Air Time is " + airTime + "s" );
		double maxHeight = howSim.calcMaxHeight();
		System.out.println("Max height is " + maxHeight + "m" );
		

	}
}
