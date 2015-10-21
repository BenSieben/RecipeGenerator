import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * The Color Map reader.
 */
public class ColorMapReader {
    public static final String COLOR = "colors";

    /**
     * Do not allow objects of this class to be made.
     */
    private ColorMapReader() {
    }

    /**
     * Loads a theme from a given file location.
     *
     * @param fileLocation the file location
     * @return the theme
     */
    public static boolean load(String fileLocation, Map<String, Color> colorNameToColorMap) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        try {
            InputStream inputStream = new FileInputStream(fileLocation);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(inputStream, "UTF-8");

            // read the XML document
            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if(event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    // if we found COLOR start
                    if(startElement.getName().getLocalPart().equals(COLOR)) {
                        continue;
                    }

                    // start adding fields
                    if(event.isStartElement()) {
                        String colorName = event.asStartElement().getName().getLocalPart();
                        if(colorNameToColorMap.containsKey(colorName)) {
                            event = eventReader.nextEvent();

                            Color color = getColor(event);
                            if(color != null) {
                                colorNameToColorMap.put(colorName, color);
                            }

                            continue;
                        }
                    }

                    // if we reach the end of a COLOR, we stop reading data
                    if(event.isEndElement()) {
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equals(COLOR)) {
                            break;
                        }
                    }
                }
            }

            eventReader.close();
            inputStream.close();

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
     * Gets a color from the event.
     *
     * @param event the event
     * @return color on success, null on failure
     */
    private static Color getColor(XMLEvent event) {
        String colorValues = getString(event);
        String colorArr[] = colorValues.split(", ");
        if(colorArr.length == 3) {
            // check that the colors are a legal value
            boolean areLegalColors = true;
            for(String colorValue : colorArr) {
                if(colorValue.matches("\\d+")) {
                    if(Integer.parseInt(colorValue) > 255) {
                        areLegalColors = false;

                        break;
                    }
                }
                else {
                    areLegalColors = false;

                    break;
                }
            }

            if(areLegalColors) {
                return new Color(Integer.parseInt(colorArr[0]), Integer.parseInt(colorArr[1]), Integer.parseInt(colorArr[2]));
            }
        }

        return null;
    }

    /**
     * Gets the string of an event.
     *
     * @param event the event
     * @return the string
     */
    private static String getString(XMLEvent event) {
        // make sure event has something in it
        if(event != null && event.isCharacters()) {
            return event.asCharacters().getData();
        }

        return "";
    }
} 
