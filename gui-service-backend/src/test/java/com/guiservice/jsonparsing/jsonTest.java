package com.guiservice.jsonparsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.guiservice.jsonparsing.pojo.DayPOJO;
import com.guiservice.jsonparsing.pojo.SimpleTestCaseJsonPOJO;

public class jsonTest {

    private String simpleTestCaseJsonSource = "{ \n" +
        " \"title\": \"GUI Service\", \n" +
        " \"author\": \"Vlad\"\n" +
    "}";

    private String dayScenario1 = "{ \n" +
    " \"date\": \"2023-05-09\", \n" +
    " \"name\": \"Random Day\"\n" +
    "}";

    @Test
    void testParse() throws IOException {

        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "GUI Service");
    }

    @Test
    void testFromJson() throws IOException {
        
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = Json.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(), "GUI Service");
    }

    @Test
    void dayTestScenario1() throws IOException {
        
        JsonNode node = Json.parse(dayScenario1);
        DayPOJO pojo = Json.fromJson(node, DayPOJO.class);

        assertEquals("2023-05-09", pojo.getDate().toString());
    }
}
