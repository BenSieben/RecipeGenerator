import javax.swing.*;
import java.awt.*;

/**
 * Test panel
 */
public class TestPanel extends JPanel {

    public TestPanel() {
        this.setBackground(new Color(0, 52, 52));

        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("Hello", 5, 20);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane textAreaPane = new JScrollPane(textArea);
        this.add(textAreaPane, BorderLayout.PAGE_START);
    }
}
