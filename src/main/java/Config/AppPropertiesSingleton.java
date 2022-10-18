package Config;

import Model.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public final class AppPropertiesSingleton {
    private static AppPropertiesSingleton INSTANCE;
    static Logger logger = LoggerFactory.getLogger(AppPropertiesSingleton.class);
    YamlReader yamlReader = new YamlReader();

    private AppPropertiesSingleton() {
        setAppProperties();
    }

    private void setAppProperties() {
        App app = yamlReader.getConfig().getApp();
        Map<String, Object> appProperties = app.getAppProperties();
        for (Map.Entry<String, Object> entry : appProperties.entrySet()) {
            System.setProperty(entry.getKey(), entry.getValue().toString());
            logger.info("App properties: {} = {}", entry.getKey(), entry.getValue().toString());
        }
    }

    public static AppPropertiesSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppPropertiesSingleton();
        }
        return INSTANCE;
    }
}
