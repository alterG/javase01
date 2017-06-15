package module6.t02;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alterG on 15.06.2017.
 */
public class PropertyManager {
    private Map<String, String> storage;
    private Properties properties;

    public PropertyManager() {
        properties = new Properties();
        storage = new HashMap<>();
    }

    public void loadFromFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        properties.load(fr);
        fr.close();
        for (String key : properties.stringPropertyNames()) {
            storage.put(key, properties.getProperty(key));
        }
    }

    public String getValue(String key) throws IllegalArgumentException {
        if (!storage.containsKey(key)) {
            throw new IllegalArgumentException("File doesn't contain this key.");
        }
        return storage.get(key);
    }
}
