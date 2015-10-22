import java.awt.*;
import java.io.File;

/**
 * This class most of the backend work involved with
 * the recipe program (i.e., saving recipes, loading recipes,
 * deleting recipes, and opening the recipe index page)
 */
public class RecipeDataManager {

    private RecipeTextField recipeTextField;
    private RecipeComboBox categoryComboBox;
    private RecipeTextArea ingredientsTextArea, instructionsTextArea;

    public RecipeDataManager(RecipeTextField recipeTextField, RecipeComboBox categoryComboBox, RecipeTextArea ingredientsTextArea, RecipeTextArea instructionsTextArea) {
        this.recipeTextField = recipeTextField;
        this.categoryComboBox = categoryComboBox;
        this.ingredientsTextArea = ingredientsTextArea;
        this.instructionsTextArea = instructionsTextArea;
    }

    public void save() {

    }

    public void load() {

    }

    public void delete() {

    }

    /**
     * Attempts to open the recipe index HTML file
     */
    public void openIndex() {
        File f = new File("RecipeGeneratorIndex.html");
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(f);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
