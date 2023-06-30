package HowitzerSimulator;

public class DragForce {

	    private double dragCoefficient;
	    private int fluidDensity;
	    private int area;
	    private int flowVelocity;
	    
	    public DragForce(double dragCoefficient, int fluidDensity, int area, int flowVelocity) {
	    	this.dragCoefficient = dragCoefficient;
	    	this.fluidDensity = fluidDensity;
	    	this.area = area;
	    	this.flowVelocity = flowVelocity;
	    }

	    public double calculateDragForce() {
	    	// Fluid dynamics, the drag force is f_d(t) = -0.5C𝜌Au(t)^2
	    	double dragForce = -0.5 * dragCoefficient * fluidDensity * area * Math.pow(flowVelocity, 2);
	    	
	    	return dragForce;
	    }
	    
	    public double getDragCoefficient() {
	        return dragCoefficient;
	    }
	    
	    public void setDragCoefficient(double dragCoefficient) {
	        this.dragCoefficient = dragCoefficient;
	    }
	    
	    public double getFluidDensity() {
	        return fluidDensity;
	    }
	    
	    public void setFluidDensity(int fluidDensity) {
	        this.fluidDensity = fluidDensity;
	    }
	    
	    public int getArea() {
	        return area;
	    }
	    
	    public void setArea(int area) {
	        this.area = area;
	    }
	    
	    public int getFlowVelocity() {
	        return flowVelocity;
	    }
	    
	    public void setFlowVelocity(int flowVelocity) {
	        this.flowVelocity = flowVelocity;
	    }

}

