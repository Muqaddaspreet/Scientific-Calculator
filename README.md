# Scientific Calculator

This project provides a graphical user interface (GUI) for calculating the arccosine of a number. The application includes fields for user input, a button to perform the calculation, and labels to display the results and any errors. The project also includes unit tests for the arccosine calculation methods.

## Features

- Calculate the arccosine of a number between -1 and 1.
- Displays results in a user-friendly GUI.
- Handles invalid input with error messages.
- Includes unit tests to ensure calculation accuracy.

## Requirements

- Java 11 or higher
- Maven
- Git
- JUnit 5

## Setup

1. **Clone the repository:**

   ```
   git clone https://github.com/Muqaddaspreet/Scientific-Calculator.git
   cd Scientific-Calculator
   
2. **Open the project in IntelliJ IDEA:**

- Open IntelliJ IDEA.
- Select File > Open.
- Navigate to the project directory and select it.
- IntelliJ will detect the Maven project and import it accordingly.

3. **Build the project using Maven:**

   ```
   mvn clean install

## Usage

1. **Run the application:**

- Open IntelliJ IDEA.
- Navigate to src/main/java/calculator/ScientificCalculatorGUI.java.
- Right-click on the file and select Run 'ScientificCalculatorGUI.main()'.
   
2. **Calculate Arccosine:**

- Enter a value between -1 and 1 in the input field.
- Click the "Calculate" button.
- The result will be displayed below the button.

## Running Tests

1. **Run the unit tests using Maven:**

   ```
   mvn test

2. **Run the unit tests using IntelliJ IDEA:**

- Navigate to src/test/java/calculator/ArccosCalculatorTest.java.
- Right-click on the file and select Run 'ArccosCalculatorTest'.

## Project Structure

   ```
   my-maven-project
   |-- pom.xml
   |-- src
   |   |-- main
   |   |   |-- java
   |   |       |-- calculator
   |   |           |-- ArccosCalculator.java
   |   |           |-- ScientificCalculatorGUI.java
   |   |-- test
   |       |-- java
   |           |-- calculator
   |               |-- ArccosCalculatorTest.java
   ```
 
## Contributing

Contributions are welcome! Please follow these steps to contribute:

- Fork the repository.
- Create a new branch: git checkout -b feature/your-feature.
- Make your changes and commit them: git commit -m 'Add some feature'.
- Push to the branch: git push origin feature/your-feature.
- Open a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Acknowledgements
- JUnit 5
- Maven
- IntelliJ IDEA
