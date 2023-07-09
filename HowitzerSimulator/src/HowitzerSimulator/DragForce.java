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
	    
	    /**
	     * Gets the drag coefficient
	     * @return double dragCoefficient
	     */
	    public double getDragCoefficient() {
	        return dragCoefficient;
	    }
	    
	    /**
	     * Sets the drag coefficient	
	     * @param double dragCoefficient
	     */
	    public void setDragCoefficient(double dragCoefficient) {
	        this.dragCoefficient = dragCoefficient;
	    }
	    
	    /**
	     * Gets the fluid Density
	     * @return double fluidDensity
	     */
	    public double getFluidDensity() {
	        return fluidDensity;
	    }
	    
	    /**
	     * Sets the fluid Density
	     * @param double fluidDensity
	     */
	    public void setFluidDensity(int fluidDensity) {
	        this.fluidDensity = fluidDensity;
	    }
	    
	    /**
	     * Gets the area of the projectile
	     * @return double area
	     */
	    public int getArea() {
	        return area;
	    }
	    /**
	     * Sets the area of the projectile
	     * @param double area
	     */
	    public void setArea(int area) {
	        this.area = area;
	    }
	    
	    /**
	     * Gets the flow Velocity
	     * @return double flowVelocity
	     */
	    public double getFlowVelocity() {
	        return flowVelocity;
	    }
	    
	    /**
	     * Sets the flow Velocity
	     * @param double flowVelocity
	     */
	    public void setFlowVelocity(double flowVelocity) {
	        this.flowVelocity = flowVelocity;
	    }

}

