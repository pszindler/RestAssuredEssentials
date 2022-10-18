package Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class App {
    Map<String, Object> properties = new HashMap<>();

    @JsonAnySetter
    public void setAppProperties(String key, Object value) {
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getAppProperties() {
        return properties;
    }
}