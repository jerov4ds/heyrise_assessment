package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.service;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.PossibleTimeCheckDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;

import java.time.LocalDate;
import java.util.List;

public interface CalendarManagementServiceImpl {

    List<String> getPossibleBookingTime(PossibleTimeCheckDto possibleTimeCheckDto);

    List<String> calculateAvailableDatesForRange();
    BookingEntityResource createBooking(BookingDto bookingDto);

    BookingEntityResource updateBooking(String bookingId, BookingDto bookingDto);

    void deleteBooking(String bookingId);

    List<String> getAvailableTimeFrames(String calendarId, LocalDate date, int durationMinutes) throws Exception;

    List<LocalDate> getAvailableDates(String calendarId, LocalDate startDate, LocalDate endDate);

    List<LocalDate> getOverlappingAvailabilities(String calendarId1, String calendarId2, LocalDate startDate, LocalDate endDate);
}
