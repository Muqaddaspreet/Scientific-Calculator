package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides a GUi for calculating the arccosine of a number.
 * The GUI includes fields for user input, a button to perform the calculation,
 * and labels to display the results and any errors.
 */
public final class ScientificCalculatorGUI {

    /** Title of the main application frame */
    private static final String FRAME_TITLE = "Arccosine Calculator";

    /** Welcome message displayed at the top of the application */
    private static final String WELCOME_MESSAGE = "Welcome to the Arccosine Calculator";

    /** Title label for the arccosine calculation section */
    private static final String CALCULATE_TITLE = "Calculate the Arccosine";

    /** Prompt message for the user input field */
    private static final String INPUT_PROMPT = "Enter a value for x (-1 <= x <= 1):";

    /** Text displayed on the calculate button */
    private static final String BUTTON_TEXT = "Calculate";

    /** Template text for displaying the result */
    private static final String RESULT_TEXT = "Result: ";

    /** Error message displayed for invalid input */
    private static final String ERROR_INPUT = "Error: Invalid input. Please enter a valid number.";

    /** Font family used in the application */
    private static final String FONT_FAMILY = "Serif";

    /** Logger instance */
    private static final Logger LOGGER = Logger.getLogger(ScientificCalculatorGUI.class.getName());

    /**
     * Private constructor to prevent instantiation.
     */
    private ScientificCalculatorGUI() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * The main method that acts as the entry point of the application.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        // Log version information if log level is enabled
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "ScientificCalculator Version: {0}", Version.getVersion());
        }

        // Create the frame
        final JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the panel to hold components
        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 200, 220)); // Set a nice background color
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        frame.add(panel);
        placeComponents(panel, gbc);

        // Set frame to be centered on screen
        frame.setLocationRelativeTo(null);

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Places components on the given panel with specified layout constraints.
     *
     * @param panel the panel to place components on.
     * @param gbc the layout constraints.
     */
    private static void placeComponents(final JPanel panel, final GridBagConstraints gbc) {
        // Welcome label
        final JLabel welcomeLabel = new JLabel(WELCOME_MESSAGE, JLabel.CENTER);
        welcomeLabel.setFont(new Font(FONT_FAMILY, Font.BOLD, 22));
        welcomeLabel.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(welcomeLabel, gbc);

        // Title label
        final JLabel titleLabel = new JLabel(CALCULATE_TITLE, JLabel.CENTER);
        titleLabel.setFont(new Font(FONT_FAMILY, Font.BOLD, 18));
        titleLabel.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // User input label
        final JLabel userLabel = new JLabel(INPUT_PROMPT);
        userLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userLabel, gbc);

        // User input text field
        final JTextField userText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(userText, gbc);

        // Calculate button
        final JButton calculateButton = new JButton(BUTTON_TEXT);
        calculateButton.setFont(new Font(FONT_FAMILY, Font.BOLD, 14));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setBackground(Color.BLUE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(calculateButton, gbc);

        // Result label
        final JLabel resultLabel = new JLabel(RESULT_TEXT);
        resultLabel.setFont(new Font(FONT_FAMILY, Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(resultLabel, gbc);

        // Error label
        final JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        errorLabel.setFont(new Font(FONT_FAMILY, Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(errorLabel, gbc);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                resultLabel.setText(RESULT_TEXT);
                final String input = userText.getText();
                try {
                    errorLabel.setText("");
                    final double inputValue = Double.parseDouble(input);
                    final double resultValue = ArccosCalculator.calculateArccos(inputValue);
                    resultLabel.setText(String.format("Result: arccos(%.2f) = %.2f radians", inputValue, resultValue));
                } catch (NumberFormatException ex) {
                    errorLabel.setText(ERROR_INPUT);
                } catch (IllegalArgumentException ex) {
                    errorLabel.setText("Error: " + ex.getMessage());
                }
            }
        });
    }
}
