package com.example.demo.entity;

import com.example.demo.deserializer.CustomDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = CalendarSerializer.class)
@JsonDeserialize(using = CustomDeserializer.class)
public class Test {
    private String guid;
    private String encoding;
    private String customData;
}
