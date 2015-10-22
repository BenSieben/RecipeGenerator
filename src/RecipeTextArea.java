import javax.swing.*;
import java.awt.*;

/**
 * Class that defines the basic structure of all JTextAreas
 * that are needed for users to create recipes through the
 * program
 */
public class RecipeTextArea extends JPanel{

    //Holds the JTextArea within this specific RecipeTextArea
    private JTextArea textArea;

    /**
     * Creates a new RecipeTextArea with specific values
     * @param labelText the text that will be put as a JLabel for the RecipeTextArea
     * @param toolTipText the text that will initially be inside the JTextArea of the RecipeTextArea
     */
    public RecipeTextArea(String labelText, String toolTipText) {
        textArea = new JTextArea(5, 20);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); //Make line wrap go by words instead of by characters (the default)
        //textArea.setBackground(new Color(0, 52, 52));  //Set background color for the textArea
        //textArea.setForeground(new Color(255, 255, 255)); //Set font color for the textArea
        //textArea.setCaretColor(new Color(255, 255, 255)); //Set caret (i.e., text editing location indicator) color for the textArea
        textArea.setCaretPosition(textArea.getText().length()); //Make caret start at the end of the initial text
        textArea.setToolTipText(toolTipText); //Add a tool tip that instructs user on what goes in the text field

        JScrollPane scrollPane = new JScrollPane(textArea);

        JLabel label = new JLabel();
        //label.setOpaque(true); //Set the JLabel to be opaque since it is disabled by default
        label.setText(labelText);
        //label.setBackground(new Color(0, 52, 52)); //Set background color for the label
        //label.setForeground(new Color(255, 255, 255)); //Set font color for the label


        setLayout(new BorderLayout());

        add(label, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Returns the contents within the textArea
     * of the RecipeTextArea
     * @return the contents within the textArea
     * of the RecipeTextArea
     */
    public String toString() {
        return textArea.getText();
    }

    /**
     * Set the text in the RecipeTextArea to match
     * the input String
     * @param text the text to place in the RecipeTextArea
     */
    public void setText(String text) {
        textArea.setText(text);
    }

}
