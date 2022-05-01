package com.example.demo.deserializer;

import com.example.demo.entity.Test;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.HashMap;

public class CustomDeserializer extends StdDeserializer<Test> {

    protected CustomDeserializer(Class<?> vc) {
        super(vc);
    }

    public CustomDeserializer() {
        this(null);
    }

    @Override
    public Test deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        var guid = node.get("guid").asText();
        var encoding = node.get("encoding").asText();
        var customData = node.findValuesAsText("customData");
        System.out.println(customData);
//        var map = customDataToMap(customData);
//        StringBuilder sb = getCustomData(customData);
        return new Test(guid, encoding, customData.toString());
    }

    private HashMap<String, Object> customDataToMap(JsonNode customData) {
        var map = new HashMap<String, Object>();
        if (customData != null) {
            var fields = customData.fields();
            while (fields.hasNext()) {
                var field = fields.next();
                map.put(field.getKey(), field.getValue());
            }
        }
        return map;
    }

    private StringBuilder getCustomData(JsonNode nickName) {
        var sb = new StringBuilder();
        if (nickName != null) {
            var fields = nickName.fields();
            if (fields.hasNext()) {
                while (fields.hasNext()) {
                    var field = fields.next();
                    sb.append(field.getKey());
                    sb.append(":");
                    sb.append(field.getValue().asText());
                    sb.append(",");
                }
                sb.deleteCharAt(sb.lastIndexOf(","));
            } else {
                sb.append(nickName.asText());
            }
        }
        return sb;
    }
}
