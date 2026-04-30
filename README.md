# BMI Calculator (Java)

## Overview

This is a simple **command-line BMI (Body Mass Index) Calculator** written in Java. It allows users to input their personal details and calculate their BMI using either the **Metric** or **Imperial** system. The program also provides a BMI category and basic health advice based on the result.

---

## Features

* Accepts user details (name, surname, age)
* Supports two unit systems:

  * Metric (kilograms, meters)
  * Imperial (pounds, inches)
* Validates all user inputs to ensure accuracy
* Calculates BMI using the correct formula
* Displays:

  * BMI value
  * BMI category
  * Health advice
* Allows repeated calculations in a loop

---

## How It Works

### 1. User Input

The program prompts the user to enter:

* Name and surname
* Age (validated between 1 and 120)
* Preferred unit system
* Weight and height (validated within realistic ranges)

### 2. BMI Calculation

* **Metric formula**:
  `BMI = weight (kg) / height² (m²)`

* **Imperial formula**:
  `BMI = (703 × weight (lbs)) / height² (in²)`

### 3. BMI Categories

| BMI Range   | Category      |
| ----------- | ------------- |
| < 18.5      | Underweight   |
| 18.5 – 24.9 | Normal weight |
| 25 – 29.9   | Overweight    |
| ≥ 30        | Obese         |

### 4. Health Advice

Each category provides a simple recommendation:

* **Underweight**: Improve diet and consult a professional
* **Normal weight**: Maintain current lifestyle
* **Overweight**: Increase exercise and improve diet
* **Obese**: Seek medical guidance

---

## Input Validation

The program ensures:

* Only numeric values are accepted where required
* Values fall within realistic ranges:

  * Age: 1–120
  * Weight (kg): 10–600
  * Weight (lbs): 22–1300
  * Height (m): 0.5–2.5
  * Height (in): 20–100
* Invalid inputs prompt the user to re-enter data

---

## Program Flow

1. Start program
2. Collect user details
3. Choose unit system
4. Enter weight and height
5. Calculate BMI
6. Display report
7. Ask user if they want to repeat
8. Exit when user selects "N"

---

## Example Output

```
===== BMI REPORT =====
Name      : John Doe
Age       : 25
BMI       : 22.86
Category  : Normal weight
Advice    : Great job! Maintain your healthy lifestyle.
======================
```

---

## Requirements

* Java Development Kit (JDK) 8 or higher

---

## How to Run

1. Compile the program:

```
javac BMICalculator.java
```

2. Run the program:

```
java BMICalculator
```

---

## Code Structure

* `main()` – Controls program flow
* `getUnitChoice()` – Handles unit system selection
* `getValidInput()` – Validates numeric input
* `calculateBMI()` – Computes BMI
* `getBMICategory()` – Determines BMI category
* `getHealthAdvice()` – Provides recommendations
* `getRepeatChoice()` – Handles loop continuation

---

## Notes

* The program uses `Scanner` for input handling.
* Locale is set to US to ensure proper decimal handling.
* Designed for educational purposes and basic health awareness.

---

## Future Improvements

* Add GUI (JavaFX or Swing)
* Store user history
* Provide more detailed health insights
* Support additional measurement units

---

## License

This project is open-source and free to use for educational purposes.
