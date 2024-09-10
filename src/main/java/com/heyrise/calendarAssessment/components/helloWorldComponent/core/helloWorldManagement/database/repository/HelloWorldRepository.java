package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.entity.HelloWorldEntity;

@Repository
public interface HelloWorldRepository extends CrudRepository<HelloWorldEntity, String> {
    
}
