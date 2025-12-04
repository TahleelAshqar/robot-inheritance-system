# Robot Inheritance System
Java implementation of a simple robot hierarchy used to practice inheritance and method overriding.

## Classes
- `Robot`
  - Fields: name, positionX, positionY, facing (NORTH/EAST/SOUTH/WEST)
  - Methods: constructors, `move()`, `turnLeft()`, getters, `toString()`

- `SpecialRobot` (extends `Robot`)
  - Adds: `turnRight()` to rotate 90° clockwise

- `MoreSpecialRobot` (extends `SpecialRobot`)
  - Adds: `battery` field (0–100%)
  - Overrides: `move()` to consume 1% battery per movement
  - Overrides: `toString()` to display battery percentage

## Concepts
- Inheritance
- Method overriding
- Encapsulation (all fields are `private`)
- Basic movement logic on a 2D grid
