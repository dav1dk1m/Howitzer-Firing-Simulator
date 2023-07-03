package HowitzerSimulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestHowitzerSimulator {

	    private HowitzerSimulator howitzerSimulator;

	    @BeforeEach
	    public void setup() {
	        howitzerSimulator = new HowitzerSimulator(45, 10);
	    }
	    
	    @Test
	    public void testCalcLandingTime() {
	        double expectedTime = 2.3219851993085303;
	        double actualTime = howitzerSimulator.calcLandingTime();
	        assertEquals(expectedTime, actualTime, "The calculated landing time does not match the expected result");
	    }

	    @Test
	    public void testCalcPosition() {
	        double expectedPosition = 16.418914802458588;
	        double actualPosition = howitzerSimulator.calcPosition();
	        assertEquals(expectedPosition, actualPosition, "The calculated position does not match the expected result");
	    }

	    @Test
	    public void testCalcMaxHeight() {
	        double expectedMaxHeight = 12.551020408163264;
	        double actualMaxHeight = howitzerSimulator.calcMaxHeight();
	        assertEquals(expectedMaxHeight, actualMaxHeight, "The calculated max height does not match the expected result");
	    }
	    
	    @Test
	    public void testGravitationalForce() {
	    	GravitionalForce gravForce = new GravitionalForce(5);
	    	assertEquals(gravForce.calculate(), 49.0, "the calculated gravitational force does not match the expected result");
	    }
	    @Test
	    public void testCalcVelocity() {
	    	int MASS = 5;
	    	
			assertEquals (howitzerSimulator.calcVelocity(), 22.755454953223598 ,"the calculated gravitational force does not match the expected result" );
		}

}
