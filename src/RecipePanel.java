import javax.swing.*;
import java.awt.*;

/**
 * JPanel that holds all of the components of the recipe generator needed for user usage
 */
public class RecipePanel extends JPanel {

    public RecipePanel() {
        this.setBackground(new Color(0, 52, 52));

        setLayout(new BorderLayout());

        IngredientsPane ingredientsPane = new IngredientsPane();
        this.add(ingredientsPane, BorderLayout.PAGE_START);

        setVisible(true);

        System.out.println(ingredientsPane);
    }

    private class IngredientsPane extends JScrollPane {

        private JTextArea textArea;

        public IngredientsPane() {
            textArea = new JTextArea("Put ingredients here, with each entry separated by an enter space", 5, 20);
            textArea.setEditable(true);
            textArea.setLineWrap(true);
            this.add(textArea);
        }

        public String toString() {
            return textArea.getText();
        }

    }
}
