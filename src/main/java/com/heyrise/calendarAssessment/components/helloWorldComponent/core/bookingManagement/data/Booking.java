package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.data;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.dataMapper.BookingEntityMapper;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Booking {
    private BookingEntity bookingEntity;

    public BookingEntityResource getResource() {
        return BookingEntityMapper.INSTANCE.convertBookingEntityToResource(bookingEntity);
    }
}
