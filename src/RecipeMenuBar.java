import javax.swing.*;

/**
 * The JMenuBar that is used for this program is defined here
 */
public class RecipeMenuBar extends JMenuBar {

    JMenu fileMenu;

    public RecipeMenuBar() {
        fileMenu = new JMenu("File");

        add(fileMenu);
    }
}
