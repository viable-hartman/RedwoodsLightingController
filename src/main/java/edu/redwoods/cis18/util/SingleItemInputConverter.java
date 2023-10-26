package edu.redwoods.cis18.util;

import com.gluonhq.connect.converter.InputStreamInputConverter;
import com.gluonhq.connect.converter.JsonConverter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;

public class SingleItemInputConverter<T> extends InputStreamInputConverter<T> {

    private final JsonConverter<T> jsonConverter;

    public SingleItemInputConverter(Class<T> targetClass) {
        this.jsonConverter = new JsonConverter<>(targetClass);
    }

    @Override
    public T read() {
        try (JsonReader reader = Json.createReader(getInputStream())) {
            return jsonConverter.readFromJson(reader.readObject());
        }
    }
}
