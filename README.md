# Heat Calculator for Tanks

## Overview
This Java-based project features a heat calculation application for tanks. It supports different tank shapes, including cylindrical and cuboid, and calculates the required heat based on various parameters.

## Alternative Interface with JavaFX
For those interested in a graphical user interface, an alternative branch, **JavaFX_Interface**, is available. This branch enhances the application with a JavaFX-based UI, making it more interactive and user-friendly. Check out this branch for a different experience:
```
git checkout HeatCalculator4_2
```
or view it [here on GitHub](https://github.com/themane04/tank-application/tree/HeatCalculator4_2_2).

## Project Structure
The project is organized into several directories:

- **models**:
  - `CuboidTank.java` - Defines properties and behaviors of cuboid-shaped tanks.
  - `CylinderTank.java` - Defines properties and behaviors of cylindrical tanks.
  - `Tank.java` - Abstract base class for tank objects.
- **tests**:
  - `CuboidTankTest.java` - Unit tests for cuboid tanks.
  - `CylinderTankTest.java` - Unit tests for cylindrical tanks.
- **utils**:
  - `ErrorMessage.java` - Utility class for error messages.
  - `Style.java` - Utility class for application styling.
  - `HeatCalculatorApp.java` - Main application class that runs the heat calculator.

## Setup and Running the Application
To set up and run this application, follow these steps:

1. Ensure you have Java installed on your machine.
2. Clone the repository to your local machine.
```
git clone git@github.com:themane04/tank-application.git
```
4. Navigate to the `src` directory of the project.
5. Compile the Java files:
6. Run the application
