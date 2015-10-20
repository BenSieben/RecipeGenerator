import javax.swing.*;
import java.awt.*;

/**
 * Class that defines the basic structure of all JTextAreas
 * that are needed for users to create recipes through the
 * program.
 */
public class RecipeTextArea extends JPanel{

    //Holds the JTextArea within this specific RecipeTextArea
    private JTextArea textArea;

    //Holds the JScrollPane within this specific RecipeTextArea
    private JScrollPane scrollPane;

    //Holds the JLabel used to define this specific RecipeTextArea
    private JLabel label;

    public RecipeTextArea(String labelText, String initialText) {
        textArea = new JTextArea(initialText, 5, 20);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(0, 52, 52));
        textArea.setForeground(new Color(255, 255, 255));
        textArea.setCaretColor(new Color(255, 255, 255));

        scrollPane = new JScrollPane(textArea);

        label = new JLabel();
        label.setOpaque(true); //Set the JLabel to be opaque since it is disabled by default
        label.setText(labelText);
        label.setBackground(new Color(0, 52, 52));
        label.setForeground(new Color(255, 255, 255));


        setLayout(new BorderLayout());

        add(label, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Returns the label of the RecipeTextArea and the contents within the textArea
     * of the RecipeTextArea
     * @return the label of the RecipeTextArea and the contents within the textArea
     * of the RecipeTextArea
     */
    public String toString() {
        String labelName = label.getText();
        String textAreaContents = textArea.getText();

        return (labelName + ": " + textAreaContents);
    }

}
