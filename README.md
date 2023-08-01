
# MVP 3
In this stage of the project, further testing is performed on the `HowitzerSimulator` class, with a focus on the `calcHorizontalAcceleration` method. Ensuring the accuracy and consistency of this method is crucial, as it calculates the horizontal acceleration of the simulated projectile at any given time during its trajectory, which in turn, affects many other aspects of the simulation.

## Unit Testing: Boundary Value Testing
Boundary Value testing is used to check that the `calcHorizontalAcceleration` method returns the expected results under a range of conditions. A test instance of `HowitzerSimulator` is created with predefined parameters, then several assertions are performed:

**Minimum Test**: This test checks the horizontal acceleration at the start of the trajectory (t=0). The assertion verifies that the method returns the expected value.
```java
assert(howSim.calcHorizontalAcceleration(0) == 0.1220799060460304);
```

**Nominal Test**: This test checks the horizontal acceleration at an arbitrary point during the trajectory (t=0.6). The assertion verifies that the method returns the expected value.
```java
assert(howSim.calcHorizontalAcceleration(.6) == 0.12268984803657863);
```

**Maximum Test**: This test checks the horizontal acceleration at the end of the trajectory (t=howSim.airTime). The assertion verifies that the method returns the expected value.
```java
assert(howSim.calcHorizontalAcceleration(howSim.airTime) == 0.1220799060460304);
```

These boundary tests ensure that the `calcHorizontalAcceleration` method behaves as expected not only within the normal flight time range, but also at the edge cases. It provides a robust evaluation of the `HowitzerSimulator` and its capacity to correctly simulate the horizontal acceleration of the projectile under all expected conditions.

## DU-Pair Graph
![DU-Pair Graph](https://gitlab.com/sseboys/ense375-project/-/raw/mvpThree/DU_Pair_Graph.png?ref_type=heads)



## Path Flow Diagram
![Path Flow Diagram](https://gitlab.com/sseboys/ense375-project/-/raw/mvpThree/Path_flow_diagram.png?ref_type=heads)


