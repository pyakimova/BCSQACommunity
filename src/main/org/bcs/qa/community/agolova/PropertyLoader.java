package agolova;

import jdk.internal.joptsimple.internal.Strings;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Properties;

//получаем свойства из указанного файла properties
public class PropertyLoader {
    private static final String PROPERTIES_FILE = "/config.properties";
    private static final Properties PROPERTIES = getPropertiesInstance();
    private static final Properties PROFILE_PROPERTIES = getProfilePropertiesInstance();

    private PropertyLoader() {
    }

   //Возвращает значение дефолтного свойства
    public static String loadPropertyCustom(String propertyName, String defaultValue) {
        String value = tryLoadProperty(propertyName);
        return value != null ? value : defaultValue;
    }

    //Возвращает свойство из property по названию файла (дефолтный файл)
    public static String loadPropertyDefault(String propertyName) {
        String value = tryLoadProperty(propertyName);
        if (null == value) {
            throw new IllegalArgumentException("В файле config.properties не найдено значение по ключу: " + propertyName);
        }
        return value;
    }

   //Возвращает значенеи свойства из property-файла по его названию
    public static String getPropertyOrValue(String propertyNameOrValue) {
        return loadProperty(propertyNameOrValue, propertyNameOrValue);
    }

    private static Properties getProfilePropertiesInstance() {
        Properties instance = new Properties();
        String profile = System.getProperty("profile", "");
        if (!Strings.isNullOrEmpty(profile)) {
            String path = Paths.get(profile, PROPERTIES_FILE).toString();
            URL url = PropertyLoader.class.getClassLoader().getResource(path);
            try (
                    InputStream resourceStream = url.openStream();
                    InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
            ) {
                instance.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static String tryLoadProperty(String propertyName) {
        String value = null;
        if (!Strings.isNullOrEmpty(propertyName)) {
            value = PROFILE_PROPERTIES.getProperty(propertyName);

            if (null == value) {
                value = PROPERTIES.getProperty(propertyName);
            }
        }
        return value;
    }

    private static Properties getPropertiesInstance() {
        Properties instance = new Properties();
        try (
                InputStream resourceStream = PropertyLoader.class.getResourceAsStream(PROPERTIES_FILE);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
        ) {
            instance.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }
    public static String loadProperty(String propertyName, String defaultValue) {
        String value = tryLoadProperty(propertyName);
        return value != null ? value : defaultValue;
    }
}
