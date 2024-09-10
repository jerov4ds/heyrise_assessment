package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingEntityResource {

    @NotNull
    private String id;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
}
