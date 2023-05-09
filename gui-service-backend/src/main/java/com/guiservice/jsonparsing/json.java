package com.guiservice.jsonparsing;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Json {
    
    private static ObjectMapper objectMapper = getDefauObjectMapper();

    private static ObjectMapper getDefauObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        // TODO: Implement configuration possibilites
        // defaultObjectMapper.configure(DeserializationFeature.)


        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException {
        
        return objectMapper.treeToValue(node, clazz);
    }
}
