# MVP 3 TESTING
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

## Equivalence Class Testing
For Equivalence Class Testing we looked at the horizontal acceleration and made sure that we added a precondition on the time to ensure time could never be negative. We tested a few negative values, zero and positive values. 

**large negative value**
```
assert(howSim.calcHorizontalAcceleration(-1) == 0);
```

**large negative value**
```
assert(howSim.calcHorizontalAcceleration(-0.01) == 0);
```

** Zero**
```
assert(howSim.calcHorizontalAcceleration(0) == 0.1220799060460304);
```

** Positive value**
```
assert(howSim.calcHorizontalAcceleration(.6) == 0.12268984803657863);
```

##Decision Table Testing 
For this we tested calcPosition as it has values that can change a lot compared to the horizontal acceleration function. 
the table can be found in our graphs folder. 

##Path testing 
We used the horizontal acceleration function and tested all paths depicted in the graph.

```
assert(howSim.calcHorizontalAcceleration(-0.01) == 0);
```

```
assert(howSim.calcHorizontalAcceleration(0) == 1.0376792013912586);
```

```
assert(howSim.calcHorizontalAcceleration(.6) == 1.0428637083109185);
```

##Integration Testing
Integration we looked at all the functions by using the range and position functions as they call all the supporting functions for calculating and displaying the results. 

The graph can be found in the graph folder.

##System Testing
System testing we used an FSM diagram and then visually looked for specific console outputs to ensure the proper order was being followed. 

the graph can be found in the graphs folder.


## Testing Graph and Diagram
Please explore the following links to view the testing graph and diagram:
[Graphs/Diagrams Folder](https://gitlab.com/sseboys/ense375-project/-/tree/mvpThree/GraphDiagram)


