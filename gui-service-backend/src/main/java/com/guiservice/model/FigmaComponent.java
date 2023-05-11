package com.guiservice.model;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Java representation of a Figma component
 */
public class FigmaComponent {
    /** The component type */
    private String type;

    /** The component name */
    private String name;

    /** The component position */
    private Position position;

    /** The component size */
    private Size size;

    /** The component children */
    private List<FigmaComponent> children;
    
    /**
     * Returns the component type
     * 
     * @return the component type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the component type
     * 
     * @param type the component type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the component name
     * 
     * @return the component name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the component name
     * 
     * @param name the component
     */
    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<FigmaComponent> getChildren() {
        return children;
    }

    public void setChildren(List<FigmaComponent> children) {
        this.children = children;
    }

    /**
     * Figma component position relative to the parent frame
     */
    public static class Position {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    /**
     * Figma component size
     */
    public static class Size {
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

    }
    
}
