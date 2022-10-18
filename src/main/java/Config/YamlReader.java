package Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;

import java.io.File;
import java.io.IOException;

public class YamlReader {
    @Getter
    Configuration config;
    File file = new File("src/main/resources/config.yml");

    public YamlReader() {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            config = objectMapper.readValue(file, Configuration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}