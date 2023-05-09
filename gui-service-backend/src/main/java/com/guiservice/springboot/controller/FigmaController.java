package com.guiservice.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class FigmaController {

    private String figmaJsonData;
    
    @PostMapping("/process-json")
    public ResponseEntity<String> processFigmaJson(@RequestBody String figmaJson) {

        // Save the JSON string to the variable
        figmaJsonData = figmaJson;

        System.out.println("Figma JSON Data: " + figmaJsonData);

        // TODO: Parse the JSON using Jackson and perform any required processing.
        // ...

        // Return a response.
        return ResponseEntity.ok("JSON processing completed.");
    }

}
