import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * This class most of the backend work involved with
 * the recipe program (i.e., saving recipes, loading recipes,
 * deleting recipes, and opening the recipe index page)
 */
public class RecipeDataManager {

    //The location of the file that stores all the recipe data
    private String filename;

    //The tree map that contains all the recipes during the program
    private TreeMap<String, Recipe> recipeList;

    /**
     * Creates a new RecipeDataManager, used for recipe modifying (saving / loading / deleting) and opening the index website
     * with the default recipe location
     */
    public RecipeDataManager() {
        filename = "recipes/RecipeList.txt"; //This is the default location of the recipe file
        recipeList = new TreeMap<>();
    }

    /**
     * Creates a RecipeDataManager that reads and writes from the input filename
     * @param filename the path to the file to be written to and read from
     */
    public RecipeDataManager(String filename) {
        this.filename = filename;
        recipeList = new TreeMap<>();
    }

    /**
     * Saves the current input of the program as a recipe
     * @param recipe the Recipe of the current input in the program
     */
    public void saveRecipe(Recipe recipe) {
        recipeList.put(recipe.getRecipeName(), recipe);
        saveRecipeList();
        //TODO update HTML files
    }

    /**
     * Saves all of the recipes back to the save file
     */
    public void saveRecipeList() {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for(Recipe recipe: recipeList.values()) {
                bw.write(recipe.toString() + "\n");
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads the list of all recipes to display
     * in the "Select Created Recipe" dropdown
     */
    public TreeMap<String, Recipe> loadRecipeList() {
        // load the file
        List<String> data = splitTextFile(filename);

        // go through each line in the file to load all the recipes
        for(String line : data) {
            System.out.println("recipe: " + line);

            // split lines on ||
            String[] lineArr = line.split("\\|\\|");
            // go through each item to create a recipe file
            String recipeName = lineArr[0];

            String recipeCategory = lineArr[1];

            String[] ingredients = lineArr[2].split("\\|");
            ArrayList<String> ingredientsAL = new ArrayList<>(Arrays.asList(ingredients));

            String[] instructions = lineArr[3].split("\\|");
            ArrayList<String> instructionsAL = new ArrayList<>(Arrays.asList(instructions));

            Recipe recipe = new Recipe(recipeName, recipeCategory, ingredientsAL, instructionsAL);
            System.out.println("recipe: " + recipe);

            recipeList.put(recipeName, recipe);

            /*for (String item : lineArr) {
                System.out.println("    item: " + item);
            }*/
        }
        return recipeList;
    }

    /**
     * Returns the current recipeList. Be sure to call the
     * loadRecipeList() method first to load all files from the program.
     * This methods is for updating the RecipeComboBox during program usage
     * @return the tree map that holds all the recipes currently saved
     */
    public TreeMap<String, Recipe> getRecipeList() {
        return recipeList;
    }

    /**
     * Loads the Recipe that has the same name
     * as the input recipeName String
     * @param recipeName the name of the recipe to load
     */
    public void loadRecipe(String recipeName) {

    }

    public void delete(int index) {

    }

    /**
     * Attempts to open the recipe index HTML file
     * @param statusBar the RecipeStatusBar, used to convey an error message in the event of an error
     */
    public void openIndex(RecipeStatusBar statusBar) {
        File f = new File("RecipeGeneratorIndex.html");
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(f);
        }
        catch(Exception ex) {
            statusBar.setMessageColor(Color.RED);
            statusBar.setMessage("Error: Cannot Find Recipe Index HTML File");
            ex.printStackTrace();
        }
    }

    /**
     * Returns a string array of each line of the input text
     * @param text the original text
     * @return a string array containing each line as a separate entry
     */
    public ArrayList<String> splitString(String text) {
        ArrayList<String> splitText = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new StringReader(text))) {
            String currentLine = "";
            while (currentLine != null) {
                currentLine = br.readLine();
                if(currentLine != null) splitText.add(currentLine);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return splitText;
    }

    /**
     * Returns a string array of each line of the input file
     * @param filename the original file
     * @return a string array containing each line as a separate entry
     */
    public ArrayList<String> splitTextFile(String filename) {
        ArrayList<String> splitText = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String currentLine = "";
            while (currentLine != null) {
                currentLine = br.readLine();
                if(currentLine != null) splitText.add(currentLine);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return splitText;
    }
}
