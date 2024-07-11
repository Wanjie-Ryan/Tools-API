package com.tools.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.Tool;
import java.util.List;
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

    // GETTING ALL TOOLS LOGIC

    public List <ToolModel> getAllTools (){

        List<ToolModel> tool = repository.findAll();

        if(tool.isEmpty()){
            throw new IllegalStateException("No tools found");
        }

        return tool;

    }

    // GET BY ID

    public ToolModel getToolById(String id){
        Optional <ToolModel> tool = repository.findById(UUID.fromString(id));

        if(!tool.isPresent()){
            throw new IllegalStateException("Tool of id " + id + " does not exist");
        }

        return tool.get();
    }


}
