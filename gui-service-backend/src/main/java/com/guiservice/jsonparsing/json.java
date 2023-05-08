package com.guiservice.jsonparsing;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class json {
    
    private static ObjectMapper objectMapper = getDefauObjectMapper();

    private static ObjectMapper getDefauObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        // TODO: Implement configuration possibilites
        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException {
        
        return objectMapper.treeToValue(node, clazz);
    }
}
