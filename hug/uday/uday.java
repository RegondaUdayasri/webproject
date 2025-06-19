import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame implements ActionListener {
    private JLabel weightLabel, heightLabel, bmiLabel, categoryLabel;
    private JTextField weightField, heightField, bmiField, categoryField;
    private JButton calculateButton;

    public BMICalculator() {
        // Set up the frame
        setTitle("BMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Create components
        weightLabel = new JLabel("Weight (kg): ");
        heightLabel = new JLabel("Height (cm): ");
        bmiLabel = new JLabel("BMI: ");
        categoryLabel = new JLabel("Category: ");
        weightField = new JTextField();
        heightField = new JTextField();
        bmiField = new JTextField();
        bmiField.setEditable(false);
        categoryField = new JTextField();
        categoryField.setEditable(false);
        calculateButton = new JButton("Calculate");

        // Add components to the frame
        add(weightLabel);
        add(weightField);
        add(heightLabel);
        add(heightField);
        add(bmiLabel);
        add(bmiField);
        add(categoryLabel);
        add(categoryField);
        add(new JLabel()); // Empty cell in the grid
        add(calculateButton);

        // Add action listener to the button
        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Read input values
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100; // Convert cm to meters

            // Calculate BMI
            double bmi = weight / (height * height);
            bmiField.setText(String.format("%.2f", bmi));

            // Determine weight category
            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                category = "Normal weight";
            } else if (bmi >= 25 && bmi < 29.9) {
                category = "Overweight";
            } else {
                category = "Obese";
            }
            categoryField.setText(category);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for weight and height.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMICalculator calculator = new BMICalculator();
            calculator.setVisible(true);
        });
    }
}