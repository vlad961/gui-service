package com.guiservice.service;

import java.io.FileWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;

import com.guiservice.model.FigmaComponent;

public class AngularComponentGenerator {
    
    private final VelocityEngine velocityEngine;

    @Autowired
    public AngularComponentGenerator() {
        this.velocityEngine = new VelocityEngine();
    }

    public void generateTemplates(List<FigmaComponent> figmaComponents) {
        velocityEngine.init("gui-service/gui-service-backend/src/main/resources/velocity.properties");
        Template template;
        VelocityContext context = new VelocityContext();
        StringWriter writer = new StringWriter();

        for (FigmaComponent figmaComponent : figmaComponents) {
            if (isButton(figmaComponent)) {
                String templateFilePath = figmaComponent.getName() + ".vm";
                template = velocityEngine.getTemplate(templateFilePath);
                context.put("message", figmaComponent.getName());
                context.put("blabla", figmaComponent.getType());
                template.merge(context, writer);
                String generatedOutput = writer.toString();
                String outputFile = "gui-service/gui-service-backend/src/main/resources/templates/output/"
                        + figmaComponent.getName() + ".html";
                try {
                    FileWriter fileWriter = new FileWriter(outputFile);
                    fileWriter.write(generatedOutput);
                    fileWriter.close();
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("Error generating Button Template: " + e);
                }
            }
        }
    }

    public void generateLabelTemplate(FigmaComponent input) {

    }

    void generateButtonTemplate(FigmaComponent input) {
        if (isButton(input)) {
            String buttonName = getText(input);
        }
    }

    String getText(FigmaComponent component) {
        for (FigmaComponent childFigmaComponent : component.getChildren()) {
            if (childFigmaComponent.getType().equals("TEXT")) {
                return childFigmaComponent.getName();
            }
        }
        return "";
    }

    static boolean isButton(FigmaComponent component) {
        return component.getType().equals("COMPONENT") && component.getName().equals("Button");
    }

    boolean isTextField(FigmaComponent component) {
        return component.getType().equals("COMPONENT") && component.getName().equals("Text Field");
    }

    boolean isLabel(FigmaComponent component) {
        return component.getType().equals("COMPONENT") && component.getName().equals("Label");
    }

    boolean isHeader(FigmaComponent component) {
        return component.getType().equals("COMPONENT") && component.getName().equals("Header");
    }
}
