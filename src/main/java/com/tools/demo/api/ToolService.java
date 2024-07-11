package com.tools.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ToolService {

    private ToolRepository repository;

    @Autowired
    public ToolService(ToolRepository repository) {
        this.repository = repository;
    }

    // CREATING A TOOL LOGIC

    public ToolModel createTool(ToolModel tool){

        // check if the tool exists by checking the existence of it by its name.
        Optional<ToolModel> toolName = repository.findToolByName(tool.getName());

        // if tool name exists then throw an exception

        if(toolName.isPresent()){
            throw new IllegalStateException("Tool name already exists");
        }

        return repository.save(tool);


    }


}
