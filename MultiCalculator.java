//INDIVIDUAL ASSIGNMENT: A

import java.util.Scanner;

public class MultiCalculator {
    
    //Question (a)
    // Method to calculate falling distance
    // Method Type: Processor
    public static double calculateFallingDistance(double time) {
        final double g = 9.8; // gravity constant in m/s^2
        return 0.5 * g * time * time; // Calculate and return the falling distance using the formula
    }
    
    //Question (b)
    // Method to calculate kinetic energy
    // Method Type: Processor
    public static double calculateKineticEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity; // Calculate and return the kinetic energy using the formula
    }
    
    //Question (c)
    // Method to calculate windchill index
    // Method Type: Processor
    public static double calculateWindChill(double temperature, double windSpeed) {
        if (temperature <= 10) { // Check if temperature is within the allowed range
            return 13.12 + (0.16215 * temperature) - (11.37 * Math.pow(windSpeed, 0.16)) +
                    (0.3965 * temperature * Math.pow(windSpeed, 0.16)); // Calculate and return windchill index
        } else {
            throw new IllegalArgumentException("Temperature should be 10 degrees Celsius or lower."); // Throw an exception for invalid temperature
        }
    }
    
    //Question (d)
    // Method to find the optimal dimensions of a flat cardboard box
    // Method Type: Processor
    public static void findOptimalBoxDimensions(double area) {
        double maxVolume = 0.0;
        double optimalX = 0.0;
        double optimalL = 0.0;
        double optimalW = 0.0;

        // Loop through possible lengths and widths to find optimal dimensions
        for (double L = 0.1; L <= area; L += 0.1) {
            double W = area / L;

            for (double x = 0.01; x <= L / 2 && x <= W / 2; x += 0.01) {
                double volume = x * (L - 2 * x) * (W - 2 * x);
                if (volume > maxVolume) {
                    maxVolume = volume;
                    optimalX = x;
                    optimalL = L;
                    optimalW = W;
                }
            }
        }

        // Print the optimal dimensions and maximum volume
        System.out.println("Optimal Length (L): " + optimalL);
        System.out.println("Optimal Width (W): " + optimalW);
        System.out.println("Optimal Side of the square to cut (x): " + optimalX);
        System.out.println("Maximum Volume: " + maxVolume);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        // Loop to continue or end the program based on user input
        while (continueProgram) {
            // Display menu options
            System.out.println("Choose an option:");
            System.out.println("1. Calculate Falling Distance");
            System.out.println("2. Calculate Kinetic Energy");
            System.out.println("3. Calculate WindChill");
            System.out.println("4. Calculate Optimal Box Dimensions from Flat Cardboard");
            System.out.println("5. Exit");
            int choice = scanner.nextInt(); // Get user choice

            switch (choice) {
                case 1:
                    // Calculate and display falling distance
                    System.out.println("Enter the time in seconds:");
                    double time = scanner.nextDouble();
                    double distance = calculateFallingDistance(time);
                    System.out.println("The falling distance is: " + distance + " meters.");
                    break;

                case 2:
                    // Calculate and display kinetic energy
                    System.out.println("Enter the mass in kilograms:");
                    double mass = scanner.nextDouble();
                    System.out.println("Enter the velocity in meters per second:");
                    double velocity = scanner.nextDouble();
                    double kineticEnergy = calculateKineticEnergy(mass, velocity);
                    System.out.println("The kinetic energy is: " + kineticEnergy + " joules.");
                    break;

                case 3:
                    try {
                        // Calculate and display windchill index
                        System.out.println("Enter the temperature in degrees Celsius (T <= 10):");
                        double temperature = scanner.nextDouble();
                        System.out.println("Enter the wind speed in meters per second:");
                        double windSpeed = scanner.nextDouble();
                        double windChill = calculateWindChill(temperature, windSpeed);
                        System.out.println("The windchill index is: " + windChill + " degrees Celsius.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // Handle invalid temperature
                    }
                    break;

                case 4:
                    // Calculate and display optimal box dimensions
                    System.out.println("Enter the area of the flat cardboard in square inches:");
                    double area = scanner.nextDouble();
                    findOptimalBoxDimensions(area);
                    break;

                case 5:
                    continueProgram = false; // End the program
                    break;

                default:
                    System.out.println("Invalid option. Please choose again."); // Handle invalid choice
                    break;
            }

            // Ask user if they want to perform another calculation
            if (continueProgram) {
                System.out.println("Do you want to perform another calculation? (yes/no)");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("yes")) {
                    continueProgram = false; // End the program if user does not want to continue
                }
            }
        }

        System.out.println("Program ended."); // Display program end message
        scanner.close(); // Close scanner
    }
}
