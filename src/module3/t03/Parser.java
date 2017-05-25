package module3.t03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alterG on 25.05.2017.
 */
public class Parser {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(getResource("web.html"));
        skipMarkToBody(reader);
        Pattern pictureNumerationPattern = Pattern.compile("pic(\\d+)\\.jpg");
        Pattern picturePattern = Pattern.compile("(<div>)?(<p>)?(.*\\b[pР]ис(унк)?[а-я]*.*)((</div>)|(</p>)|(</html>)|(<br>))+");
        boolean isValidNumeration = true;
        int prevPicNumber = 0;  // pictures are numerated from 1
        int count = 0;
        while (reader.ready()) {
            String string = reader.readLine();
            Matcher m1 = pictureNumerationPattern.matcher(string);
            Matcher m2 = picturePattern.matcher(string);
                if (m2.find()){
                System.out.println(m2.group(3));
                count++;
            }
            if (m1.find()) {
                int currentPicNumber = Integer.parseInt(m1.group(1));
                if (currentPicNumber == prevPicNumber +1) {
                    prevPicNumber = currentPicNumber;
                } else {
                    isValidNumeration = false;
                    break;
                }
            }
        }
        if (isValidNumeration) System.out.println(String.format("Picture numeration is valid (%d pictures, %d strings).", prevPicNumber, count));
        else System.out.println("Picture numeration is not valid.");
    }

    private static InputStreamReader getResource(String path) {
        Class<Parser> cl = Parser.class;
        return new InputStreamReader (cl.getResourceAsStream(path), Charset.forName("windows-1251"));
    }

    private static void skipMarkToBody(BufferedReader reader) throws IOException {
        while (reader.ready()) {
            if (reader.readLine().contains("<body>")) break;
        }
        return;
    }
}
