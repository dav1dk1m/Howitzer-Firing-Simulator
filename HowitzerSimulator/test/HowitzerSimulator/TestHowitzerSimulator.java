package HowitzerSimulator;

import org.junit.*;

import static org.junit.Assert.*;

public class TestHowitzerSimulator {

    @Test
    public void testCalcPosition1() {
        HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 10, 10);
        double[] result = howSim.calcPosition(1);
        double[] expectedResults = {7.06, 0.0, 0.0};  
        assertArrayEquals(expectedResults, result, 0.01);
    }

    @Test
    public void testCalcPosition2() {
        HowitzerSimulator howSim = new HowitzerSimulator(45, 90, 3, 10, 10);
        double[] result = howSim.calcPosition(1);
        double[] expectedResults = {0.0, 7.06, 0.0};  
        assertArrayEquals(expectedResults, result, 0.01);
    }

    @Test
    public void testCalcPosition3() {
        HowitzerSimulator howSim = new HowitzerSimulator(45, 0, 3, 10, 10);
        double[] result = howSim.calcPosition(2);
        double[] expectedResults = {14.11, 0.0, 0.0};  
        assertArrayEquals(expectedResults, result, 0.01);
    }

    @Test
    public void testCalcPosition4() {
        HowitzerSimulator howSim = new HowitzerSimulator(45, 90, 3, 10, 10);
        double[] result = howSim.calcPosition(2);
        double[] expectedResults = {0.0, 14.11, 0.0};  
        assertArrayEquals(expectedResults, result, 0.01);
    }
}
