import java.awt.Desktop;
import java.io.File;

/**
 * Main method that launches the application
 */
public class Main {

    public static void main(String args[]) {
        RecipeFrame rf = new RecipeFrame();

        //openFile("RecipeGeneratorIndex.html");
    }

    private static void openFile(String filename) {
        File f = new File(filename);
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(f);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
