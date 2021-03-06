import java.util.ArrayList;

/**
 * Class that stores all the information about a recipe.
 */
public class Recipe {

    private String recipeName, recipeCategory, recipeDescription;
    private ArrayList<String> recipeIngredients, recipeInstructions;


    /**
     * Creates a new recipe
     * @param name the name of the recipe
     * @param category the category of the recipe (such as appetizer or pie)
     * @param description a description of the recipe in a sentence or less
     * @param ingredients the list of ingredients needed for the recipe
     * @param instructions the list of instructions needed for the recipe
     */
    public Recipe(String name, String category, String description, ArrayList<String> ingredients, ArrayList<String> instructions) {
        recipeName = name;
        recipeCategory = category;
        recipeDescription = description;
        recipeIngredients = ingredients;
        recipeInstructions = instructions;
    }

    /**
     * Writes out all the information about the current Recipe
     * @return all the information about the current recipe
     */
    public String toString() {
        String s = (recipeName + "||" + recipeCategory + "||" + recipeDescription + "||");
        for(String ingredient : recipeIngredients) {
            s += (ingredient + "|");
        }
        s += "|";
        for(String instruction : recipeInstructions) {
            s += (instruction + "|");
        }
        s += "|";
        return s;
    }

    /**
     * Returns the name of the Recipe
     * @return the name of the Recipe
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Returns the category of the Recipe
     * @return the category of the Recipe
     */
    public String getRecipeCategory() {
        return recipeCategory;
    }

    /**
     * Returns the description of the Recipe
     * @return the description of the Recipe
     */
    public String getRecipeDescription() {
        return recipeDescription;
    }

    /**
     * Returns the array list of ingredients for the Recipe
     * @return the array list of ingredients for the Recipe
     */
    public ArrayList<String> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * Returns the array list of the instructions for the Recipe
     * @return the array list of the instructions for the Recipe
     */
    public ArrayList<String> getRecipeInstructions() {
        return recipeInstructions;
    }
}
