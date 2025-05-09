package utils;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public enum ResourceUtil {
    INSTANCE;

    public String getResourceFileAsJson(String resourceName) throws IOException {
        URL url = Resources.getResource(resourceName);
        return Resources.toString(url, StandardCharsets.UTF_8);
    }
}
