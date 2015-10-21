import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Color Map manager.
 */
public class ColorMapManager {
    public static final String LOOK_AND_FEEL = "Nimbus", BACKGROUND = "background", TEXT = "text", HIGHLIGHT = "highlight",
            SELECTED_TEXT = "selectedText", SUCCESS_TEXT = "successText", WARNING_TEXT = "warningText", ERROR_TEXT = "errorText";
    private static Map<String, Color> colorNameToColorMap;

    // static initializer for the color map
    static {
        colorNameToColorMap = new TreeMap<>();
        colorNameToColorMap.put(BACKGROUND, new Color(0, 52, 52));
        colorNameToColorMap.put(HIGHLIGHT, new Color(19, 63, 110));
        colorNameToColorMap.put(TEXT, new Color(200, 200, 200));
        colorNameToColorMap.put(SELECTED_TEXT, new Color(200, 200, 200));
        colorNameToColorMap.put(SUCCESS_TEXT, new Color(128, 255, 128));
        colorNameToColorMap.put(WARNING_TEXT, new Color(255, 255, 128));
        colorNameToColorMap.put(ERROR_TEXT, new Color(255, 128, 128));
    }

    /**
     * Do not allow objects of this class to be made.
     */
    private ColorMapManager() {
    }

    /**
     * Attempts to setup the theme color and saves the default color mappings if we failed to load the theme file.
     *
     * @param fileLocation the location of the Theme file
     * @return true on success
     */
    public static boolean setup(String fileLocation) {
        if(!refresh(fileLocation)) {
            ColorMapWriter.save(fileLocation, colorNameToColorMap);

            return false;
        }

        return true;
    }

    /**
     * Attempts to refresh the theme.
     *
     * @return true on success
     */
    public static boolean refresh() {
        return refresh("");
    }

    /**
     * Attempts to refresh the theme.
     *
     * @param fileLocation the location of the Theme file
     * @return true on success
     */
    public static boolean refresh(String fileLocation) {
        try {
            for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if(info.getName().equals(LOOK_AND_FEEL)) {
                    UIManager.setLookAndFeel(info.getClassName());

                    // attempt to load the colors
                    if (!fileLocation.equals("")) {
                        ColorMapReader.load(fileLocation, colorNameToColorMap);
                    }

                    setNimbusColors();

                    return true;
                }
            }
        }
        catch(Exception e) {
            System.out.println("Error: unexpected error while refreshing color map.");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Sets the Nimbus colors of the GUI using the colors in the Theme class.
     */
    private static void setNimbusColors() {
        UIManager.put("control", colorNameToColorMap.get(BACKGROUND)); // empty (aka background of JPanels) component color
        UIManager.put("info", colorNameToColorMap.get(BACKGROUND)); // tooltip background color

        UIManager.put("nimbusBase", colorNameToColorMap.get(BACKGROUND)); // color of radio buttons dots/first item of combo box background

        UIManager.put("nimbusFocus", colorNameToColorMap.get(HIGHLIGHT)); // color around focused component

        UIManager.put("nimbusLightBackground", colorNameToColorMap.get(BACKGROUND)); // text area background

        UIManager.put("nimbusOrange", colorNameToColorMap.get(HIGHLIGHT)); // progress bar background color

        UIManager.put("nimbusSelectedText", colorNameToColorMap.get(SELECTED_TEXT)); // selected text color
        UIManager.put("nimbusSelectionBackground", colorNameToColorMap.get(HIGHLIGHT)); // selected text's background color
        UIManager.put("text", colorNameToColorMap.get(TEXT)); // text color

        UIManager.put("nimbusBlueGrey", colorNameToColorMap.get(BACKGROUND)); // general background color of components

        UIManager.put("TitledBorder.titleColor", colorNameToColorMap.get(TEXT)); // titled border color
    }

    /**
     * Gets a color given a color name.
     *
     * @param colorName the color name
     * @return the color
     */
    public static Color getColor(String colorName) {
        return colorNameToColorMap.get(colorName);
    }
}
