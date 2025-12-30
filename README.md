# MultiCalculator

MultiCalculator is a simple Java console program that provides a small collection of physics- and optimization-related utilities. The program presents a menu with four calculators:

- Falling distance under gravity
- Kinetic energy
- Wind chill index
- Optimal dimensions for a box formed from a flat rectangular cardboard (by cutting squares from corners)

The program is intended for educational purposes (individual assignment) and demonstrates use of methods, loops, basic validation, and console I/O.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Files](#files)
- [Compilation and Running](#compilation-and-running)
- [Program Usage](#program-usage)
- [Method Details and Formulas](#method-details-and-formulas)
- [Input Constraints and Notes](#input-constraints-and-notes)
- [Example Session](#example-session)
- [Possible Improvements](#possible-improvements)
- [Author](#author)
- [License](#license)

## Features

- Menu-driven console interface
- Computes:
  - Falling distance (s = 1/2 g t^2)
  - Kinetic energy (KE = 1/2 m v^2)
  - Wind chill index (valid for T <= 10 °C)
  - Optimal box volume and cut size for a given flat cardboard area (search-based approach)

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal / command prompt

## Files

- `MultiCalculator.java` — main program source file

## Compilation and Running

1. Save `MultiCalculator.java` to a directory.
2. Open a terminal and change to that directory.
3. Compile:
   ```
   javac MultiCalculator.java
   ```
4. Run:
   ```
   java MultiCalculator
   ```

The program will display a menu. Enter the number of the option you want, then follow prompts for inputs.

## Program Usage

On start the program shows this menu:

1. Calculate Falling Distance  
2. Calculate Kinetic Energy  
3. Calculate WindChill  
4. Calculate Optimal Box Dimensions from Flat Cardboard  
5. Exit

After selecting an option, you will be prompted for the required inputs (for example, time in seconds for falling distance). After each calculation the program asks whether you want to perform another calculation.

### Example inputs

- Falling distance: time in seconds (double)
- Kinetic energy: mass in kilograms (double), velocity in m/s (double)
- Wind chill: temperature in °C (must be <= 10), wind speed in m/s (double)
- Box optimization: area of flat cardboard (double)

## Method Details and Formulas

- calculateFallingDistance(time)
  - Formula: s = 1/2 * g * t^2, where g = 9.8 m/s^2
  - Returns falling distance in meters (given time in seconds)

- calculateKineticEnergy(mass, velocity)
  - Formula: KE = 1/2 * m * v^2
  - Returns energy in joules (mass in kg, velocity in m/s)

- calculateWindChill(temperature, windSpeed)
  - Uses the formula implemented in the program and enforces temperature <= 10 °C
  - Throws IllegalArgumentException if temperature > 10

- findOptimalBoxDimensions(area)
  - Given a flat rectangle of area A = L * W, the code loops over possible L values (from 0.1 up to A, step 0.1), computes W = A / L, then searches for the best cut size x (from 0.01 to min(L/2, W/2), step 0.01) that maximizes box volume:
    - volume = x * (L - 2x) * (W - 2x)
  - Prints the optimal L, W, x and the maximum volume found

## Input Constraints and Notes

- Units must be consistent:
  - Falling distance uses SI units (seconds → meters)
  - Kinetic energy expects kilograms and meters/second
  - Wind speed is expected in meters/second and temperature in °C
  - For the box optimization: the area is treated as "square units" and the computed L, W, x and volume will be in corresponding linear/volume units. The prompt in the code says "square inches", but any consistent square unit is acceptable — results will be in corresponding units (inches, meters, etc.). Prefer using SI units or clearly-document the intended units before input.
- Wind chill is only computed for temperatures <= 10 °C (the program throws an exception otherwise).
- The box optimization uses a brute-force search with fixed step sizes (0.1 for L and 0.01 for x). This is simple but not precise — finer steps produce more accurate results at the cost of performance.

## Example Session

An example interaction (user input after prompts is shown in square brackets):

```
Choose an option:
1. Calculate Falling Distance
2. Calculate Kinetic Energy
3. Calculate WindChill
4. Calculate Optimal Box Dimensions from Flat Cardboard
5. Exit
[1]
Enter the time in seconds:
[2]
The falling distance is: 19.6 meters.

Do you want to perform another calculation? (yes/no)
[no]
Program ended.
```

## Possible Improvements

- Replace brute-force search for optimal box dimensions with an analytic approach or optimization routine to improve precision and performance.
- Add input validation for non-numeric input.
- Allow different units or clarify units in all prompts.
- Add command-line arguments for batch calculations or test mode.
- Write unit tests for each method.

## Author

- alyakhay28 (student submission / individual assignment)

## License

This project is provided for educational purposes. Feel free to reuse or adapt the code for learning and improvement. If you publish or share derivative work, include appropriate attribution.
