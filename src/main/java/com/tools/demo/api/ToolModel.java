package com.tools.demo.api;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tool")
public class ToolModel {

    @Id
    private UUID id;
    private String name;
    private Integer quantity;
    // I utilized the enum class that I created to define that the category will only allow Home, Work, and Farm
    private Category category;

    @PrePersist
    public void generateId(){
        if(this.id == null){
            this.id = UUID.randomUUID();
        }
    }


}
