package HowitzerSimulator;

import java.util.Scanner;

/**
 * Howitzer Class
 */

public class HowitzerSimulator {
	private double verticalAngle;
	private double rotationAngle;
	private double height;
	private double mass;
	private static int UNIVERSAL_CONSTANT = 1;
	private DragForce dragForce;
	private GravitionalForce gravForce;
	public double velocity;

	public HowitzerSimulator(double verticalAngle, double rotationAngle, double height, double mass, double velocity) {
		this.verticalAngle = verticalAngle;
		this.rotationAngle = rotationAngle;
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
		double Vy = velocity * Math.sin(Math.toRadians(verticalAngle));
		double Vt = calcTerminalVelocity();
		double landingTime;
		if (Vy > Vt) {
			landingTime = (2 * Vy) / GravitionalForce.GRAVITY;
		} else {
			landingTime = Vy / GravitionalForce.GRAVITY;
		}

		return (double) Math.round(landingTime * 100.00) / 100.00;
	}

	public double calcTerminalVelocity() {
		return Math.sqrt((2 * gravForce.calculate()) / dragForce.calculateConstants());
	}

	public double calcHorizontalAcceleration() {
		// this is only for horizontal acceleration
		return (dragForce.calculateDragForce() / mass) * Math.cos(Math.toRadians(verticalAngle));
	}

	public double calcVerticalAcceleration() {
		// this is only for vertical acceleration
		return ((dragForce.calculateDragForce() / mass) * Math.sin(Math.toRadians(verticalAngle)))
				+ gravForce.calculate();
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcHorizontalVelocity() {
		double Vx = velocity * Math.cos(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return (calcHorizontalAcceleration() * calcLandingTime()) + Vx;
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcVerticalVelocity() {
		double Vy = velocity * Math.cos(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return (calcVerticalAcceleration() * calcLandingTime()) + Vy;
	}

	/**
	 * calculates the range of the projectile
	 * 
	 * @return double in m
	 */
	public double calcRange() {
		double Vy = velocity * Math.sin(Math.toRadians(verticalAngle));
		double Vt = calcTerminalVelocity();
		double range;

		if (Vy < Vt) {
			range = (Math.pow(velocity, 2) * Math.sin(2 * Math.toRadians(verticalAngle))) / GravitionalForce.GRAVITY;
		} else {
			range = (velocity * Vt * Math.cos(Math.toRadians(verticalAngle))) / GravitionalForce.GRAVITY;
		}

		return (double) Math.round(range * 100.00) / 100.00;
	}

	public double[] calcPosition() {
		double positionArray[] = new double[3];
		double range = calcRange();
		
		positionArray[2] = 0;  // Assuming landing height as 0

		if (rotationAngle == 0) {
			positionArray[0] = range;
			positionArray[1] = 0;
			return positionArray;
		}
		positionArray[0] = Math.round(range * Math.cos(Math.toRadians(rotationAngle)) * 100.00) / 100.00;
		positionArray[1] = Math.round(range * Math.sin(Math.toRadians(rotationAngle)) * 100.00) / 100.00;
		return positionArray;

	}

	/**
	 * calculates the max height of the projectile
	 * 
	 * @return double in m
	 */
	public double calcMaxHeight() {
		double maxHeight = height + ((Math.pow(velocity, 2) * Math.pow(Math.sin(Math.toRadians(verticalAngle)), 2))
				/ (2 * (GravitionalForce.GRAVITY)
						- dragForce.calculateDragAcceleration(mass) * Math.sin(Math.toRadians(verticalAngle))));
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
		return verticalAngle;
	}

	/**
	 * Sets the angle of the projectile
	 * 
	 * @param angle in degrees
	 */
	public void setAngle(double angle) {
		this.verticalAngle = angle;
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
		double launchAngle;
		double rotationAngle;
		double height;
		double mass;
		double velocity;

		Scanner in = new Scanner(System.in);

		System.out.println("Input starting height (m): ");
		height = in.nextDouble();

		while (height < 0) {
			System.out.println("Height should be >= 0. Try again.");
			height = in.nextDouble();
		}

		System.out.println("Input launch angle (0-90 degrees): ");
		launchAngle = in.nextDouble();

		while (launchAngle < 0 || launchAngle > 90) {
			System.out.println("Launch angle should be between 0 and 90 degrees. Try again:");
			launchAngle = in.nextDouble();
		}

		System.out.println("Input rotation angle (0-360 degrees): ");
		rotationAngle = in.nextDouble();

		while (rotationAngle < 0 || rotationAngle > 360) {
			System.out.println("Rotation angle should be between 0 and 360 degrees. Try again:");
			rotationAngle = in.nextDouble();
		}

		System.out.println("Input mass (>0kg): ");
		mass = in.nextDouble();

		while (mass <= 0) {
			System.out.println("Mass should be > 0kg. Try again:");
			mass = in.nextDouble();
		}

		System.out.println("Input Velocity (>0m/s): ");
		velocity = in.nextDouble();

		while (velocity <= 0) {
			System.out.println("Velocity should be > 0m/s. Try again:");
			velocity = in.nextDouble();
		}

		HowitzerSimulator howSim = new HowitzerSimulator(launchAngle, rotationAngle, height, mass, velocity);
		double range = howSim.calcRange();
		System.out.println("Range is " + range + "m");
		double[] position = howSim.calcPosition();
		System.out.println("Position is [" + position[0] + "," + position[1] + "," + position[2] + "]m");
		double airTime = howSim.calcLandingTime();
		System.out.println("Air Time is " + airTime + "s");
		double maxHeight = howSim.calcMaxHeight();
		System.out.println("Max height is " + maxHeight + "m");

	}
}
