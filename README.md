# Race Project in Java

Welcome to the Race Project in Java! This thrilling project simulates racers competing in various arenas, including land, aerial, and naval arenas. Each racer is represented as a separate thread with a `run()` function that moves the racer's position. The project uses design patterns like Prototype, Builder, Observer, and State to enhance functionality and maintainability. Additionally, a graphical user interface (GUI) provides real-time visualization of the racers' movements, and a side panel allows you to interact with the project easily.

<img width="1066" alt="main image" src="https://github.com/Daniel-Arvili/Race-Project/assets/116496118/29ec1965-f6f2-46c1-b391-624ef5284ca5">


## Getting Started

To run the Race Project, ensure you have the following installed:

1. Java Development Kit (JDK): The latest version of JDK installed on your machine.

2. Java IDE: A Java Integrated Development Environment (IDE) such as Eclipse or IntelliJ for ease of development and execution.

## Project Structure

The project consists of the following components:

1. `Racer` abstract class: Represents the common behavior of all racers. It implements the Prototype design pattern with a `clone()` function to copy other racers easily.

2. Concrete racer classes: Extend the `Racer` abstract class to define the behavior of individual racers. We have classes for car, bike, horse, helicopter, airplane, rowboat, and speedboat.

3. `Arena` abstract class: Represents the generic arena where racers compete. It is an observer, and the races are observable.

4. Concrete arena classes: Extend the `Arena` abstract class to represent specific arenas (land, aerial, and naval) where racers compete based on their types. Each arena contains methods to add racers, build the arena, and start the race. The project uses the Factory Method design pattern to create several arenas by entering a string.

5. `RaceGUI` class: Provides the graphical user interface to interact with the project. It displays the live movement of the racers and features a side panel with buttons to build arenas, add racers, and start races.

6. `Main` class: Contains the `main()` method to run the application.

## Display

### Arena with Racers

<img width="1187" alt="bedore race" src="https://github.com/Daniel-Arvili/Race-Project/assets/116496118/1dff53b6-10a5-4680-b30c-3ef480c50e21">
In this section, we provide images of the arena with racers before the race starts. The racers are positioned and ready to compete in their respective arenas. The excitement is building up as they await the signal to start the race!

### Mid-Race Action

<img width="1193" alt="mid race" src="https://github.com/Daniel-Arvili/Race-Project/assets/116496118/85d5e331-0b48-4c7e-9216-38becd9ffd66">
This image captures the thrilling mid-race action as the racers compete fiercely to gain the lead. You can see the racers in full motion, vying for the top positions.


### Race Results

<img width="1194" alt="afer race" src="https://github.com/Daniel-Arvili/Race-Project/assets/116496118/d5cc66f5-f113-4677-85ae-febf4339e0e6">
The race results are displayed in a table format, summarizing the performance of each racer during the entire race. The table provides information about each racer's position, the arena they competed in, and their final standings. It allows you to easily compare the results and determine the top performers.

Feel free to check out the images and witness the excitement of the race from start to finish!



## How to Use

1. Clone the project from the repository:

   ```
   git clone <repository-url>
   ```

2. Open the project in your favorite Java IDE (e.g., Eclipse, IntelliJ).

3. Go to the `Main` class and execute the `main()` method to start the application.

4. The GUI will open, displaying the live movements of racers in their respective arenas.

5. Use the side panel buttons to interact with the project:
    - Click the "Add Racer" button to add racers to the arenas. Choose the type of racer (car, bike, horse, helicopter, airplane, rowboat, speedboat) and provide a name for the racer.
    - Click the "Build Arena" button to prepare the race track for each arena.
    - Click the "Build Race" button to set up the race with the racers in their respective arenas.

6. Enjoy watching the racers move and compete in real-time!

## Design Patterns Used

- **Prototype Pattern:** The `Racer` abstract class implements the Prototype design pattern, allowing you to create new racers by cloning existing racers. This approach simplifies the process of adding new racers with similar properties.

- **Builder Pattern:** The `QuickCarRaceBuilder` class provides a builder for quickly setting up a car race with predefined car racers. It encapsulates the construction process and enables the creation of complex racer configurations with ease.

- **Observer Pattern:** The `Arena` abstract class is an observer, and the races are observable. This pattern allows the GUI to receive updates and display the live movements of the racers in real-time.

- **State Pattern:** The `RaceState` interface represents the state of each racer, allowing you to add specific states and behaviors. The state field in each racer determines their results during the race.

- **Factory Method Pattern:** The concrete arena classes implement the Factory Method design pattern, allowing you to create several arenas by entering a string representing the type of arena (e.g., "Land", "Aerial", "Naval").

