package com.heyrise.calendarAssessment.components.helloWorldComponent.restController;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.HelloWorldDataService;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.dto.HelloWorldDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.resource.HelloWorldResource;

@RestController
@RequestMapping("/api/v1")
public class HelloWorldRestController {
    @Autowired
    private HelloWorldDataService helloWorldDataService;

    
    @GetMapping("/helloWorld")
    public HelloWorldResource getHelloWorldMessage () {

        return helloWorldDataService.getHelloWorldMessage();

    }

    @PostMapping("/helloWorld")
    public HelloWorldResource setHelloWorldMessage (
            @Valid @RequestBody HelloWorldDto helloWorldDto
    ) {

        return helloWorldDataService.setHelloWorldMessage(helloWorldDto);

    }
    
}
