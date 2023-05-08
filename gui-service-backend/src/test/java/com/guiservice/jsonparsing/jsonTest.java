package com.guiservice.jsonparsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.guiservice.jsonparsing.pojo.SimpleTestCaseJsonPOJO;

public class jsonTest {

    private String simpleTestCaseJsonSource = "{  \"title\": \"GUI Service\"}";

    @Test
    void testParse() throws IOException {

        JsonNode node = json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "GUI Service");
    }

    @Test
    void testFromJson() throws IOException {
        
        JsonNode node = json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(), "GUI Service");
    }
}
