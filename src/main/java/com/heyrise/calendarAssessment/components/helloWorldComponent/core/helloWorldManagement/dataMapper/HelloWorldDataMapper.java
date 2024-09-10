package com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.dataMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.database.entity.HelloWorldEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.dto.HelloWorldDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.rest.resource.HelloWorldResource;

@Mapper
public interface HelloWorldDataMapper {
    HelloWorldDataMapper INSTANCE = Mappers.getMapper(HelloWorldDataMapper.class);
    
    HelloWorldResource convertHelloWorldEntityToResource(HelloWorldEntity memberEntity);

    @Mapping(target = "id", ignore = true)
    HelloWorldEntity convertHelloWorldDtoToEntity(HelloWorldDto dto);

    HelloWorldDto convertUserEntityToDto(HelloWorldEntity userEntity);
}
