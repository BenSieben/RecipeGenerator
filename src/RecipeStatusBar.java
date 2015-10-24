import javax.swing.*;
import java.awt.*;

/**
 * Represents a status bar at the bottom
 * to inform the user of actions being performed
 * and other information
 */
public class RecipeStatusBar extends JPanel{

    private JLabel message;

    /**
     * Creates a new RecipeStatusBar, used for conveying
     * messages to the user
     * @param message the initial message to present the user with
     */
    public RecipeStatusBar(String message) {
        setLayout(new BorderLayout());

        this.message = new JLabel();
        this.message.setOpaque(true);
        //this.message.setBackground(new Color(0, 0, 0));
        this.message.setHorizontalAlignment(SwingConstants.CENTER); //Centers the message

        add(this.message, BorderLayout.CENTER);
    }

    /**
     * Changes the status bar's message to the input String
     * @param text the new message to display in the status bar
     */
    public void setMessage(String text) {
        message.setText(text);
    }

    /**
     * Changes the status bar's message color
     * @param c the new Color to give to the status bar's message
     */
    public void setMessageColor(Color c) {
        message.setForeground(c);
    }

}
