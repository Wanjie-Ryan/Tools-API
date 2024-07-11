package com.tools.demo.api;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// you specify the type of entity and the type of its primary key that the repository will handle
@Repository
public interface ToolRepository extends JpaRepository<ToolModel, UUID> {
}
