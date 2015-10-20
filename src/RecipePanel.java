import javax.swing.*;
import java.awt.*;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel {

    public RecipePanel() {
        this.setBackground(new Color(0, 52, 52));

        setLayout(new BorderLayout());

        RecipeTextArea ingredientsTextArea = new RecipeTextArea("Ingredients","Please list ingredients here, separating each ingredient with an enter space.");
        add(ingredientsTextArea, BorderLayout.PAGE_START);
        System.out.println(ingredientsTextArea);
    }

}
