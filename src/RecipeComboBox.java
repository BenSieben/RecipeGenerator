import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * A modified JPanel with a JComboBox for usage in the program.
 * It allows for users to pick a category of their
 * recipes from a set of defaults.
 */
public class RecipeComboBox extends JPanel {

    private JLabel label;
    private JComboBox<String> comboBox;
    private String[] options;

    /**
     * Creates a new RecipeComboBox, which creates a dropdown
     * for users to make a selection from a set of choices
     * @param labelText the descriptive label to give to the RecipeComboBox
     * @param options the array list of options the user can choose
     * @param toolTipText the text that shows up when the user hovers their mouse over the RecipeComboBox
     */
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

    /**
     * Creates a new RecipeComboBox for showing all saved recipes, which creates a dropdown
     * for users to make a selection from a set of choices
     * @param labelText the descriptive label to give to the RecipeComboBox
     * @param recipeList the tree map of recipes the user can choose
     * @param toolTipText the text that shows up when the user hovers their mouse over the RecipeComboBox
     */
    public RecipeComboBox(String labelText, TreeMap<String, Recipe> recipeList, String toolTipText) {
        label = new JLabel();
        label.setText(labelText);

        this.options = new String[recipeList.size()];
        int index = 0;
        for(String recipe: recipeList.keySet()) {
            options[index] = recipe;
            index ++;
        }

        comboBox = new JComboBox<>(this.options);
        comboBox.setEditable(false);
        comboBox.setToolTipText(toolTipText);
        setLayout(new BorderLayout());

        add(label, BorderLayout.WEST);
        add(comboBox, BorderLayout.CENTER);
    }

    public String toString() {
        String output = "";
        for(String choice: options) {
            output += (choice + "|");
        }
        return output.substring(output.length() - 1);
    }

    /**
     * Sets the RecipeComboBox to choose the entry in the
     * RecipeComboBox that equals the given selectionText
     * @param selectionText the text to make the RecipeComboBox select
     */
    public void setSelectedItem(String selectionText) {
        comboBox.setSelectedItem(selectionText);
    }

    /**
     * Returns the current selection index of the RecipeComboBox
     * @return the current selection index of the RecipeComboBox
     */
    public int getSelectedIndex() {
        return comboBox.getSelectedIndex();
    }

    /**
     * Returns the currently selected item of the RecipeComboBox
     * @return the currently selected item of the RecipeComboBox
     */
    public String getSelectedItem() {
        return (String)comboBox.getSelectedItem();
    }
}
