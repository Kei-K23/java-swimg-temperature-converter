import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static void tempConverter() {
        // Create new frame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        // Temperature label and text field
        JLabel label = new JLabel("Temperature:");
        label.setBounds(20, 20, 100, 25);
        panel.add(label);

        JTextField textField = new JTextField("0.00");
        textField.setBounds(130, 20, 100, 25);
        panel.add(textField);

        // Result text field
        JTextField resultField = new JTextField("0.00");
        resultField.setEditable(false);
        resultField.setBounds(240, 20, 100, 25);
        panel.add(resultField);

        // Buttons
        JButton button1 = new JButton("Celsius to Fahrenheit");
        JButton button2 = new JButton("Fahrenheit to Celsius");
        JButton button3 = new JButton("Celsius to Kelvin");
        JButton button4 = new JButton("Kelvin to Celsius");
        JButton button5 = new JButton("Fahrenheit to Kelvin");
        JButton button6 = new JButton("Kelvin to Fahrenheit");
        JButton exit = new JButton("Exit");
        JButton clear = new JButton("Clear");

        JButton[] buttons = { button1, button2, button3, button4, button5, button6, exit, clear };
        int y = 60;
        for (JButton button : buttons) {
            button.setBounds(20, y, 320, 25);
            panel.add(button);
            y += 35;
        }

        // Action Listeners for conversion buttons
        button1.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = celsiusToFahrenheit(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        button2.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = fahrenheitToCelsius(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        button3.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = celsiusToKelvin(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        button4.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = kelvinToCelsius(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        button5.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = fahrenheitToKelvin(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        button6.addActionListener(e -> {
            double temp = Double.parseDouble(textField.getText());
            double resTemp = kelvinToFahrenheit(temp);
            resultField.setText(String.valueOf(resTemp));
        });

        // Action Listener for Exit button
        exit.addActionListener(e -> System.exit(0));

        // Action Listener for Clear button
        clear.addActionListener(e -> {
            textField.setText("");
            resultField.setText("");
            textField.requestFocus();
        });

        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Temperature conversion methods
    private static double celsiusToFahrenheit(double celsius) {
        return Double.parseDouble(String.format("%.2f", celsius * 9 / 5 + 32));
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return Double.parseDouble(String.format("%.2f", (fahrenheit - 32) * 5 / 9));
    }

    private static double celsiusToKelvin(double celsius) {
        return Double.parseDouble(String.format("%.2f", celsius + 273.15));
    }

    private static double kelvinToCelsius(double kelvin) {
        return Double.parseDouble(String.format("%.2f", kelvin - 273.15));
    }

    private static double fahrenheitToKelvin(double fahrenheit) {
        return Double.parseDouble(String.format("%.2f", (fahrenheit - 32) * 5 / 9 + 273.15));
    }

    private static double kelvinToFahrenheit(double kelvin) {
        return Double.parseDouble(String.format("%.2f", kelvin * 9 / 5 - 459.67));
    }

    public static void main(String[] args) {
        // Run the temperature converter application
        tempConverter();
    }
}
