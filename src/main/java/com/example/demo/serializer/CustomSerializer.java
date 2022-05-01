package com.example.demo.serializer;

import com.example.demo.entity.Test;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomSerializer extends StdSerializer<Test> {

    public CustomSerializer() {
        this(null);
    }

    protected CustomSerializer(Class<Test> t) {
        super(t);
    }

    @Override
    public void serialize(Test value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("guid", value.getGuid());
        gen.writeStringField("encoding", value.getEncoding());
        gen.writeStringField("customData", value.getCustomData());
        gen.writeEndObject();
    }
}
