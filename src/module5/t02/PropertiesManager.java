package module5.t02;

import sun.plugin.dom.exception.WrongDocumentException;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by alterG on 31.05.2017.
 */
public class PropertiesManager {
    final static Pattern localeSeparator = Pattern.compile(".*_?([a-zA-Z]*)_?([a-zA-Z]*)\\b");
    private Map<String, String> storage;
    private File file;


    public PropertiesManager(String relativePath) throws WrongDocumentException {
        this.file = new File(relativePath);
        ResourceBundle bundle = getResourceBundleFromFile(relativePath);
        storage = new HashMap<>();
        for (String key : bundle.keySet()) {
            storage.put(key, bundle.getString(key));
        }
    }

    public String getValue(String key) throws IllegalArgumentException {
        if (!storage.containsKey(key)) {
            throw new IllegalArgumentException("File doesn't contain this key.");
        }
        return storage.get(key);
    }

    private ResourceBundle getResourceBundleFromFile(String relativePath) throws WrongDocumentException {
        ResourceBundle bundle;
        Properties properties = new Properties();
        if (!relativePath.contains(".properties")) {
            throw new WrongDocumentException("File isn't a property file.");
        }
        int lastIndex = relativePath.indexOf(".properties");
        relativePath = relativePath.substring(0, lastIndex);
        String[] splittedSource = relativePath.split("_");
        if (splittedSource.length == 1) {
            bundle = ResourceBundle.getBundle(splittedSource[0]);
        } else if (splittedSource.length == 2) {
            bundle = ResourceBundle.getBundle(splittedSource[0], new Locale(splittedSource[1]));
        } else {
            String fileName = "";
            for (int i = 0; i < splittedSource.length - 2; i++) {
                fileName += splittedSource[i];
            }
            int length = splittedSource.length;
            bundle = ResourceBundle.getBundle(fileName, new Locale(splittedSource[length - 2], splittedSource[length - 1]));
        }
        return bundle;
    }

    public static String getRelativePath(String path) {
        File rootDirFile = new File("");
        String rootPath = rootDirFile.getAbsolutePath();
        if (path.contains(rootPath)) {
            int endIndex = path.lastIndexOf(rootPath) + rootPath.length();
            path = path.substring(endIndex + 1, path.length());
        }
        // kind of crutch, works only for root, src and resource directories
        final String srcName = "src";
        final String resName = "resources";
        if (path.contains(srcName)) {
            int endIndex = path.lastIndexOf(srcName) + srcName.length();
            path = path.substring(endIndex + 1, path.length());
        } else if (path.contains(resName)) {
            int endIndex = path.lastIndexOf(resName) + resName.length();
            path = path.substring(endIndex + 1, path.length());
        }
        return path;
    }
}
