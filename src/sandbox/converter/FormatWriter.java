package sandbox.converter;

import org.json.JSONObject;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Created by alterG on 06.06.2017.
 */
public class FormatWriter {

    public static void writeXML(Document xmlDocument, File outputFile) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(xmlDocument), new StreamResult(outputFile));
        try {
            FileReader reader = new FileReader(outputFile);
            char[] bufferArray = new char[(int) outputFile.length()];
            reader.read(bufferArray);
            String source = new String(bufferArray);
            rewriteXMLInPrettyFormat(source, outputFile);
        } catch (Exception e) {
            throw new Exception("Can't write xml file.");
        }
    }

    /**
     * rewrite xml file in human-readable format
     *
     * @param source to write in file
     * @param file   to rewrite
     * @throws Exception
     */
    private static void rewriteXMLInPrettyFormat(String source, File file) throws Exception {
        try {
            final int indent = 4;
            Source xmlInput = new StreamSource(new StringReader(source));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            String result = xmlOutput.getWriter().toString();
            FileWriter writer = new FileWriter(file);
            writer.write(result);
            writer.close();
        } catch (Exception e) {
            throw new Exception("Can't rewrite JSON to pretty format.");
        }
    }

    /**
     * write proto object in string format to file
     *
     * @param source     string representation of proto object
     * @param outputFile to write
     * @throws IOException
     */
    public static void writeProtobuff(PeopleProtos.People source, File outputFile) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(source.toString());
        } catch (IOException e) {
            throw new IOException("Can't write protobuff file.");
        }
    }

    /**
     * write string to file
     *
     * @param source     to write
     * @param outputFile to write
     * @throws IOException
     */
    public static void writeText(String source, File outputFile) throws IOException {
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(source);
        } catch (IOException e) {
            throw new IOException("Can't write text file.");
        }
    }

    /**
     * write json object to file in human-readable format
     *
     * @param jsonObject
     * @param outputFile
     * @throws IOException
     */
    public static void writeJSON(JSONObject jsonObject, File outputFile) throws IOException {
        int spacesToIndentEachLevel = 1;
        String prettyJSON = jsonObject.toString(spacesToIndentEachLevel);
        try {
            FileWriter writer = new FileWriter(outputFile);
            writer.write(prettyJSON);
            writer.close();
        } catch (IOException e) {
            throw new IOException("Can't write JSON file.");
        }
    }

}
