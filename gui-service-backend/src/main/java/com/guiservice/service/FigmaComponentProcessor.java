package com.guiservice.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.guiservice.model.FigmaComponent;

public class FigmaComponentProcessor {
    
    public FigmaComponent processJsonNode(JsonNode node) {
        FigmaComponent component = new FigmaComponent();

        component.setName(node.get("name").asText());
        component.setType(node.get("type").asText());
        
        JsonNode boundingBoxNode = node.get("absoluteBoundingBox");
        // Set position
        FigmaComponent.Position position = new FigmaComponent.Position();
        position.setX(boundingBoxNode.get("x").asInt());
        position.setY(boundingBoxNode.get("y").asInt());
        component.setPosition(position);
        // Set size
        FigmaComponent.Size size = new FigmaComponent.Size();
        size.setWidth(boundingBoxNode.get("width").asInt());
        size.setHeight(boundingBoxNode.get("height").asInt());
        component.setSize(size);

        // Set children
        List<FigmaComponent> children = new ArrayList<>();
        if (node.has("children")) {
            for (JsonNode child : node.get("children")) {
                FigmaComponent childComponent = processJsonNode(child);
                children.add(processJsonNode(child));
            }
        }
        component.setChildren(children);

        return component;
    }
}
