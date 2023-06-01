# Problem Specification

## Objective
Develop a Howitzer Firing Simulator to teach soldiers about the kinematics and dynamics involved in firing a howitzer projectile across an empty field.

## Simulator Variables
- Barrel pose (position and orientation): Control the position and orientation of the howitzer barrel.
- Initial speed: Set the initial velocity of the projectile.
- Force applied to the projectile: Control any external forces acting on the projectile.
- Gravity: Account for the acceleration due to gravity.


## Rigid Body Kinematics and Dynamics:
The simulator should model the rigid body kinematics and dynamics of the projectile according to the following equations:

The inertial frame expresses the rigid body kinematics and dynamics of any object.

```
p(t) = v(t)

mv(t) = f(t) + f_d(t) + mg 
```
- _m_ is the Mass of the projectile.
- _p_ is the position of the projectile
- _v_ is the linear velocity of the projectile
- _g_ is the acceleration due to gravity
- _f_  is the external force acting on the object
- f_d is the drag force acting on the projcet

In fluid dynamics, the drag force is, 

```
f_d(t) = -0.5C𝜌Au(t)^2
```
- Drag coefficient (C): Determine the resistance to motion through the fluid.
- 𝜌 is the density of the fluid
- _A_ is the area of the projectile facing the fluid
- _u_ is the flow velocity relative to the projectile

## Software 

### Simulator Development:
The simulator should be developed using the Java programming language.

### Source Code Management:
GitLab will be used for source code management.

### Testing Techniques:
Our group is still in the process of learning about testing techniques. Once we have completed our planning and design phase, we will test it using the following techniques:
- Boundary Value Testing
- Equivalence Class Testing
- Decision Table-based Testing
- Path Testing
- Data Flow Testing
- Slice Testing

## Project Schedule 

Based on the specified delivery date of the day before the final exam at midnight on August 02, 2023, the project schedule will be adjusted accordingly.
