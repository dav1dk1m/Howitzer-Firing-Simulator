package HowitzerSimulator;


/**
 * DragForce Class
 */
public class DragForce {

	    private double dragCoefficient;
	    private double fluidDensity;
	    private int area;
	    private double flowVelocity;
	    private double flowAcceleration;
	    
	    public DragForce(double dragCoefficient, double  fluidDensity, int area, double flowVelocity, double flowAcceleration) {
	    	this.dragCoefficient = dragCoefficient;
	    	this.fluidDensity = fluidDensity;
	    	this.area = area;
	    	this.flowVelocity = flowVelocity;
	    	this.flowAcceleration = flowAcceleration;
	    }

		/**	
		* Calculates the drag force on the projectile 
		* @return drag force in N
		*/
	    public double calculateDragForce(double t) {
	    	// Fluid dynamics, the drag force is f_d(t) = -0.5C𝜌Au(t)^2
	    	double dragForce = -0.5 * dragCoefficient * fluidDensity * area * Math.pow(flowVelocity - (flowAcceleration * t), 2);
	    	
	    	return dragForce;
	    }
	    
	    public double calculateDragAcceleration(double mass, double t) {
	    	return calculateDragForce(t) / mass;
	    }
	    
	    public double calculateConstants() {
	    	return dragCoefficient * fluidDensity * area;
	    }
	    

}

