# MVP 1

## Description
MVP 1 focuses on taking user inputs for height and angle and generates outputs of position in a 2D plane, air time, and maximum height.

## Class Methods
Several public methods are defined to perform various calculations:

- **calcLandingTime()**: Calculates and returns the total time the projectile is in the air.
- **calcVelocity()**: Calculates and returns the velocity of the projectile.
- **calcPosition()**: Calculates and returns the position of the projectile.
- **calcMaxHeight()**: Calculates and returns the maximum height reached by the projectile.

## Main Function
In the '**main**' function, user input is gathered for starting height and starting angle. An instance of '**HowitzerSimulator**' is created with these inputs, and calculations are performed for position, air time, and maximum height. The results are then printed to the console.

## Testing Methods
Our group chose **Data Flow Testing** to ensure the quality and correctness of the software. We have unit tests for each method within the HowitzerSimulator class, as well as tests to check if the methods are responsive to changes in angle and height, which are the primary user inputs.

### Data Flow Testing

```
@Test
    public void testAngleDataFlow() {
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

```

In the `testAngleDataFlow` method, three methods from the `HowitzerSimulator` class are being tested. Each of these methods should respond to changes in the `angle` attribute of a `HowitzerSimulator` instance.

Here's what each method does:

## setAngle()

This method is used to change the launch angle of the howitzer. In this test, the angle is set to 60 degrees.

```java
howitzerSimulator.setAngle(60); // changing the angle
```

## calcLandingTime()

This method calculates the time that the projectile is expected to be in the air given its launch parameters. Since these parameters are dependent on the angle, changes to the angle should result in different landing times.

```java
double actualTime = howitzerSimulator.calcLandingTime();
```

## calcPosition()

This method calculates the final position of the projectile, given its launch parameters. As with `calcLandingTime()`, changes to the launch angle should result in different final positions.

```java
double actualPosition = howitzerSimulator.calcPosition();
```

## calcMaxHeight()

This method calculates the maximum height that the projectile reaches during its flight. Since the height of the trajectory is dependent on the launch angle, different angles should result in different maximum heights.

```java
double actualMaxHeight = howitzerSimulator.calcMaxHeight();
```

For each of these methods, the `assertEquals` function is used to compare the expected output with the actual output. If these values match (within a certain tolerance), then the test passes. If they do not match, then the test fails and an error message is printed.

```java
assertEquals(expectedTime, actualTime, "The calculated landing time does not match the expected result");
assertEquals(expectedPosition, actualPosition, "The calculated position does not match the expected result");
assertEquals(expectedMaxHeight, actualMaxHeight, "The calculated max height does not match the expected result");
```




