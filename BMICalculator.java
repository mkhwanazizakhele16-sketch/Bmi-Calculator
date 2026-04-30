import java.util.Scanner;
import java.util.Locale;

public class BMICalculator {

    public static final int Metric = 1;
    public static final int Imperial = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        char repeat;

        do {
            System.out.print("Enter your name: ");
            String name = scanner.next();

            System.out.print("Enter your surname: ");
            String surname = scanner.next();

            int age = (int) getValidInput(scanner, "Enter your age: ", 1, 120);

            int unitChoice = getUnitChoice(scanner);

            double weight = (unitChoice == Metric)
                    ? getValidInput(scanner, "Enter your weight in kilograms: ", 10, 600)
                    : getValidInput(scanner, "Enter your weight in pounds: ", 22, 1300);

            double height = (unitChoice == Metric)
                    ? getValidInput(scanner, "Enter your height in metres: ", 0.5, 2.5)
                    : getValidInput(scanner, "Enter your height in inches: ", 20, 100);

            double bmi = calculateBMI(unitChoice, weight, height);
            String category = getBMICategory(bmi);
            String advice = getHealthAdvice(category);

            System.out.println("===== BMI REPORT =====");
            System.out.println("Name      : " + name + " " + surname);
            System.out.println("Age       : " + age);
            System.out.printf("BMI       : %.2f%n", bmi);
            System.out.println("Category  : " + category);
            System.out.println("Advice    : " + advice);
            System.out.println("======================");

            repeat = getRepeatChoice(scanner);

        } while (repeat == 'Y' || repeat == 'y');

        System.out.println("Thank you for using the BMI Calculator.");
        scanner.close();
    }

    public static int getUnitChoice(Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("Select your preferred unit system:");
            System.out.println("1. Metric (kg, m)");
            System.out.println("2. Imperial (lbs, in)");
            System.out.print("Enter 1 or 2: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();

                if (choice == Metric || choice == Imperial) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static double getValidInput(Scanner scanner, String prompt, double min, double max) {
        double value;

        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();

                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Enter value between %.2f and %.2f%n", min, max);
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
    }

    public static double calculateBMI(int unitChoice, double weight, double height) {
        return (unitChoice == Metric)
                ? weight / (height * height)
                : (703 * weight) / (height * height);
    }

    public static String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static String getHealthAdvice(String category) {
        switch (category) {
            case "Underweight":
                return "Consider eating a balanced diet and consulting a healthcare provider.";
            case "Normal weight":
                return "Great job! Maintain your healthy lifestyle.";
            case "Overweight":
                return "Try regular exercise and a balanced diet to manage your weight.";
            case "Obese":
                return "It is advisable to consult a healthcare provider for guidance.";
            default:
                return "";
        }
    }

    public static char getRepeatChoice(Scanner scanner) {
        System.out.print("\nWould you like to calculate again? (Y/N): ");
        return scanner.next().charAt(0);
    }
}