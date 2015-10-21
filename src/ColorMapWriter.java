import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.awt.*;
import java.io.*;
import java.util.Map;

/**
 * The Color Map writer.
 */
public class ColorMapWriter {
    public static final String SEPARATOR = System.getProperty("line.separator"), SPACING = "    ";
    public static final String COLOR = "colors";

    /**
     * Do not allow objects of this class to be made.
     */
    private ColorMapWriter() {
    }

    /**
     * Saves a theme to a given file location.
     *
     * @param fileLocation the file location
     * @return true on success
     */
    public static boolean save(String fileLocation, Map<String, Color> colorNameToColorMap) {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        try {
            OutputStream outputStream = new FileOutputStream(fileLocation);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(bufferedOutputStream, "UTF-8");

            streamWriter.writeStartDocument("UTF-8", "1.0");
            streamWriter.writeDTD(SEPARATOR);

            createNode(streamWriter, colorNameToColorMap);

            streamWriter.writeEndDocument();

            streamWriter.close();
            bufferedOutputStream.close();
            outputStream.close();

            return true;
        }
        catch(FileNotFoundException e) {
            System.out.println("Error: cannot find specified file");
            e.printStackTrace();
        }
        catch(XMLStreamException e) {
            System.out.println("Error: unexpected XML Stream error");
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("Error: unexpected IO Exception");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Creates a node.
     *
     * @param streamWriter the stream writer to create the node on
     * @throws XMLStreamException on XMLStreamException
     */
    private static void createNode(XMLStreamWriter streamWriter, Map<String, Color> colorNameToColorMap) throws XMLStreamException {
        streamWriter.writeStartElement(COLOR);
        streamWriter.writeCharacters(SEPARATOR);

        for(String colorName : colorNameToColorMap.keySet()) {
            createCharacterNode(streamWriter, colorName, getColorAsText(colorNameToColorMap.get(colorName)));
        }

        streamWriter.writeEndElement();
        streamWriter.writeCharacters(SEPARATOR);
    }

    /**
     * Gets a color as text (the RGB value separated by commas).
     *
     * @param color the color
     * @return the color as text
     */
    public static String getColorAsText(Color color) {
        return color.getRed() + ", " + color.getGreen() + ", " + color.getBlue();
    }

    /**
     * Creates a character node.
     *
     * @param streamWriter the stream writer to create the node on
     * @param localName    the node's localName
     * @param text         the node's text
     * @throws XMLStreamException on XMLStreamException
     */
    private static void createCharacterNode(XMLStreamWriter streamWriter, String localName, String text) throws XMLStreamException {
        streamWriter.writeCharacters(SPACING);
        streamWriter.writeStartElement(localName);

        streamWriter.writeCharacters(text);

        streamWriter.writeEndElement();
        streamWriter.writeCharacters(SEPARATOR);
    }
}
