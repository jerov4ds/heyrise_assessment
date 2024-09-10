package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class HelloWorldDto {
    
    @NotNull
    private String helloWorldMessage;

}
