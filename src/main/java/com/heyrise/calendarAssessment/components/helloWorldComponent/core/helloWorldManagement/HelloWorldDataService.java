package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heyrise.calendarAssessment.common.restException.HeyRiseResourceNotFoundException;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.exception.HelloWorldMessageNotFoundException;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.dto.HelloWorldDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.resource.HelloWorldResource;

@Service
public class HelloWorldDataService {
    @Autowired
    private HelloWorldManager helloWorldManager;

    public HelloWorldResource getHelloWorldMessage() {
        try {
            return helloWorldManager.getHelloWorldMessage().getResource();
        } catch (HelloWorldMessageNotFoundException e) {
            throw new HeyRiseResourceNotFoundException("Hello World message not found");
        }
        
    }

    public HelloWorldResource setHelloWorldMessage(HelloWorldDto helloWorldDto) {
        return helloWorldManager.setHelloWorldMessage(helloWorldDto).getResource();
    }
}
