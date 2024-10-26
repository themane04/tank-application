# Heat Calculator for Tanks with JavaFX Interface

## Overview
This branch extends the basic heat calculator application by introducing a graphical user interface built with JavaFX. It enhances user interaction through a more intuitive and visually appealing interface.

## Project Structure
The project is structured with the following key components:

- **controllers**:
  - `TankController.java` - Manages the user inputs and interactions for the application.
- **interfaces**:
  - `ControllerViewInterface.java` - Defines the contract for controller and view interaction.
  - `TankModel.java` - Interface for tank models.
- **models**:
  - `CuboidTank.java`, `CylinderTank.java`, and `Property.java` - Define the properties and behaviors of tank objects.
  - `Tank.java` - Abstract base class for tank objects.
- **views**:
  - `AlternativeTankView.java` and `TankView.java` - Provide different views for the application.
  - `TankApplication.java` - The main entry point for the JavaFX application.

## Setup and Running the Application

To set up and run this JavaFX-enabled version of the application, follow these steps:

1. Ensure you have JavaFX installed and configured on your machine. JavaFX is required to run the graphical interface.
2. Clone the repository and switch to this branch:
```
git clone git@github.com:themane04/tank-application.git
```
3. Compile the Java files including JavaFX components.
4. Run the application with the JavaFX runtime:
