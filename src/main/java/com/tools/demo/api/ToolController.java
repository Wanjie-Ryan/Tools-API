package com.tools.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tools")
public class ToolController {

    private ToolService toolservice;

    @Autowired
    public ToolController(ToolService toolservice) {
        this.toolservice = toolservice;
    }

    @PostMapping

    public ResponseEntity <ToolResponse> createTool(@RequestBody ToolModel tool){

        ToolModel tools = toolservice.createTool(tool);
        ToolResponse response = new ToolResponse("Tool was created successfully", tools);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<ToolResponse>> getAllTools() {
        List<ToolModel> allTools = toolservice.getAllTools();
        List<ToolResponse> responses = allTools.stream()
                .map(tool -> new ToolResponse("Tool Details", tool))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path="{id}")

    public ResponseEntity <ToolResponse> getToolById(@PathVariable ("id") String id){

        ToolModel tools = toolservice.getToolById(id);
        ToolResponse response = new ToolResponse("Single Tools is ", tools);
         return ResponseEntity.ok(response);

    }





}
