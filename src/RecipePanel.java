import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel implements ActionListener {

    private JButton saveButton, loadButton, deleteButton, openIndexButton;
    private RecipeTextField recipeTextField;
    private RecipeComboBox categoryComboBox, recipesComboBox;
    private RecipeTextArea ingredientsTextArea, instructionsTextArea;
    private RecipeStatusBar statusBar;
    private RecipeDataManager manager;

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

        manager = new RecipeDataManager();

        openIndexButton = new JButton("Open the Recipe Index Page");
        openIndexButton.setActionCommand("OpenIndex");
        openIndexButton.addActionListener(this);
        openIndexButton.setToolTipText("Open up the Recipe Index HTML Page with the default program.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 3; //Put this Component at the fourth row
        c.gridwidth = 1; // This Component is one cell wide
        add(openIndexButton, c);

        saveButton = new JButton("Save Recipe");
        saveButton.setActionCommand("Save");
        saveButton.addActionListener(this);
        saveButton.setToolTipText("Save the current recipe name / category / ingredients / instructions as a recipe.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 3; //Put this Component at the fourth row
        c.gridwidth = 1; // This Component is one cell wide
        add(saveButton, c);

        ArrayList<String> createdRecipes = new ArrayList<>();
        createdRecipes.add("Select a Recipe to Load or Delete");
        recipesComboBox = new RecipeComboBox("Select Created Recipe",createdRecipes,"Select a recipe to load or delete from this dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 4; //Put this Component at the fifth row
        c.gridwidth = 2; //This Component is two cells wide
        c.weightx = 1; //Make the recipeTextField span the entire horizontal space of the JPanel
        add(recipesComboBox, c);

        loadButton = new JButton("Load Recipe");
        loadButton.setActionCommand("Load");
        loadButton.addActionListener(this);
        loadButton.setToolTipText("Load the recipe currently selected in the \"Select Created Recipe\" dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 5; //Put this Component at the sixth row
        c.gridwidth = 1; // This Component is one cell wide
        add(loadButton, c);

        deleteButton = new JButton("Delete Recipe");
        deleteButton.setActionCommand("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setToolTipText("Delete the recipe currently selected in the \"Select Created Recipe\" dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 5; //Put this Component at the sixth row
        c.gridwidth = 1; // This Component is one cell wide
        add(deleteButton, c);

        statusBar = new RecipeStatusBar("Recipe Generator");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the second column
        c.gridy = 6; //Put this Component at the seventh row
        c.gridwidth = 2; // This Component is one cell wide
        c.weightx = 1;
        add(statusBar, c);
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
        if("Save".equals(e.getActionCommand())) { //Save button was pressed
            statusBar.setMessageColor(Color.WHITE);
            statusBar.setMessage("Save button pressed");

            //Making sure no | characters have been given as input for any part of the recipe,
            //as they would break the saving method implemented by this program
            if(recipeTextField.toString().contains("|")) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("Illegal input | detected in recipe text field, please remove any | characters from your input to save.");
            }
            else if(ingredientsTextArea.toString().contains("|")) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("Illegal input | detected in ingredients text area, please remove any | characters from your input to save.");
            }
            else if(instructionsTextArea.toString().contains("|")) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("Illegal input | detected in instructions text area, please remove any | characters from your input to save.");
            }
            else { //No | characters present, so we can save
                String recipeName = recipeTextField.toString();

                String categoryName = categoryComboBox.getSelectedItem();

                ArrayList<String> ingredients = manager.splitList(ingredientsTextArea.toString());

                ArrayList<String> instructions = manager.splitList(instructionsTextArea.toString());

                Recipe recipe = new Recipe(recipeName, categoryName, ingredients, instructions);
                System.out.println(recipe);
                manager.save(recipe);
            }
        }
        else if("Load".equals(e.getActionCommand())) { //Load button was pressed

            //Make sure that a recipe has been selected for loading
            if(recipesComboBox.getSelectedIndex() == 0) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("Please choose a recipe to load from the \"Select Created Recipe\" dropdown.");
            }
            else {
                statusBar.setMessageColor(Color.WHITE);
                statusBar.setMessage("Load button pressed");
                manager.load(recipesComboBox.getSelectedIndex());
            }
        }
        else if("Delete".equals(e.getActionCommand())) { //Delete button was pressed

            //Make sure that a recipe has been selected for deletion
            if(recipesComboBox.getSelectedIndex() == 0) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("Please choose a recipe to delete from the \"Select Created Recipe\" dropdown.");
            }
            else {
                statusBar.setMessageColor(Color.WHITE);
                statusBar.setMessage("Delete button pressed");
                manager.delete(recipesComboBox.getSelectedIndex());
            }
        }
        else if("OpenIndex".equals(e.getActionCommand())) { //OpenIndex button was pressed
            statusBar.setMessageColor(Color.WHITE);
            statusBar.setMessage("Opening Recipe Index...");
            manager.openIndex(statusBar);
        }
    }

}
