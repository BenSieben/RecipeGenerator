import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel implements ActionListener {

    private JButton testButton, saveButton, loadButton;
    private RecipeTextField recipeTextField;
    private RecipeComboBox categoryComboBox;
    private RecipeTextArea ingredientsTextArea, instructionsTextArea;

    public RecipePanel() {
        //this.setBackground(new Color(0, 52, 52));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        recipeTextField = new RecipeTextField("Recipe","Please write the recipe name here.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 0; //Put this Component at the first row
        c.gridwidth = 2; //This Component is two cells wide
        c.weightx = 1; //Make the recipeTextField span the entire horizontal space of the JPanel
        add(recipeTextField, c);
        System.out.println(recipeTextField);

        ArrayList<String> categoryOptions = getCategoryOptions();
        categoryComboBox = new RecipeComboBox("Category",categoryOptions,"Please choose the most appropriate recipe category from this dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 1; //Put this Component at the second row
        c.gridwidth = 2; //This Component is two cells wide
        c.weightx = 1; //Make the recipeTextField span the entire horizontal space of the JPanel
        add(categoryComboBox, c);
        System.out.println(recipeTextField);


        ingredientsTextArea = new RecipeTextArea("Ingredients","Please list ingredients here, separating each ingredient with an enter space.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 2; //Put this Component at the third row
        c.gridwidth = 1; //This Component is one cell wide
        c.weightx = 0.5; //Make the ingredientsTextArea span half the horizontal space of the JPanel
        add(ingredientsTextArea, c);
        System.out.println(ingredientsTextArea);

        instructionsTextArea = new RecipeTextArea("Instructions","Please list instructions here, separating each instruction with an enter space.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 2; //Put this Component at the third row
        c.gridwidth = 1; // This Component is one cell wide
        c.weightx = 0.5; //Make the instructionsTextArea span half the horizontal space of the JPanel
        add(instructionsTextArea, c);
        System.out.println(instructionsTextArea);

        testButton = new JButton("Test");
        testButton.setActionCommand("Test");
        testButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 3; //Put this Component at the fourth row
        c.gridwidth = 1; // This Component is one cell wide
        c.weightx = 0.25; //Make the instructionsTextArea span 1/4 the horizontal space of the JPanel
        add(testButton, c);

        saveButton = new JButton("Save Recipe");
        saveButton.setActionCommand("Save");
        saveButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 4; //Put this Component at the fifth row
        c.gridwidth = 1; // This Component is one cell wide
        c.weightx = 0.25; //Make the instructionsTextArea span 1/4 the horizontal space of the JPanel
        add(saveButton, c);

        loadButton = new JButton("Load Recipe");
        loadButton.setActionCommand("Load");
        testButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 4; //Put this Component at the fourth row
        c.gridwidth = 1; // This Component is one cell wide
        c.weightx = 0.25; //Make the instructionsTextArea span 1/4 the horizontal space of the JPanel
        add(loadButton, c);
    }


    /**
     * Returns a list of all the different categories
     * that recipes are usually attributed to, with a
     * "Other" option for anything else
     * @return an ArrayList of all recipe categories
     */
    private ArrayList<String> getCategoryOptions() {
        ArrayList<String> categoryOptions = new ArrayList<>();
        categoryOptions.add("Appetizer / Starter");
        categoryOptions.add("Bread / Roll / Muffin");
        categoryOptions.add("Bean / Grain / Legume");
        categoryOptions.add("Burger");
        categoryOptions.add("Cake / Cupcake");
        categoryOptions.add("Candy / Sweet");
        categoryOptions.add("Casserole / Gratin");
        categoryOptions.add("Cocktail");
        categoryOptions.add("Cookie");
        categoryOptions.add("Dessert");
        categoryOptions.add("Dip / Spread");
        categoryOptions.add("Dressing");
        categoryOptions.add("Marinade / Rub");
        categoryOptions.add("Nonalcoholic Drink");
        categoryOptions.add("Pasta / Noodles");
        categoryOptions.add("Pie / Tart");
        categoryOptions.add("Pizza");
        categoryOptions.add("Pudding / Custard");
        categoryOptions.add("Salad");
        categoryOptions.add("Sandwich");
        categoryOptions.add("Sauce / Condiment");
        categoryOptions.add("Side Dish");
        categoryOptions.add("Soup / Stew");
        categoryOptions.add("Stuffing");
        categoryOptions.add("Other");
        return categoryOptions;
    }

    public void actionPerformed(ActionEvent e) {
        if ("Test".equals(e.getActionCommand())) {
            System.out.println("Test button pressed.");

            //Making sure no | characters have been given as input for any part of the recipe
            if(recipeTextField.toString().contains("|")) {
                System.out.println("Illegal input | detected in recipe text field, please remove any | characters from your input.");
            }
            if(ingredientsTextArea.toString().contains("|")) {
                System.out.println("Illegal input | detected in ingredients text area, please remove any | characters from your input.");
            }
            if(instructionsTextArea.toString().contains("|")) {
                System.out.println("Illegal input | detected in instructions text area, please remove any | characters from your input.");
            }
        }
    }

}
