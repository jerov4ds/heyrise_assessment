package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.dataMapper;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface CalendarMapper {
    CalendarMapper INSTANCE = Mappers.getMapper(CalendarMapper.class);

    BookingEntityResource convertBookingEntityToResource(BookingEntity booking);

    @Mapping(target = "id", ignore = true)
    BookingEntity convertBookingDtoToEntity(BookingDto dto);
}
