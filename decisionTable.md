# Decision Table

This testing focuses on the `calcPosition(double time)` method. This method takes time as an input and, along with the instance variables launchAngle, rotationAngle, and velocity, it calculates the position of the projectile.

| Test Case | launchAngle | rotationAngle | velocity | time | Expected Result | Actual Result|Pass|
|-----------|---------------|---------------|----------|------|-----------------|---------------|----|
| 1         | 45            | 0             | 10       | 1    | Position is [7.06,0.0,0.0]m|     |✔️|
| 2         | 45            | 90            | 10       | 1    | Position is [0.0,7.06,0.0]m |    |✔️|
| 3         | 45            | 0             | 10       | 2    | Position is [14.11,0.0,0.0]m |   |✔️|
| 4         | 45            | 90            | 10       | 2    | Position is [0.0,14.11,0.0]m|    |✔️|