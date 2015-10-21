import javax.swing.*;
import java.awt.*;

/**
 * Class that defines the basic structure of all JTextFields
 * present for users to create their recipes with the program
 */
public class RecipeTextField extends JPanel {

    private JLabel label;
    private JTextField textField;

    public RecipeTextField(String labelText, String initialText) {
        textField = new JTextField(initialText);
        textField.setEditable(true);
        //textField.setBackground(new Color(0, 52, 52));  //Set background color for the textArea
        //textField.setForeground(new Color(255, 255, 255)); //Set font color for the textArea
        //textField.setCaretColor(new Color(255, 255, 255)); //Set caret (i.e., text editing location indicator) color for the textArea
        textField.setCaretPosition(textField.getText().length()); //Make caret start at the end of the initial text

        label = new JLabel();
        //label.setOpaque(true); //Set the JLabel to be opaque since it is disabled by default
        label.setText(labelText);
        //label.setBackground(new Color(0, 52, 52)); //Set background color for the label
        //label.setForeground(new Color(255, 255, 255)); //Set font color for the label


        setLayout(new BorderLayout());

        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
    }

    public String toString() {
        String labelName = label.getText();
        String textAreaContents = textField.getText();

        return (labelName + ": " + textAreaContents);
    }
}
