package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "hello_world")
public class HelloWorldEntity {
    
    @Id
    protected String id;

    @Column(nullable = false)
    private String helloWorldMessage;
}
