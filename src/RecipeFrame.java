import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 JFrame that will displays the Recipe Generator program window
 */
public class RecipeFrame extends JFrame implements WindowListener, MouseListener, MouseMotionListener {

    public RecipeFrame() {
        ColorMapManager.refresh();

        setTitle("Recipe Generator");
        setBounds(100, 100, 700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("favicon.png").getImage());
        setLayout(new BorderLayout());
        setBackground(new Color(0, 52, 52));
        setMinimumSize(new Dimension(700, 500));
        setResizable(true);

        addWindowListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        //setJMenuBar(new RecipeMenuBar()); Currently there is no need for a JMenuBar
        add(new RecipePanel());

        setVisible(true);
    }


    /**
     * All of the following methods are currently unused. They are required by the implemented interfaces.
     * First group of methods comes from the WindowListener interface.
     * Second group of methods comes from the MouseListener interface.
     * Third group of methods comes from the MouseMotionListener interface.
     */

    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowDeactivated(WindowEvent arg0) {}
    public void windowDeiconified(WindowEvent arg0) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}