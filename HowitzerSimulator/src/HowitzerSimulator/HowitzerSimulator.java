package HowitzerSimulator;

public class HowitzerSimulator {
	private DragForce dragForce;
	
	public HowitzerSimulator(DragForce dragForce) {
		this.dragForce = dragForce;
	}
	
	public DragForce getDragForce() {
		return dragForce;
	}
}
