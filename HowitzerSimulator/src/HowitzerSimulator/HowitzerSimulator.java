package HowitzerSimulator;

public class HowitzerSimulator {
	private double angle;
	private DragForce dragForce;
	
	public HowitzerSimulator(double angle, DragForce dragForce) {
		this.dragForce = dragForce;
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
}
