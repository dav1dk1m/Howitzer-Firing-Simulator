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
		this.dragForce = new DragForce((double) 0.5, 1.3, UNIVERSAL_CONSTANT, UNIVERSAL_CONSTANT, 0.2);
		this.gravForce = new GravitionalForce(mass);
	}

	public double calcHorizontalAcceleration(double t) {
		// this is only for horizontal acceleration
		return (dragForce.calculateDragForce(t) * Math.cos(Math.toRadians(verticalAngle)) / mass);
	}

	public double calcVerticalAcceleration(double t) {
		// this is only for vertical acceleration
		return ((dragForce.calculateDragForce(t) * Math.sin(Math.toRadians(verticalAngle))) - gravForce.calculate())
				/ mass;
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcHorizontalVelocity(double t) {
		double Vx = velocity * Math.cos(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return Vx + (calcHorizontalAcceleration(t) * t);
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcVerticalVelocity(double t) {
		double Vy = velocity * Math.sin(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return Vy + (calcVerticalAcceleration(t) * t);
	}

	/**
	 * calculates the range of the projectile
	 * 
	 * @return double in m
	 */
	public double calcRange(double time) {
		double velocity = calcHorizontalVelocity(time);
		return  velocity * time; 
		
	}
	

	/**
	 * calculates the  position of the projectile
	 * 
	 * @return double array in the form of [x, y]
	 */
	public double[] calcPosition(double time) {
		double positionArray[] = new double[3];
		double range = calcRange(time);

		positionArray[2] = 0; // Assuming landing height as 0

		if (rotationAngle == 0) {
			positionArray[0] = range;
			positionArray[1] = 0;
			return positionArray;
		}
		positionArray[0] = round(range * Math.cos(Math.toRadians(rotationAngle)));
		positionArray[1] = round(range * Math.sin(Math.toRadians(rotationAngle)));
		return positionArray;

	}


	/**
	 * calculates the trajectory of the projectile until it hits the ground
	 * 
	 */
	public void calcTrajectory() {
		double position = height;
		double time = 0.0;
		double airTime = 0;
		int iteration = 0;
		double maxHeight = 0.0;  
		
		while (position >= 0) {
			double velocity = calcVerticalVelocity(time);
			position = height + velocity * time;

			if(position > maxHeight) {
				maxHeight = position;  
			}

			if(position >= 0)
				airTime = time;

			if(iteration % 50 == 0) {
				System.out.println("Time (" + round(time) + ")");
				System.out.println("==================================================");
				System.out.println("Height: " + round(position));
				System.out.println();
			}

			time += 0.001;
			iteration +=1;
		}

		System.out.println("AirTime is " + round(airTime));
		System.out.println("max height is " + round(maxHeight));
		System.out.println("Range is " + round(calcRange(airTime)));
		double[] positionArray = calcPosition(airTime);
		System.out.println("Position is [" + round(positionArray[0]) + "," + round(positionArray[1]) + "," + positionArray[2] + "]m");
	}
	

	/**
	 * Helper function to round double to 2 decimal places (for UI purposes)
	 */
	public double round(double x){
		return Math.round(x * 100.00) / 100.00;
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
		howSim.calcTrajectory();

	}
}
