package sandbox.charset;

/**
 * CP1251 - basic Windows encoding
 * UTF-16LE - JVM standard encoding
 * Created by alterG on 19.05.2017.
 */

import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Default encoding for reading text is default character encoding (system variable file.encoding), depends on operation system and locale
 */
public class MyCharset {
    public static void main(String[] args) {
//      Read text (utf-8) from a file
        StringBuilder string = new StringBuilder();
        try (BufferedReader br = new BufferedReader(getResource("example.txt"))) {
            while (br.ready()) {
                string.append(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String string2 = string.toString();
        byte[] w1251 = string2.getBytes(Charset.forName("windows-1251"));
        byte[] koi8 = string2.getBytes(Charset.forName("KOI8-R"));
        byte[] utf8 = string2.getBytes(Charset.forName("utf-8"));
        String string3 = new String(utf8);

//      Just curiosity
        System.out.println(Charset.defaultCharset());       // default is UTF-8
        System.out.println(Locale.getDefault());

//        Write text (KOI8-R) to file
        try (OutputStream os = new FileOutputStream(".\\resources\\sandbox\\charset\\out.txt")) {
            os.write(utf8);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * Get the resource from resources root
     * @param path
     * @return stream with resource
     */
    private static InputStreamReader getResource(String path) {
        Class<MyCharset> cl = MyCharset.class;
        return new InputStreamReader(cl.getResourceAsStream(path));
    }
}
