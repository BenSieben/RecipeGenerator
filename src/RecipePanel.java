import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel implements ActionListener {

    private RecipeDataManager manager;
    private RecipeTextField recipeTextField, descriptionTextField;
    private RecipeComboBox categoryComboBox, recipesComboBox;
    private RecipeTextArea ingredientsTextArea, instructionsTextArea;
    private RecipeStatusBar statusBar;

    /**
     * Creates a new RecipePanel, which contains all components of the
     * recipe generator needed for user usage
     */
    public RecipePanel() {
        //this.setBackground(new Color(0, 52, 52));

        manager = new RecipeDataManager();
        TreeMap<String, Recipe> recipeList = manager.loadRecipeList();
        recipesComboBox = new RecipeComboBox("Select Created Recipe",recipeList,"Select a recipe to load or delete from this dropdown.");

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

        descriptionTextField = new RecipeTextField("Description","Please write a simple sentence describing the recipe here.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 2; //Put this Component at the third row
        c.gridwidth = 2; //This Component is two cells wide
        c.weightx = 1; //Make the recipeTextField span the entire horizontal space of the JPanel
        add(descriptionTextField, c);
        System.out.println(descriptionTextField);

        ingredientsTextArea = new RecipeTextArea("Ingredients","Please list ingredients here, separating each ingredient on a new line.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 3; //Put this Component at the fourth row
        c.gridwidth = 1; //This Component is one cell wide
        c.weightx = 0.5; //Make the ingredientsTextArea span half the horizontal space of the JPanel
        add(ingredientsTextArea, c);
        System.out.println(ingredientsTextArea);

        instructionsTextArea = new RecipeTextArea("Instructions","Please list instructions here, separating each instruction on a new line.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 3; //Put this Component at the fourth row
        c.gridwidth = 1; // This Component is one cell wide
        c.weightx = 0.5; //Make the instructionsTextArea span half the horizontal space of the JPanel
        add(instructionsTextArea, c);
        System.out.println(instructionsTextArea);

        JButton openIndexButton = new JButton("Open the Recipe Index Page");
        openIndexButton.setActionCommand("OpenIndex");
        openIndexButton.addActionListener(this);
        openIndexButton.setToolTipText("Open up the Recipe Index HTML Page with the default program.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 4; //Put this Component at the fifth row
        c.gridwidth = 1; // This Component is one cell wide
        add(openIndexButton, c);

        JButton saveButton = new JButton("Save Recipe");
        saveButton.setActionCommand("Save");
        saveButton.addActionListener(this);
        saveButton.setToolTipText("Save the current recipe name / category / ingredients / instructions as a recipe.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 4; //Put this Component at the fifth row
        c.gridwidth = 1; // This Component is one cell wide
        add(saveButton, c);

        //This sections sets up the recipesComboBox Component
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 5; //Put this Component at the sixth row
        c.gridwidth = 2; //This Component is two cells wide
        c.weightx = 1; //Make the recipeTextField span the entire horizontal space of the JPanel
        add(recipesComboBox, c);

        JButton loadButton = new JButton("Load Selected Recipe");
        loadButton.setActionCommand("Load");
        loadButton.addActionListener(this);
        loadButton.setToolTipText("Load the recipe currently selected in the \"Select Created Recipe\" dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the first column
        c.gridy = 6; //Put this Component at the seventh row
        c.gridwidth = 1; // This Component is one cell wide
        add(loadButton, c);

        JButton deleteButton = new JButton("Delete Selected Recipe");
        deleteButton.setActionCommand("Delete");
        deleteButton.addActionListener(this);
        deleteButton.setToolTipText("Delete the recipe currently selected in the \"Select Created Recipe\" dropdown.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1; //Put this Component at the second column
        c.gridy = 6; //Put this Component at the seventh row
        c.gridwidth = 1; // This Component is one cell wide
        add(deleteButton, c);

        statusBar = new RecipeStatusBar("Recipe Generator");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0; //Put this Component at the second column
        c.gridy = 7; //Put this Component at the eighth row
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

    /**
     * Activates whenever an ActionEvent is detected by one
     * of the RecipePanel's JButtons present, which can be
     * examined to determine what action to take
     * @param e the ActionEvent that was detected
     */
    public void actionPerformed(ActionEvent e) {
        if("Save".equals(e.getActionCommand())) { //Save button was pressed

            //Making sure no illegal characters have been given as input for any part of the recipe,
            //as they would break the saving method implemented by this program
           if(inputPassesCheck()) { //No illegal characters present, so we can save
               statusBar.setMessageColor(Color.WHITE);
               statusBar.setMessage("Saving " + recipeTextField.toString() + " recipe, please wait...");
                String recipeName = recipeTextField.toString();
                String categoryName = categoryComboBox.getSelectedItem();
                String description = descriptionTextField.toString();
                ArrayList<String> ingredients = manager.splitString(ingredientsTextArea.toString());
                ArrayList<String> instructions = manager.splitString(instructionsTextArea.toString());

                Recipe recipe = new Recipe(recipeName, categoryName, description, ingredients, instructions);
                System.out.println(recipe);
                manager.saveRecipe(recipe);
               updateRecipeList(); //Need to update the recipe list with the recipe that was just saved
               statusBar.setMessage("Save completed");
            }
        }
        else if("Load".equals(e.getActionCommand())) { //Load button was pressed

            //Make sure that a recipe has been selected for loading
            if(recipesComboBox.getOptions().length == 0) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("You must have at least one recipe saved to load a recipe.");
            }
            else {
                statusBar.setMessageColor(Color.WHITE);
                statusBar.setMessage("Loading " + recipesComboBox.getSelectedItem() + " recipe, please wait...");
                manager.loadRecipe(recipesComboBox.getSelectedItem(), recipeTextField, categoryComboBox, descriptionTextField, ingredientsTextArea, instructionsTextArea);
                statusBar.setMessage("Recipe load completed");
            }

        }
        else if("Delete".equals(e.getActionCommand())) { //Delete button was pressed

            //Make sure that a recipe has been selected for deletion
            if(recipesComboBox.getOptions().length == 0) {
                statusBar.setMessageColor(Color.RED);
                statusBar.setMessage("You must have at least one recipe saved to delete a recipe.");
            }
            else {
                statusBar.setMessageColor(Color.WHITE);
                statusBar.setMessage("Deleting " + recipesComboBox.getSelectedItem() + " recipe, please wait...");
                manager.delete(recipesComboBox.getSelectedItem());
                updateRecipeList(); //need to update the recipe list without the recipe that was just deleted
                statusBar.setMessage("Recipe deletion completed");
            }
        }
        else if("OpenIndex".equals(e.getActionCommand())) { //OpenIndex button was pressed
            statusBar.setMessageColor(Color.WHITE);
            statusBar.setMessage("Opening Recipe Index...");
            manager.openIndex(statusBar);
        }
    }

    //Checks user input when they try to save a recipe,
    //making sure that no illegal characters are in any
    //editable area
    //Returns true if the input passes; false if the input fails
    private boolean inputPassesCheck() {
        if(recipeTextField.toString().contains("|") || recipeTextField.toString().contains("\\") || recipeTextField.toString().contains("/") || recipeTextField.toString().contains(":") || recipeTextField.toString().contains("*") || recipeTextField.toString().contains("?") || recipeTextField.toString().contains("\"") || recipeTextField.toString().contains("<") || recipeTextField.toString().contains(">")) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("Illegal input (|, \\, /, :, *, ?, \", <, and/or >) detected in recipe text field, please remove any of these characters from your input to save.");
            return false;
        }
        else if(descriptionTextField.toString().contains("|")) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("Illegal input | detected in description text field, please remove any | characters from your description to save.");
            return false;
        }
        else if(ingredientsTextArea.toString().contains("|")) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("Illegal input | detected in ingredients text area, please remove any | characters from your input to save.");
            return false;
        }
        else if(instructionsTextArea.toString().contains("|")) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("Illegal input | detected in instructions text area, please remove any | characters from your input to save.");
            return false;
        }
        else if(recipeTextField.toString().trim().length() == 0) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("The recipe name must have at least one character to save the recipe.");
            return false;
        }
        else if(descriptionTextField.toString().trim().length() == 0) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("The recipe description must have at least one character to save the recipe.");
            return false;
        }
        else if(ingredientsTextArea.toString().trim().length() == 0) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("The ingredients list must have at least one character to save the recipe.");
            return false;
        }
        else if(instructionsTextArea.toString().trim().length() == 0) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("The instructions list must have at least one character to save the recipe.");
            return false;
        }
        return true;
    }

    //Updates the recipe list for users to look through their created recipes
    private void updateRecipeList() {
        TreeMap<String, Recipe> recipeList = manager.getRecipeList();
        recipesComboBox.update(recipeList);
        recipesComboBox.revalidate();
        recipesComboBox.repaint();
        //recipesComboBox = new RecipeComboBox("Select Created Recipe",recipeList,"Select a recipe to load or delete from this dropdown.");
    }

}
