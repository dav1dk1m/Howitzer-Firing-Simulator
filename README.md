
# MVP 2 

## Description
MVP 2 focuses on  taking user inputs for height and angle and produce outputs depicting the position in a 2D plane, air time, and maximum height. 

## Code Under Test

Here is the Java code that we are testing:

```java
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
```

## Decision Table
**Decision table** testing is a testing technique used to test system behavior on different combinations of input values and to validate the system's handling of those combinations. This type of testing is beneficial when there are multiple inputs that can affect the system's behavior.

This testing focuses on the `calcPosition(double time)` method. This method takes time as an input and, along with the instance variables launchAngle, rotationAngle, and velocity, it calculates the position of the projectile.

| Test Case | launchAngle | rotationAngle | velocity | time | Expected Result | Actual Result|Pass|
|-----------|---------------|---------------|----------|------|-----------------|---------------|----|
| 1         | 45            | 0             | 10       | 1    | [7.06,0.0,0.0]m|  [7.06,0.0,0.0]m   |✔️|
| 2         | 45            | 90            | 10       | 1    | [0.0,7.06,0.0]m | [0.0,7.06,0.0]m   |✔️|
| 3         | 45            | 0             | 10       | 2    | [14.11,0.0,0.0]m | [14.11,0.0,0.0]m  |✔️|
| 4         | 45            | 90            | 10       | 2    | [0.0,14.11,0.0]m| [0.0,14.11,0.0]m   |✔️|

This **Decision Table** testing effectively verifies the `calcPosition(double time)` method's behavior under different input scenarios, and the method is seen to handle them correctly.
