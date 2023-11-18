# Introduction
The developed application provides users with a control and monitoring module of a smart home.

This application streamlines the process of working with sensors, turning on or off elements such as light or gas, but also the possibility of being notified if someone enters the house or if there are gas leaks.

The user can define new sensors located in any room of the house and can define the times when he is at home and the times when he is away. Depending on the state of the house (whether someone is home or not), the house automatically turns off or on the gas and lights.

# Application description

The application allows multiple functionalities:

- The addition of sensors in any of the rooms of the home

- Real-time notification (in the console and saving the event in the database) of the user by the sensors if there are gas leaks or if the proximity sensor detects movement in the home.
  For the demonstration, two schedule methods were implemented. The first of them simulates that movement has been detected in the house every 5 seconds (simulates the appearance of an intruder), and the second schedule runs every 15 seconds and signals the existence of gas leaks.

- Auto-off or auto-on of gas and lights, depending on the state of the home – NoBodyHome, SomeBodyHome
  Depending on the state of the home (NoBodyHome, SomeBodyHome), functions are called that automatically turn off gas and lights or turn them on automatically.
  Two scheduled methods were created for the demonstration. Every day at 08:00 the house switches to the NoBodyHome state, and every day at 16:00 the house switches to the SomeBodyHome state.

### Visitor Pattern

To collect the information from the sensors, the Visitor Pattern was implemented.

The acceptVisitor method is overridden within each sensor and returns the details collected by that sensor.

Within the SensorGatherDataVisitor class, the behavior of each visited sensor is handled. For this purpose, a JSON message is created containing the details collected from the sensor and its type.

### Factory Pattern

The Factory Pattern provides a specialized interface for creating object types without specifying their concrete classes. Thus, this design pattern allows the creation of objects that follow a certain pattern.

In our case, Factory Pattern specializes in creating objects of type Message (the output sent by sensors) and type Sensor (for adding new sensors).

### Command Pattern

Command Pattern was used to implement the automatic turning on or off of lights and gas depending on the state of the house.

The Command Pattern involves encapsulating in a single object all the data needed to perform a certain action (command), including which method to call, the method's arguments, and the object to which the method belongs.

In our case, the Command interface is implemented inside the Commander controller, specialized in executing commands.

### Singleton Pattern

Singleton pattern is used in case of home state. Since we don't want to create a new object each time to represent the same home, the singleton design method ensures that the same object instance is used each time.

Also, in SpringBoot, any class annotated with Service/Controller/Repository represents a singleton because you want to use the same controller every time and not create new instances. In our case, LogsRepository and DataGatherer are also singletons.

### Observer Pattern

To implement the notification system, the Observer Pattern was used. Sensor classes implement the Observer interface and define how objects interpret a message received from the object they are observing. In our case, the sensors track gas leaks, if someone is in the house, etc (within the DataGatherer class). If positive, the sensor is notified and it notifies the client in the console and saves the event in the database.

### State Pattern

To implement the automatic shut off/on system of gas and lights whether the customer is home or not, State Pattern was used.

Automatically, at 08:00, the house switches to NoBodyHome mode. In this case, the gas and light shutdown commands are called.

At 16:00, with the help of the schedule method, the house automatically switches to the SomeBodyHome state. In this sense, the commands that turn on the gas and lights are automatically called.

For example, in the main method, the home state was passed to the NoBodyHome mode. Thus the lights and gases were automatically turned off.

# Database

Database connection (H2):

```console
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- username: `sa`
- password: `password`
