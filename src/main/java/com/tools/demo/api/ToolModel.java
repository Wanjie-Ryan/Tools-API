package com.tools.demo.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToolModel {

    private UUID id;
    private String name;
    private Integer quantity;
    private String category;
}
