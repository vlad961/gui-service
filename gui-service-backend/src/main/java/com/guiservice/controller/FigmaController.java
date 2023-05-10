package com.guiservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.guiservice.util.JsonUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class FigmaController {

    private String figmaJsonData;
    
    @PostMapping("/process-json")
    public ResponseEntity<String> processFigmaJson(@RequestBody String figmaJson) {

        // TODO: Segment into canvases

        // Save the JSON string to the variable
        figmaJsonData = figmaJson;
        // System.out.println("Figma JSON Data: " + figmaJsonData);

        try {
            List<List<JsonNode>> frameComponents = JsonUtil.extractFrameComponents(figmaJson);

            System.out.println("Number of Frames in JSON: " + frameComponents.size());

            for (List<JsonNode> componentsOfFrame : frameComponents) {
                System.out.println("NUMBER OF COMPONENTS IN FRAME: " + componentsOfFrame.size());
                for (JsonNode component : componentsOfFrame) {
                    System.out.println(component);
                    System.out.println("----------------------------------------------------------------------------");
                }
            }

            // TODO: Parse the JSON using Jackson and perform any required processing.
            // ...
            return ResponseEntity.ok("JSON processing completed.");
        } catch (IOException exc) {
            exc.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("JSON processing failed.");
        }
        
    }

}
