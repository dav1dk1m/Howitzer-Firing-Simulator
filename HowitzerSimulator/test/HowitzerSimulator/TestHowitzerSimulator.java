package HowitzerSimulator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * BLACK BOX TESTING : This class contains unit tests for the HowitzerSimulator class.
 */
class TestHowitzerSimulator {

    private HowitzerSimulator howitzerSimulator;

    /**
     * This method sets up the HowitzerSimulator instance with an angle of 45 and a height of 10 for each test.
     */
    @BeforeEach
    public void setup() {
        howitzerSimulator = new HowitzerSimulator(45, 10);
    }

    /**
     * This test checks if the calcLandingTime method is correctly calculating the landing time.
     */
    @Test
    public void testCalcLandingTime() {
        double expectedTime = 2.3219851993085303;
        double actualTime = howitzerSimulator.calcLandingTime();
        assertEquals(expectedTime, actualTime, "The calculated landing time does not match the expected result");
    }

    /**
     * This test checks if the calcPosition method is correctly calculating the position.
     */
    @Test
    public void testCalcPosition() {
        double expectedPosition = 16.418914802458588;
        double actualPosition = howitzerSimulator.calcPosition();
        assertEquals(expectedPosition, actualPosition, "The calculated position does not match the expected result");
    }

    /**
     * This test checks if the calcMaxHeight method is correctly calculating the maximum height.
     */
    @Test
    public void testCalcMaxHeight() {
        double expectedMaxHeight = 12.551020408163264;
        double actualMaxHeight = howitzerSimulator.calcMaxHeight();
        assertEquals(expectedMaxHeight, actualMaxHeight, "The calculated max height does not match the expected result");
    }

    /**
     * This test checks if the GravitationalForce class correctly calculates the force for a given mass.
     */
    @Test
    public void testGravitationalForce() {
        GravitionalForce gravForce = new GravitionalForce(5);
        assertEquals(gravForce.calculate(), 49.0, "The calculated gravitational force does not match the expected result");
    }
    
    /**
     * This test checks if the calcVelocity method is correctly calculating the velocity.
     */
    @Test
    public void testCalcVelocity() {
        assertEquals (howitzerSimulator.calcVelocity(), 22.755454953223598 ,"The calculated velocity does not match the expected result" );
    }

    /**
     * This test checks if the methods of the HowitzerSimulator respond correctly to changes in angle.
     */
    @Test
    public void testAngleBlackBox() {
        howitzerSimulator.setAngle(60); // changing the angle

        double expectedTime = 2.5635032317345625;
        double actualTime = howitzerSimulator.calcLandingTime();
        assertEquals(expectedTime, actualTime, "The calculated landing time does not match the expected result");

        double expectedPosition = 12.817516158672815;
        double actualPosition = howitzerSimulator.calcPosition();
        assertEquals(expectedPosition, actualPosition, "The calculated position does not match the expected result");

        double expectedMaxHeight = 13.826530612244897;
        double actualMaxHeight = howitzerSimulator.calcMaxHeight();
        assertEquals(expectedMaxHeight, actualMaxHeight, "The calculated max height does not match the expected result");
    }

    /**
     * This test checks if the methods of the HowitzerSimulator respond correctly to changes in height.
     */
    @Test
    public void testHeightBlackBox() {
        howitzerSimulator.setHeight(20); // changing the height

        double expectedTime = 2.866822842193277;
        double actualTime = howitzerSimulator.calcLandingTime();
        assertEquals(expectedTime, actualTime, "The calculated landing time does not match the expected result");

        double expectedPosition = 20.271498721753577;
        double actualPosition = howitzerSimulator.calcPosition();
        assertEquals(expectedPosition, actualPosition, "The calculated position does not match the expected result");

        double expectedMaxHeight = 22.551020408163264;
        double actualMaxHeight = howitzerSimulator.calcMaxHeight();
        assertEquals(expectedMaxHeight, actualMaxHeight, "The calculated max height does not match the expected result");
    }
}
