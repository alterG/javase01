package sandbox.converter;

import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.util.JsonFormat.Parser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sandbox.converter.PeopleProtos.Message;
import sandbox.converter.PeopleProtos.People;
import sandbox.converter.PeopleProtos.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FormatConverter {
    // All output files are located in source directory
    private static final File inputTextFile = getFile("input.txt");
    private static final File outputXMLFile = new File("result/people_XML.xml");
    private static final File outputJSONFile = new File("result/people_JSON.json");
    private static final File outputProtoBuffFile = new File("result/people_ProtoBuff.txt");
    private static final File outputTextFile = new File("result/people_ProtoBuff_text.txt");
    private static final File outputParsedJSONtoProtoFile = new File("result/people_JSON_parsed.json");

    public static void main(String[] args) {
        try {

            // Convert text into xml
            Document xmlDocument = parseXML(inputTextFile);
            FormatWriter.writeXML(xmlDocument, outputXMLFile);

            // Convert xml into json
            String XMLString = readFile(outputXMLFile);
            JSONObject jsonObject = XML.toJSONObject(XMLString);
            FormatWriter.writeJSON(jsonObject, outputJSONFile);

            // Change json for identification by proto parser
            JSONObject parsed = parseJSONforProtoStruct(jsonObject);
            FormatWriter.writeJSON(parsed, outputParsedJSONtoProtoFile);

            // Convert json to protobuf
            People message = getProtoBuffFromJson(outputParsedJSONtoProtoFile);
            FormatWriter.writeProtobuff(message, outputProtoBuffFile);

            // Convert protobuf to simple text
            String text = getTextFromProtoBuff(message);
            FormatWriter.writeText(text, outputTextFile);

            System.out.println("Program has finished successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * parse text file to Document, which represents XML file
     *
     * @param inputFile to parse into Document
     * @return xml document
     * @throws Exception
     */
    private static Document parseXML(File inputFile) throws Exception {
        final String rootTag = "persons";
        final String rootChild = "person";

        try {
            String source = readFile(inputFile);
            List<String> peopleArray = getPersonList(source);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document xmlDocument = docBuilder.newDocument();

            Element rootElement = xmlDocument.createElement(rootTag);
            xmlDocument.appendChild(rootElement);

            for (String person : peopleArray) {
                Element xmlElement = xmlDocument.createElement(rootChild);
                appendPerson(xmlDocument, xmlElement, person);
                rootElement.appendChild(xmlElement);
            }
            return xmlDocument;
        } catch (Exception e) {
            throw new Exception("Can't parse xml file");
        }
    }

    /**
     * Parse string line "x: y"
     *
     * @param line to parse
     * @return "key" value
     */
    private static String getKey(String line) {
        return line.split(": ")[0].toLowerCase();
    }

    /**
     * Parse string line "x: y"
     *
     * @param line to parse
     * @return "value" value
     */
    private static String getValue(String line) {
        return line.split(": ")[1];
    }

    /**
     * parse string to find person elements
     *
     * @param source string to parse
     * @return List collection with person elements
     */
    private static List<String> getPersonList(String source) {
        List<String> lines = Arrays.asList(source.split("\n"));

        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line.isEmpty()) {
                result.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(line + "\n");
            }
        }
        result.add(stringBuilder.toString());
        return result;
    }

    /**
     * Add person element to document
     *
     * @param document    to add person
     * @param rootElement parent element
     * @param source      to parse
     */
    private static void appendPerson(Document document, Element rootElement, String source) {
        List<String> txtFields = Arrays.asList(source.split("\n"));
        boolean isMessagesTag = false;

        for (int i = 0; i < txtFields.size(); ++i) {
            String line = txtFields.get(i);
            if (isNumber(line))
                continue;

            if ("Messages:".equals(line)) {
                Element xmlElement = document.createElement("messages");
                rootElement.appendChild(xmlElement);
                rootElement = xmlElement;
                isMessagesTag = true;
                continue;
            }

            if (isMessagesTag) {
                String[] messageElements = new String[]{line, txtFields.get(++i)};
                appendMessageElement(document, rootElement, messageElements);
            } else {
                String key = getKey(line);
                if ("admin".equals(key)) {
                    key = "isAdmin";
                }
                Element xmlElement = document.createElement(key);
                xmlElement.appendChild(document.createTextNode(getValue(line)));
                rootElement.appendChild(xmlElement);
            }
        }
    }

    /**
     * Add message to document
     *
     * @param document        to add message
     * @param rootElement     parent element
     * @param messageElements string lines to get key and value
     */
    private static void appendMessageElement(Document document, Element rootElement, String[] messageElements) {
        Element messageElement = document.createElement("message");
        rootElement.appendChild(messageElement);
        for (int i = 0; i < messageElements.length; i++) {
            String key = getKey(messageElements[i]);
            String value = getValue(messageElements[i]);
            Element element = document.createElement(key);
            element.appendChild(document.createTextNode(value));
            messageElement.appendChild(element);
        }
    }

    /**
     * Get protobufs from json file
     *
     * @param inputFile in json format
     * @return class generated by proto-file
     * @throws Exception
     */
    private static People getProtoBuffFromJson(File inputFile) throws IOException {
        JsonFormat.TypeRegistry.Builder typeRegisterBuilder = JsonFormat.TypeRegistry.newBuilder();
        typeRegisterBuilder.add(People.newBuilder().getDescriptorForType());
        Parser parser = JsonFormat.parser();
        parser.ignoringUnknownFields();
        parser.usingTypeRegistry(typeRegisterBuilder.build());
        People.Builder peopleBuilder = People.newBuilder();
        try {
            String jsonString = readFile(inputFile);
            parser.merge(jsonString, peopleBuilder);
        } catch (IOException e) {
            throw new IOException("Can't parse json to protobuff file.");
        }
        People protoMessage = peopleBuilder.build();
        return protoMessage;
    }

    /**
     * Json object from xml file need to be changed for current protobuff file
     *
     * @param jsonObject input json object
     * @return fixed json object for convert to protobuff
     */
    private static JSONObject parseJSONforProtoStruct(JSONObject jsonObject) {
        final String rootKey = "persons";
        JSONObject rootValue = jsonObject.getJSONObject(rootKey);
        JSONArray persons = rootValue.getJSONArray("person");
        JSONArray[] messagesArray = new JSONArray[persons.length()];
        JSONArray newPersons = new JSONArray();
        for (int i = 0; i < persons.length(); i++) {
            JSONObject currentPerson = persons.getJSONObject(i);
            messagesArray[i] = currentPerson.getJSONObject("messages").getJSONArray("message");
            JSONObject newPerson = new JSONObject(currentPerson);
            for (String key : currentPerson.keySet()) {
                newPerson.put(key, currentPerson.get(key));
            }
            currentPerson.remove("messages");
            newPerson.put("messages", messagesArray[i]);
            newPersons.put(newPerson);
        }
        JSONObject result = new JSONObject();
        result.put(rootKey, newPersons);
        return result;
    }

    /**
     * Parse proto class to simple human-readable text
     *
     * @param message proto class to parse
     * @return parsed string
     */
    private static String getTextFromProtoBuff(People message) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Person> personsList = message.getPersonsList();
        for (int i = 0; i < personsList.size(); i++) {
            stringBuilder.append("Name: " + personsList.get(i).getName() + "\n" +
                    "Surname: " + personsList.get(i).getSurname() + "\n" +
                    "Id: " + personsList.get(i).getId() + "\n" +
                    "Admin: " + personsList.get(i).getIsAdmin() + "\n");
            List<Message> messageList = personsList.get(i).getMessagesList();
            if (!messageList.isEmpty()) {
                stringBuilder.append("Messages:\n");
            }
            for (int j = 0; j < messageList.size(); j++) {
                stringBuilder.append(
                        (j + 1) + "\n" +
                                "ID: " + messageList.get(j).getId() + "\n" +
                                "Text: " + messageList.get(j).getText() + "\n");
            }
            if (i < personsList.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * read file to String
     *
     * @param file to read
     * @return String file content
     * @throws IOException
     */
    private static String readFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        char[] readBuffer = new char[(int) file.length()];
        reader.read(readBuffer);
        String fileContent = new String(readBuffer);
        return fileContent;
    }

    private static File getFile(String name) {
        Class<FormatConverter> cl = FormatConverter.class;
        return new File(cl.getResource(name).getFile());
    }

    /**
     * @param strNum string to check
     * @return true if string contains only number
     */
    private static boolean isNumber(String strNum) {
        boolean ret = true;
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

}
