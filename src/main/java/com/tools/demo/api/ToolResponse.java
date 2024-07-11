package com.tools.demo.api;

public class ToolResponse {

    private String message;
    private ToolModel tool;

    public ToolResponse(String message, ToolModel tool) {
        this.message = message;
        this.tool = tool;
    }

    public String getMessage() {
        return message;
    }

    public ToolModel getTool() {
        return tool;
    }
}
