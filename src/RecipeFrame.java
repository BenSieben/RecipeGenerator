import javax.swing.*;
import java.awt.*;

/**
 JFrame that will displays the Recipe Generator program window
 */
public class RecipeFrame extends JFrame {

    public RecipeFrame() {
        ColorMapManager.refresh();

        setTitle("Recipe Generator");
        setBounds(100, 100, 800, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("favicon.png").getImage());
        setLayout(new BorderLayout());
        setBackground(new Color(0, 52, 52));
        setMinimumSize(new Dimension(700, 500));
        setResizable(true);

        add(new RecipePanel());

        setVisible(true);
    }
}