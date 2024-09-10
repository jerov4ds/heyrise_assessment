package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.data.HelloWorld;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.dataMapper.HelloWorldDataMapper;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.entity.HelloWorldEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.repository.HelloWorldRepository;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.exception.HelloWorldMessageNotFoundException;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.dto.HelloWorldDto;

import java.util.Optional;

@Component
public class HelloWorldManager {
    @Autowired
    private HelloWorldRepository helloWorldRepository;

    static final String HELLO_WORLD_KEY = "helloWorld";
    
    public HelloWorld getHelloWorldMessage() throws HelloWorldMessageNotFoundException {

        Optional<HelloWorldEntity> oHelloWorld = helloWorldRepository.findById(HELLO_WORLD_KEY);

        if (oHelloWorld.isEmpty()) {
            throw new HelloWorldMessageNotFoundException(
                    "Hello World message was not found"
            );
        }

        HelloWorldEntity helloWorldEntity = oHelloWorld.get();
        return new HelloWorld(helloWorldEntity);
    }

    public HelloWorld setHelloWorldMessage(HelloWorldDto helloWorldDto) {
        
        HelloWorldEntity entity = HelloWorldDataMapper.INSTANCE.convertHelloWorldDtoToEntity(helloWorldDto);
        entity.setId(HELLO_WORLD_KEY);

        helloWorldRepository.save(entity);

        return new HelloWorld(entity);
    }

}
