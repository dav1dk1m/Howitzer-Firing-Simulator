package HowitzerSimulator;

public class HowitzerSimulator {
	private double angle;
	private int height;
	private static int MASS = 5;
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

	public double calcLandingTime() {
		double sinVelocity = INITIAL_VELOCITY * Math.sin(Math.toRadians(angle));
		return (sinVelocity + Math.sqrt(Math.pow(sinVelocity, 2) + 2 * GravitionalForce.GRAVITY * height))
				/ GravitionalForce.GRAVITY;
	}

	public double calcVelocity() {
		return ((gravForce.calculate()) * calcLandingTime()) / MASS;
	}

	public double calcPosition() {
		double Vx = INITIAL_VELOCITY * Math.cos(Math.toRadians(angle));
		double Vy = INITIAL_VELOCITY * Math.sin(Math.toRadians(angle));
		
		return (Vx * (Vy + Math.sqrt(Math.pow(Vy, 2) + 2 * GravitionalForce.GRAVITY * height)))
				/ GravitionalForce.GRAVITY;
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
		double inputAngle = 45;
		int height = 5;

		HowitzerSimulator howSim = new HowitzerSimulator(inputAngle, height);
		double position = howSim.calcPosition();
		System.out.println("Position is " + position);

	}
}
