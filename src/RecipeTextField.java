import javax.swing.*;
import java.awt.*;

/**
 * Class that defines the basic structure of all JTextFields
 * present for users to create their recipes with the program
 */
public class RecipeTextField extends JPanel {

    private JLabel label;
    private JTextField textField;

    /**
     * Creates a new RecipeTextField to display a text field
     * in the RecipePanel
     * @param labelText the name of what the user should input in the text field
     * @param toolTipText the tool tip associated with the text field
     */
    public RecipeTextField(String labelText, String toolTipText) {
        textField = new JTextField();
        textField.setEditable(true);
        //textField.setBackground(new Color(0, 52, 52));  //Set background color for the textArea
        //textField.setForeground(new Color(255, 255, 255)); //Set font color for the textArea
        //textField.setCaretColor(new Color(255, 255, 255)); //Set caret (i.e., text editing location indicator) color for the textArea
        textField.setCaretPosition(textField.getText().length()); //Make caret start at the end of the initial text
        textField.setToolTipText(toolTipText); //Add a tool tip that instructs user on what goes in the text field

        label = new JLabel();
        //label.setOpaque(true); //Set the JLabel to be opaque since it is disabled by default
        label.setText(labelText);
        //label.setBackground(new Color(0, 52, 52)); //Set background color for the label
        //label.setForeground(new Color(255, 255, 255)); //Set font color for the label


        setLayout(new BorderLayout());

        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
    }

    /**
     * Returns the current contents of the RecipeTextField
     * @return the current contents of the RecipeTextField
     */
    public String toString() {
        return textField.getText();
    }

    /**
     * Changes the text in the RecipeTextField to
     * the input String
     * @param text the String to put in the RecipeTextField
     */
    public void setText(String text) {
        textField.setText(text);
    }
}
