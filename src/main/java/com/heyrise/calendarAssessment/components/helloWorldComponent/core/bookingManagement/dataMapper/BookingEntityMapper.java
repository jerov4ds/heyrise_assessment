package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.dataMapper;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingEntityMapper {
    BookingEntityMapper INSTANCE = Mappers.getMapper(BookingEntityMapper.class);

    BookingEntityResource convertBookingEntityToResource(BookingEntity booking);

    @Mapping(target = "id", ignore = true)
    BookingEntity convertBookingDtoToEntity(BookingDto dto);

}