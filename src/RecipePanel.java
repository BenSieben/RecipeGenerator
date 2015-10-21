import javax.swing.*;
import java.awt.*;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel {

    public RecipePanel() {
        //this.setBackground(new Color(0, 52, 52));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        RecipeTextField recipeTextField = new RecipeTextField("Recipe","Please write the recipe name here.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        add(recipeTextField, c);
        System.out.println(recipeTextField);

        RecipeTextArea ingredientsTextArea = new RecipeTextArea("Ingredients","Please list ingredients here, separating each ingredient with an enter space.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        add(ingredientsTextArea, c);
        System.out.println(ingredientsTextArea);

        RecipeTextArea instructionsTextArea = new RecipeTextArea("Instructions","Please list instructions here, separating each instruction with an enter space.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        add(instructionsTextArea, c);
        System.out.println(instructionsTextArea);
    }

}
