# Fuel Efficiency Calculator (JavaFX)

A versatile Graphical User Interface (GUI) application built with **JavaFX** that calculates fuel efficiency. It features a dynamic toggle system to switch between US Imperial and Metric measurement systems.

## Preview
--
<img width="391" height="272" alt="Screenshot 2026-05-12 at 12 02 37 PM" src="https://github.com/user-attachments/assets/25eb66ca-ac78-4167-8156-a4a4c4b817cd" />
---

## ⛽ Features
*   **Dual Calculation Modes:** 
    *   **MPG:** Miles per Gallon (US Standard).
    *   **L/100KM:** Liters per 100 Kilometers (International Metric).
*   **Dynamic UI Labels:** Using `RadioButtons` and a `ToggleGroup`, the interface automatically updates text labels (e.g., changing "Miles" to "Kilometers") based on the selected mode.
*   **Precision Output:** Results are automatically formatted to two decimal places for clarity.
*   **Reset Functionality:** A dedicated reset button clears all inputs and resets the display to zero.
*   **Safety Features:** The result field is set to **read-only** to prevent manual tampering with calculations.

## 🧮 Calculation Logic
The app uses two distinct formulas depending on the selected mode:

1.  **Imperial Mode:** 
    $$result = \frac{\text{miles}}{\text{gallons}}$$
2.  **Metric Mode:** 
    $$result = \frac{\text{liters}}{(\frac{\text{kilometers}}{100})}$$

## 🛠️ Technical Components
*   **Layout:** `GridPane` for precise alignment of labels, text fields, and buttons.
*   **Event Handling:** 
    *   Lambda expressions are used to handle button clicks and "Enter" key presses within text fields.
    *   `ToggleGroup` ensures that only one measurement system can be active at a time.
*   **Input Validation:** Checks for null or empty strings before attempting numeric parsing to prevent application crashes.

## 📂 Files
*   `MPGGUI.java`: Main application class containing the UI layout and calculation methods.

## ⚙️ How to Run
1.  **Compile:**
    ```bash
    javac --module-path /path/to/javafx/lib --add-modules javafx.controls MPGGUI.java
    ```
2.  **Run:**
    ```bash
    java --module-path /path/to/javafx/lib --add-modules javafx.controls MPGGUI
    ```

---

**Author:** [Tyrone Darby](https://github.com/tyronedarby)  
**Class:** CSCI 1302  
**Topic:** Lab 10 - JavaFX Event Handling
