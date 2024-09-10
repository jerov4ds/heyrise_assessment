package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.data;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.dataMapper.HelloWorldDataMapper;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.entity.HelloWorldEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.resource.HelloWorldResource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloWorld {
    private HelloWorldEntity userEntity;

    public HelloWorldResource getResource() {
        return HelloWorldDataMapper.INSTANCE.convertHelloWorldEntityToResource(userEntity);
    }

}
