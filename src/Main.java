import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;

/**
 * Main method that launches the application
 */
public class Main {

    public static void main(String args[]) {
        RecipeFrame rf = new RecipeFrame();

        //openFile("RecipeGeneratorIndex.html");

        String recipeName = "Pea Soup";
        String category = "Appetizer";
        String description = "A mash-potato like composition of pea soup with ham";
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("2 cups water");
        ingredients.add("1 lb. peas");
        ingredients.add("2 ounces pepper");
        ArrayList<String> instructions = new ArrayList<>();
        instructions.add("Add peas to water in pot");
        instructions.add("Warm up peas and water");
        instructions.add("Add pepper");
        Recipe r = new Recipe(recipeName, category, description, ingredients, instructions);

        String s = r.toString();
        System.out.println(s);

        int indexStart = 0;
        int indexEnd = s.indexOf("||");
        String retrieveRecipe = s.substring(indexStart, indexEnd);
        indexStart = indexEnd + 2;
        indexEnd = s.indexOf("||", indexStart);
        String retrieveCategory = s.substring(indexStart, indexEnd);
        indexStart = indexEnd + 2;
        indexEnd = s.indexOf("|", indexStart);
        int ingredientStop = s.indexOf("||", indexStart);
        ArrayList<String> retrieveIngredients = new ArrayList<>();
        while(indexEnd <= ingredientStop) {
            retrieveIngredients.add(s.substring(indexStart, indexEnd));
            indexStart = indexEnd + 1;
            indexEnd = s.indexOf("|", indexStart);
        }
        indexStart = indexEnd + 1;
        indexEnd = s.indexOf("|", indexStart);
        ArrayList<String> retrieveInstructions = new ArrayList<>();
        int instructionStop = s.indexOf("||", ingredientStop + 1);
        while(indexEnd <= instructionStop) {
            retrieveInstructions.add(s.substring(indexStart, indexEnd));
            indexStart = indexEnd + 1;
            indexEnd = s.indexOf("|", indexStart);
        }
        System.out.println(retrieveRecipe);
        System.out.println(retrieveCategory);
        for(String ingredient : retrieveIngredients) {
            System.out.println(ingredient);
        }
        for(String instruction : retrieveInstructions) {
            System.out.println(instruction);
        }
    }
}
