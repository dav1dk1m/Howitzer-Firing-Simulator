package HowitzerSimulator;

import java.util.Scanner;

/**
 * Howitzer Class
 */

public class HowitzerSimulator {
	private double angle;
	private double height;
	private double mass;
	private static int UNIVERSAL_CONSTANT = 1;
	private DragForce dragForce;
	private GravitionalForce gravForce;
	public double velocity;

	public HowitzerSimulator(double angle, double height, double mass, double velocity) {
		this.angle = angle;
		this.height = height;
		this.mass = mass;
		this.velocity = velocity;
		this.dragForce = new DragForce((double) 0.5, 1.3, UNIVERSAL_CONSTANT, UNIVERSAL_CONSTANT);
		this.gravForce = new GravitionalForce(mass);
//		this.externalForce = new ExternalForce()
	}

	/**
	 * calculates the time the projectile is in the air
	 * 
	 * @return double time in seconds
	 */
	public double calcLandingTime() {
		double Vy = velocity * Math.sin(Math.toRadians(angle));
		double Vt = calcTerminalVelocity();
		double landingTime;
		if (Vy > Vt) {
			landingTime = (2 * Vy) / GravitionalForce.GRAVITY;
		} else {
			landingTime = Vy / GravitionalForce.GRAVITY;
		}
		
		return (double) Math.round(landingTime * 100.00) /100.00;
	}

	public double calcTerminalVelocity() {
		return Math.sqrt((2 * gravForce.calculate()) / dragForce.calculateConstants());
	}

	public double calcHorizontalAcceleration() {
		// this is only for horizontal acceleration
		return (dragForce.calculateDragForce() / mass) * Math.cos(Math.toRadians(angle));
	}

	public double calcVerticalAcceleration() {
		// this is only for vertical acceleration
		return ((dragForce.calculateDragForce() / mass) * Math.sin(Math.toRadians(angle))) + gravForce.calculate();
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcHorizontalVelocity() {
		double Vx = velocity * Math.cos(Math.toRadians(angle));
		// only the horizontal velocity matter for this at the moment
		return (calcHorizontalAcceleration() * calcLandingTime()) + Vx;
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcVerticalVelocity() {
		double Vy = velocity * Math.cos(Math.toRadians(angle));
		// only the horizontal velocity matter for this at the moment
		return (calcVerticalAcceleration() * calcLandingTime()) + Vy;
	}

	/**
	 * calculates the position of the projectile
	 * 
	 * @return double in m
	 */
	public double calcPosition() {
		double Vy = velocity * Math.sin(Math.toRadians(angle));
		double Vt = calcTerminalVelocity();
		double position;

		if (Vy < Vt) {
			position = (Math.pow(velocity, 2) * Math.sin(2 * Math.toRadians(angle))) / GravitionalForce.GRAVITY;
		} else {
			position =  (velocity * Vt * Math.cos(Math.toRadians(angle))) / GravitionalForce.GRAVITY;
		}
		
		return (double) Math.round(position * 100.00) / 100.00;
	}

	/**
	 * calculates the max height of the projectile
	 * 
	 * @return double in m
	 */
	public double calcMaxHeight() {
		double maxHeight = height + ((Math.pow(velocity, 2) * Math.pow(Math.sin(Math.toRadians(angle)), 2))
				/ (2 * (GravitionalForce.GRAVITY)
						- dragForce.calculateDragAcceleration(mass) * Math.sin(Math.toRadians(angle))));
		return (double) Math.round(maxHeight * 100.00) / 100.00;
	}

	/**
	 * Gets the drag force on the projectile
	 * 
	 * @return DragForce in N
	 */
	public DragForce getDragForce() {
		return dragForce;
	}

	/**
	 * Sets the drag force on the projectile
	 * 
	 * @param DragForce in N
	 */
	public void setDragForce(DragForce dragForce) {
		this.dragForce = dragForce;
	}

	/**
	 * Gets the angle of the projectile
	 * 
	 * @return angle in degrees
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Sets the angle of the projectile
	 * 
	 * @param angle in degrees
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Gets the starting height of the projectile
	 * 
	 * @return height in m
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Sets the starting height of the projectile
	 * 
	 * @param height in m
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public static void main(String[] args) {
		double inputAngle;
		double height;
		double mass;
		double velocity;

		Scanner in = new Scanner(System.in);
		System.out.println("Input starting height (m): ");
		height = in.nextDouble();

		System.out.println("Input starting angle (0-90 degrees): ");
		inputAngle = in.nextDouble();

		System.out.println("Input mass (>0kg): ");
		mass = in.nextDouble();

		System.out.println("Input Velocity (>0m/s): ");
		velocity = in.nextDouble();

		HowitzerSimulator howSim = new HowitzerSimulator(inputAngle, height, mass, velocity);
		double position = howSim.calcPosition();
		System.out.println("Position is " + position + "m");
		double airTime = howSim.calcLandingTime();
		System.out.println("Air Time is " + airTime + "s");
		double maxHeight = howSim.calcMaxHeight();
		System.out.println("Max height is " + maxHeight + "m");

	}
}
