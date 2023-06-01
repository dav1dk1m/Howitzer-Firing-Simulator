# Problem Specification

## Objective
Develop a Howitzer Firing Simulator to teach soldiers about the kinematics and dynamics involved in firing a howitzer projectile across an empty field.

## Simulator Variables
- Barrel pose (position and orientation): Control the position and orientation of the howitzer barrel.
- Initial speed: Set the initial velocity of the projectile.
- Force applied to the projectile: Control any external forces acting on the projectile.
Gravity: Account for the acceleration due to gravity.

### Projectile properties:

- Radius and mass: Define the size and weight of the projectile.
- Drag coefficient (C): Determine the resistance to motion through the fluid.

## Rigid Body Kinematics and Dynamics:


f_{\text{d}}(t) = -\frac{1}{2}C\rho A u(t)^2
