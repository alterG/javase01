package sandbox.imagesaver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alterG on 16.06.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        InputStream is = useIRlCoonnection("horstmann.com");
        String html = readFromInputStream(is);
        List<URL> imageList = getImagesUrlList(html);
        for (int i = 0; i < imageList.size(); i++) {
            BufferedImage image = ImageIO.read(imageList.get(i));
            String add = "img" + i + ".png";
            ImageIO.write(image, "png", new File(add));
        }
        System.out.println("ok");
    }

    private static List<URL> getImagesUrlList(String source) throws MalformedURLException {
        Pattern pattern = Pattern.compile("<img[^>]*src=\"([^\"]+)");
        List<URL> result = new ArrayList<>();
        Matcher m = pattern.matcher(source);
        while (m.find()) {
            String imageSrc = m.group(1);
            int offset = m.end();
            result.add(new URL("http://horstmann.com//" + imageSrc));
            source = source.substring(offset);
            m = pattern.matcher(source);
        }
        return result;
    }

    private static InputStream useIRlCoonnection(String urlStr) throws IOException {
        URL url = new URL("http://" + urlStr);
        URLConnection urlConnection = url.openConnection();
        return urlConnection.getInputStream();
    }

    private static String readFromInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(is);
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }
        sc.close();
        return sb.toString();
    }


}
