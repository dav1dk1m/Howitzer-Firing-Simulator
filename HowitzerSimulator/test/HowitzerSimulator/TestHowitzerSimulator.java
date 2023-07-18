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

}
