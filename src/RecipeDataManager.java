import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This class most of the backend work involved with
 * the recipe program (i.e., saving recipes, loading recipes,
 * deleting recipes, and opening the recipe index page)
 */
public class RecipeDataManager {

    //The location of the file that stores all the recipe data
    private String filename;

    /**
     * Creates a new RecipeDataManager, used for recipe modifying (saving / loading / deleting) and opening the index website
     * with the default recipe location
     */
    public RecipeDataManager() {
        filename = "recipes/RecipeList.txt"; //This is the default location of the recipe file
    }

    /**
     * Creates a RecipeDataManager that reads and writes from the input filename
     * @param filename the path to the file to be written to and read from
     */
    public RecipeDataManager(String filename) {
        this.filename = filename;
    }

    /**
     * Saves the current input of the program as a recipe in the file where all data is stored
     * @param recipe the Recipe of the current input in the program
     */
    public void save(Recipe recipe) {
        boolean isOldRecipe = false; //Flags whether or not the input recipe is updating an older recipe or not by checking if the recipeName already exists in the save file

        String recipeSaveText = recipe.toString();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(recipeSaveText);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load(int index) {

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
    public ArrayList<String> splitList(String text) {
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
}
