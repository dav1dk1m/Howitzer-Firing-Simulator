package HowitzerSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHowitzerSimulator {

	//Unit testing: 
	//Boundary value testing 
	@Test
	void testHorizontalAccelerationTrueBoundary() {
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
	
	//Equivalence class testing
	@Test
	void testHorizontalAccelerationEquivalence() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 85, 10, 15);
		
		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(-1)));
		assert(howSim.calcHorizontalAcceleration(-1) == 0);
		
		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(-0.01)));
		assert(howSim.calcHorizontalAcceleration(-0.01) == 0);
		
		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(0)));
		assert(howSim.calcHorizontalAcceleration(0) == 0.1220799060460304);
		
		//nominal test
		System.out.println(("Total Accel: "+ howSim.calcHorizontalAcceleration(.6)));
		assert(howSim.calcHorizontalAcceleration(.6) == 0.12268984803657863);
	}
	
	//Decision table-based testing
	@Test
	void testPositionTable() {
		//test 1 
		//vertAngle: 45, rotation: 0, height: 0 weight: 10  velocity: 10 rocketForce: 15 time: 0.5
		HowitzerSimulator howSim1 = new HowitzerSimulator(45, 0, 0, 10, 10, 15);
		System.out.println("\nx "+  howSim1.calcPosition(.5)[0]);
		System.out.println("y "+  howSim1.calcPosition(.5)[1]);
		System.out.println("z "+  howSim1.calcPosition(.5)[2]);
		assert(howSim1.calcPosition(.5)[0] == 3.8);
		assert(howSim1.calcPosition(.5)[1] == 0.0);
		assert(howSim1.calcPosition(.5)[2] == 0.0);
		
		//test 2 
		//vertAngle: 45, rotation: 90, height: 0 weight: 10  velocity: 10 rocketForce: 15 time: 0.5
		HowitzerSimulator howSim2 = new HowitzerSimulator(45, 90, 0, 10, 10, 15);
		System.out.println("\nx "+  howSim2.calcPosition(.5)[0]);
		System.out.println("y "+  howSim2.calcPosition(.5)[1]);
		System.out.println("z "+  howSim2.calcPosition(.5)[2]);
		assert(howSim2.calcPosition(.5)[0] == 0.0);
		assert(howSim2.calcPosition(.5)[1] == 3.8);
		assert(howSim2.calcPosition(.5)[2] == 0.0);
		
		//test 3 
		//vertAngle: 45, rotation: 180, height: 0 weight: 10  velocity: 10 rocketForce: 15 time: 0.5
		HowitzerSimulator howSim3 = new HowitzerSimulator(45, 180, 0, 10, 10, 15);
		System.out.println("\nx "+  howSim3.calcPosition(.5)[0]);
		System.out.println("y "+  howSim3.calcPosition(.5)[1]);
		System.out.println("z "+  howSim3.calcPosition(.5)[2]);
		assert(howSim3.calcPosition(.5)[0] == -3.8);
		assert(howSim3.calcPosition(.5)[1] == 0.0);
		assert(howSim3.calcPosition(.5)[2] == 0.0);
		
		
		//test 4 
		//vertAngle: 45, rotation: 270, height: 0 weight: 10  velocity: 10 rocketForce: 15 time: 0.5
		HowitzerSimulator howSim4 = new HowitzerSimulator(45, 270, 0, 10, 10, 15);
		System.out.println("\nx "+  howSim4.calcPosition(.5)[0]);
		System.out.println("y "+  howSim4.calcPosition(.5)[1]);
		System.out.println("z "+  howSim4.calcPosition(.5)[2]);
		assert(howSim4.calcPosition(.5)[0] == 0.0 );
		assert(howSim4.calcPosition(.5)[1] == -3.8);
		assert(howSim4.calcPosition(.5)[2] == 0.0);
		
		//test 5 
		//vertAngle: 45, rotation: 200, height: 0 weight: 10  velocity: 10 rocketForce: 15 time: 0.5
		HowitzerSimulator howSim5 = new HowitzerSimulator(45, 200, 0, 10, 10, 15);
		System.out.println("\nx "+  howSim5.calcPosition(.5)[0]);
		System.out.println("y "+  howSim5.calcPosition(.5)[1]);
		System.out.println("z "+  howSim5.calcPosition(.5)[2]);
		assert(howSim5.calcPosition(.5)[0] == -3.57 );
		assert(howSim5.calcPosition(.5)[1] == -1.3);
		assert(howSim5.calcPosition(.5)[2] == 0.0);
	}
	
	
	//Path testing
	//this is run as a coverage test and it covers all paths as well as looking at the critical point, 0. 
	@Test
	void testHorizontalAccelerationPath() {
		HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 0, 10, 10, 15);

		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(-0.01)));
		assert(howSim.calcHorizontalAcceleration(-0.01) == 0);
		
		System.out.println(("Total Accel: "+howSim.calcHorizontalAcceleration(0)));
		assert(howSim.calcHorizontalAcceleration(0) == 1.0376792013912586);
		
		//nominal test
		System.out.println(("Total Accel: "+ howSim.calcHorizontalAcceleration(.6)));
		assert(howSim.calcHorizontalAcceleration(.6) == 1.0428637083109185);
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
		assert(howSim.calcPosition(.5)[0] == 3.57);
		assert(howSim.calcPosition(.5)[1] == 0.0);
		assert(howSim.calcPosition(.5)[2] == 0.0);
	}

}
