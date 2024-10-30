package io.github.defective4.ham.ituresolver;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CountryResolver {

    public static final String DEFAULT_COUNTRY_NAME = "Unknown";

    private final Map<String, String> codes = new LinkedHashMap<>();

    public CountryResolver(JsonObject root) {
        for (Map.Entry<String, JsonElement> entry : root.entrySet()) if (entry.getValue() instanceof JsonArray) {
            JsonArray arr = (JsonArray) entry.getValue();
            for (JsonElement el : arr) {
                String[] split = el.getAsString().split("-");
                if (split.length == 1) {
                    codes.put(split[0], entry.getKey());
                } else {
                    for (String code : StringRangeResolver.resolve(split[0], split[1])) codes.put(code, entry.getKey());
                }
            }
        }
    }

    public String resolve(String callsign) {
        for (Map.Entry<String, String> entry : codes.entrySet())
            if (callsign.toUpperCase().startsWith(entry.getKey())) return entry.getValue();
        return DEFAULT_COUNTRY_NAME;
    }

}
