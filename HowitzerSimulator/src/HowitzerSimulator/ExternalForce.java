package HowitzerSimulator;

public class ExternalForce {
	private double boosterTime;
	public ExternalForce(double boosterTime){
		this.boosterTime = boosterTime;
		
	}
	public double getExternalForce(double force, double t) {
		if(t == boosterTime)
		
			return 0;
		else 
			return force * t;
			
	}

}
