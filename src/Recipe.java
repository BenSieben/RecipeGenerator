import java.util.ArrayList;

/**
 * Class that stores all the information about a recipe.
 * Also contains the saving / loading of recipes.
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
     * Attempt to save the calling recipe
     */
    public void save() {
        saveRecipe(this);
    }

    /**
     * Attempt to save the given Recipe
     * @param r the Recipe that needs to be saved
     */
    public static void saveRecipe(Recipe r) {

    }

    /**
     * Attempt to load a recipe from the recipe list
     * @param name the name of the recipe
     * @return the Recipe file if it is found, or else null if the Recipe was not found
     */
    public static Recipe loadRecipe(String name) {
        return null;
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

}
