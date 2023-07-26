package HowitzerSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHowitzerSimulator {

	//Unit testing:  value testing 
	@Test
	void testHorizontalAccelerationTrue() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 85, 10, 15);
	
		//minimum test
		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(0)));
		assert(howSim.calcHorizontalAcceleration(0) == 0.1220799060460304);
		
		//nominal test
		System.out.println(("Total Accel: "+ howSim.calcHorizontalAcceleration(.6)));
		assert(howSim.calcHorizontalAcceleration(.6) == 0.12268984803657863);
				
		//max test
		System.out.println("Total Accel: "+howSim.calcHorizontalAcceleration(howSim.airTime));
		assert(howSim.calcHorizontalAcceleration(howSim.airTime) == 0.1220799060460304);

	}
	
	// Integration Testing 
	@Test
	void intTestRange() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 85, 10, 15);
		System.out.println("\n"+ howSim.calcRange(.5));
		assert(howSim.calcRange(.5) == 3.566182305514064);	
	}
	
	@Test
	void intTestPosition() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 10, 3, 85, 10, 15);
		System.out.println("\nx"+  howSim.calcPosition(.5)[0]);
		System.out.println("y"+  howSim.calcPosition(.5)[1]);
		System.out.println("z"+  howSim.calcPosition(.5)[2]);
		assert(howSim.calcPosition(.5)[0] == 3.51);
		assert(howSim.calcPosition(.5)[1] == 0.62);
		assert(howSim.calcPosition(.5)[2] == 0.0);
	}
	
	@Test
	void intTestPosition2() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 85, 10, 15);
		System.out.println("\nx"+  howSim.calcPosition(.5)[0]);
		System.out.println("y"+  howSim.calcPosition(.5)[1]);
		System.out.println("z"+  howSim.calcPosition(.5)[2]);
		assert(howSim.calcPosition(.5)[0] == 3.566182305514064);
		assert(howSim.calcPosition(.5)[1] == 0.0);
		assert(howSim.calcPosition(.5)[2] == 0.0);
	}

}
