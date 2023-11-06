package HowitzerSimulator;

public class ExternalForce {
	private double boosterTime;
	private double rocketForce;
	
	public ExternalForce(double boosterTime, double rocketForce){
		this.boosterTime = boosterTime;
		this.rocketForce = rocketForce;
	}
	
	/**
	 * adds the booster force while time > 0
	 * 
	 * @return double in [x,y,z]m
	 */
	public double getExternalForce(double t) {
		if(t == boosterTime)
			return 0;
		else 
			return rocketForce ;
	}

}
