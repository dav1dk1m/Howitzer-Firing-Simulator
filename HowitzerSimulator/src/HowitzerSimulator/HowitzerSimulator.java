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
	private ExternalForce externalForce;
	public double airTime;
	public double maxHeight;
	public double positionArr[];
	public double range;
	public double velocity;

	public HowitzerSimulator(double verticalAngle, double rotationAngle, double height, double mass, double velocity,
			double rocketForce) {
		this.verticalAngle = verticalAngle;
		this.rotationAngle = rotationAngle;
		this.height = height;
		this.mass = mass;
		this.velocity = velocity;
		this.dragForce = new DragForce((double) 0.5, 1.3, UNIVERSAL_CONSTANT, UNIVERSAL_CONSTANT, 0.2);
		this.gravForce = new GravitionalForce(mass);
		this.externalForce = new ExternalForce(1, rocketForce);
	}
	
	
	/**
	 * calculates the Acceleration of the projectile
	 * 
	 * @return double in m/s^2
	 */
	public double calcHorizontalAcceleration(double t) {
		// this is only for horizontal acceleration
		
		if(t >= 0)
		return (dragForce.calculateDragForce(t) * Math.cos(Math.toRadians(verticalAngle))
				+ externalForce.getExternalForce(t) * Math.cos(Math.toRadians(verticalAngle)))/ mass;
		return 0;
	}

	/**
	 * calculates the Acceleration of the projectile
	 * 
	 * @return double in m/s^2
	 */
	public double calcVerticalAcceleration(double t) {
		// this is only for vertical acceleration
		
		if(t >= 0)
		return ((dragForce.calculateDragForce(t) * Math.sin(Math.toRadians(verticalAngle)))
				+ externalForce.getExternalForce(t) * Math.sin(Math.toRadians(verticalAngle)) - gravForce.calculate())
				/ mass;
		return 0;
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcHorizontalVelocity(double t) {
		if(t >= 0) {
		double Vx = velocity * Math.cos(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return Vx + (calcHorizontalAcceleration(t) * t);
		}
		return 0;
	}

	/**
	 * calculates the velocity of the projectile
	 * 
	 * @return double in m/s
	 */
	public double calcVerticalVelocity(double t) {
		if(t >= 0) {
		double Vy = velocity * Math.sin(Math.toRadians(verticalAngle));
		// only the horizontal velocity matter for this at the moment
		return Vy + (calcVerticalAcceleration(t) * t);
		}
		return 0;
	}

	/**
	 * calculates the range of the projectile
	 * 
	 * @return double in m
	 */
	public double calcRange(double time) {
		if(time >= 0) {
		double velocity = calcHorizontalVelocity(time);
		return velocity * time;
		}
		return 0;

	}
	
	/**
	 * calculates the 3D position of the projectile
	 * 
	 * @return double in [x,y,z]m
	 */
	public double[] calcPosition(double time) {
		
		double positionArray[] = new double[3];
		if(time >= 0) {
			double range = calcRange(time);

		positionArray[2] = 0; // Assuming landing height as 0

		if (rotationAngle == 0) {
			positionArray[0] = round(range);
			positionArray[1] = 0;
			return positionArray;
		}
		positionArray[0] = round(range * Math.cos(Math.toRadians(rotationAngle)));
		positionArray[1] = round(range * Math.sin(Math.toRadians(rotationAngle)));
		}
		return positionArray;
		

	}
	
	/**
	 * calculates the height of the projectile at a given time
	 * 
	 * @return double in height m
	 */
	public void calcTrajectory() {
		double position = height;
		double time = 0.0;
		airTime = 0;
		int iteration = 0;
		maxHeight = 0.0;
		System.out.print("Calculation STATE\n\n");
		while (position >= 0) {
			double velocity = calcVerticalVelocity(time);
			position = height + velocity * time;

			if (position > maxHeight) {
				maxHeight = position;
			}

			if (position >= 0)
				airTime = time;

			if (iteration % 50 == 0) {
				System.out.println("Time (" + round(time) + ")");
				System.out.println("==================================================");
				System.out.println("Height: " + position);
				System.out.println();
			}

			time += 0.001;
			iteration += 1;
		}
		System.out.print("OUTPUT STATE\n\n");
		System.out.println("AirTime is " + round(airTime) + "s");
		System.out.println("Max Height is " + round(maxHeight) + "m");
		System.out.println("Range is " + round(calcRange(airTime)) + "m");
		positionArr = calcPosition(airTime);
		System.out.println("Position is [" + round(positionArr[0]) + "," + round(positionArr[1]) + ","
				+ round(positionArr[2]) + "]m");
	}

	/**
	 * rounds values to 2 decimal places
	 * 
	 * @return double 
	 * 
	 */
	public double round(double x) {
		return Math.round(x * 100.00) / 100.00;
	}


	public static void main(String[] args) {
		System.out.print("INPUT STATE\n\n");
		
		double launchAngle;
		double rotationAngle;
		double height;
		double mass;
		double velocity;
		double rocketForce;

		Scanner in = new Scanner(System.in);

		System.out.print("Input starting height (m): ");
		height = in.nextDouble();

		while (height < 0) {
			System.out.print("Height should be >= 0. Try again. ");
			height = in.nextDouble();
		}

		System.out.print("Input launch angle (0-90 degrees): ");
		launchAngle = in.nextDouble();

		while (launchAngle < 0 || launchAngle > 90) {
			System.out.print("Launch angle should be between 0 and 90 degrees. Try again: ");
			launchAngle = in.nextDouble();
		}

		System.out.print("Input rotation angle (0-360 degrees): ");
		rotationAngle = in.nextDouble();

		while (rotationAngle < 0 || rotationAngle > 360) {
			System.out.print("Rotation angle should be between 0 and 360 degrees. Try again: ");
			rotationAngle = in.nextDouble();
		}

		System.out.print("Input mass (>0kg): ");
		mass = in.nextDouble();

		while (mass <= 0) {
			System.out.print("Mass should be > 0kg. Try again: ");
			mass = in.nextDouble();
		}

		System.out.print("Input Velocity (>0m/s): ");
		velocity = in.nextDouble();

		while (velocity <= 0) {
			System.out.print("Velocity should be > 0m/s. Try again:");
			velocity = in.nextDouble();
		}

		System.out.print("Input Rocket Force (N): ");
		rocketForce = in.nextDouble();

		HowitzerSimulator howSim = new HowitzerSimulator(launchAngle, rotationAngle, height, mass, velocity,
				rocketForce);
//		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 85, 10, 25);
		howSim.calcTrajectory();

	}
}
