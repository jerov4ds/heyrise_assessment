package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HelloWorldResource {
    @NotNull
    private String id;

    @NotNull
    private String helloWorldMessage;
}
