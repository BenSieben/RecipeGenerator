import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * A modified JPanel with a JComboBox for usage in the program.
 * It allows for users to pick a category of their
 * recipes from a set of defaults.
 */
public class RecipeComboBox extends JPanel {

    private JLabel label;
    private JComboBox<String> comboBox;
    private String[] options;

    public RecipeComboBox(String labelText, ArrayList<String> options, String toolTipText) {
        label = new JLabel();
        label.setText(labelText);

        this.options = options.toArray(new String[options.size()]);

        comboBox = new JComboBox<>(this.options);
        comboBox.setEditable(false);
        comboBox.setToolTipText(toolTipText);

        setLayout(new BorderLayout());

        add(label, BorderLayout.WEST);
        add(comboBox, BorderLayout.CENTER);
    }

    public String toString() {
        String output = (label.getText() + "\n\r");
        for(String choice: options) {
            output += (choice + "\n\r");
        }
        return output;
    }
}
