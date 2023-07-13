package HowitzerSimulator;

public class ExternalForce {
	private double boosterTime;
	private double rocketForce;
	
	public ExternalForce(double boosterTime, double rocketForce){
		this.boosterTime = boosterTime;
		this.rocketForce = rocketForce;
	}
	
	public double getExternalForce(double t) {
		if(t == boosterTime)
			return 0;
		else 
			return rocketForce ;
	}

}
