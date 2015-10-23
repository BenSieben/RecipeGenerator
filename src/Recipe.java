import java.util.ArrayList;

/**
 * Class that stores all the information about a recipe.
 */
public class Recipe {

    private String recipeName, recipeCategory;
    private ArrayList<String> recipeIngredients, recipeInstructions;

    public Recipe(String name, String category, ArrayList<String> ingredients, ArrayList<String> instructions) {
        recipeName = name;
        recipeCategory = category;
        recipeIngredients = ingredients;
        recipeInstructions = instructions;
    }

    /**
     * Writes out all the information about the current Recipe
     * @return all the information about the current recipe
     */
    public String toString() {
        String s = (recipeName + "||" + recipeCategory + "||");
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
        return recipeIngredients;
    }
}
