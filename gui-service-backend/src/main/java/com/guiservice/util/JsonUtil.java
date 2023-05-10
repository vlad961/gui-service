package com.guiservice.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {
    
    private static ObjectMapper objectMapper = getDefauObjectMapper();

    private static ObjectMapper getDefauObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.registerModule(new JavaTimeModule());
        
        // TODO: Implement configuration possibilites
        // defaultObjectMapper.configure(DeserializationFeature.)
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties like Jörg sugested


        return defaultObjectMapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException {
        
        return objectMapper.treeToValue(node, clazz);
    }

    public static List<List<JsonNode>> extractFrameComponents(String figmaJson) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(figmaJson);

        JsonNode documentNode = rootNode.path("__zone_symbol__value").path("document");
        List<List<JsonNode>> frameComponents = getFrameComponents(documentNode);

        return frameComponents;
    }

    private static List<List<JsonNode>> getFrameComponents(JsonNode node) {
        List<List<JsonNode>> frameComponents = new ArrayList<>();
        findFrameComponents(node, frameComponents);
        return frameComponents;
    }

    private static void findFrames(JsonNode node, List<JsonNode> frames) {
        if ("FRAME".equals(node.path("type").asText())) {
            frames.add(node);
        }

        JsonNode children = node.path("children");
        for (JsonNode child : children) {
            findFrames(child, frames);
        }
    }

    public static void findFrameComponents (JsonNode node, List<List<JsonNode>> frameComponents) {
        if ("FRAME".equals(node.path("type").asText())) {
            List<JsonNode> components = new ArrayList<>();
            node.path("children").forEach(components::add);
            frameComponents.add(components);
        }

        JsonNode children = node.path("children");
        for (JsonNode child : children) {
            findFrameComponents(child, frameComponents);
        }
    }
}
