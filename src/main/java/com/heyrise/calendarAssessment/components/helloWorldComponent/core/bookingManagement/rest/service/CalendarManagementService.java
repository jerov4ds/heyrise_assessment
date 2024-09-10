package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.service;

import com.heyrise.calendarAssessment.common.restException.HeyRiseResourceNotFoundException;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.dataMapper.BookingEntityMapper;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.Calendar;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.repository.BookingRepository;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.repository.CalendarRepository;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.exception.BookingTimeOverlapException;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.PossibleTimeCheckDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.helloWorldManagement.dataMapper.HelloWorldDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CalendarManagementService implements CalendarManagementServiceImpl {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public List<String> getPossibleBookingTime(PossibleTimeCheckDto possibleTimeCheckDto) {
        List<BookingEntity> bookings = bookingRepository.findByDate(possibleTimeCheckDto.getDate());
        List<String> availableTimeFrames = new ArrayList<>();

        LocalTime startOfDay = LocalTime.of(9, 0);
        LocalTime endOfDay = LocalTime.of(18, 0);

        LocalTime currentStartTime = startOfDay;

        for (BookingEntity booking : bookings) {
            if (currentStartTime.plusMinutes(possibleTimeCheckDto.getDurationInMinutes()).isBefore(booking.getStartTime())) {
                availableTimeFrames.add(currentStartTime + " - " + currentStartTime.plusMinutes(possibleTimeCheckDto.getDurationInMinutes()));
            }
            currentStartTime = booking.getEndTime().isAfter(currentStartTime) ? booking.getEndTime() : currentStartTime;
        }

        while (currentStartTime.plusMinutes(possibleTimeCheckDto.getDurationInMinutes()).isBefore(endOfDay)) {
            availableTimeFrames.add(currentStartTime + " - " + currentStartTime.plusMinutes(possibleTimeCheckDto.getDurationInMinutes()));
            currentStartTime = currentStartTime.plusMinutes(possibleTimeCheckDto.getDurationInMinutes());
        }

        return availableTimeFrames;
    }

    @Override
    public List<String> calculateAvailableDatesForRange() {
        return null;
    }

    @Override
    public BookingEntityResource createBooking(BookingDto bookingDto) throws BookingTimeOverlapException {
        List<BookingEntity> overlappingBookings = bookingRepository.findByDateAndStartTimeLessThanAndEndTimeGreaterThan(
                bookingDto.getDate(), bookingDto.getEndTime(), bookingDto.getStartTime());

        if (!overlappingBookings.isEmpty()) {
            throw new BookingTimeOverlapException("Booking time overlaps with an existing booking.");
        }

        BookingEntity booking = new BookingEntity(bookingDto.getDate(), bookingDto.getStartTime(), bookingDto.getEndTime());

        BookingEntity saved = bookingRepository.save(booking);
        return BookingEntityMapper.INSTANCE.convertBookingEntityToResource(saved);
    }

    @Override
    public BookingEntityResource updateBooking(String bookingId, BookingDto bookingDto) {
        BookingEntity existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new HeyRiseResourceNotFoundException("Booking not found."));

        List<BookingEntity> overlappingBookings = bookingRepository.findByDateAndStartTimeLessThanAndEndTimeGreaterThan(
                bookingDto.getDate(), bookingDto.getEndTime(), bookingDto.getStartTime());

        if (!overlappingBookings.isEmpty() && !overlappingBookings.contains(existingBooking)) {
            throw new BookingTimeOverlapException("Booking time overlaps with an existing booking.");
        }

        existingBooking.setDate(bookingDto.getDate());
        existingBooking.setStartTime(bookingDto.getStartTime());
        existingBooking.setEndTime(bookingDto.getEndTime());

        BookingEntity saved = bookingRepository.save(existingBooking);
        return BookingEntityMapper.INSTANCE.convertBookingEntityToResource(saved);
    }

    @Override
    public void deleteBooking(String bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<String> getAvailableTimeFrames(String calendarId, LocalDate date, int durationMinutes) throws HeyRiseResourceNotFoundException {
        Calendar calendar = calendarRepository.findById(calendarId)
                .orElseThrow(() -> new HeyRiseResourceNotFoundException("Calendar not found."));

        List<BookingEntity> bookings = bookingRepository.findByDateAndCalendar(date, calendar);
        List<String> availableTimeFrames = new ArrayList<>();

        LocalTime startOfDay = LocalTime.of(9, 0); // Example: Start of working day
        LocalTime endOfDay = LocalTime.of(18, 0);  // Example: End of working day

        LocalTime currentStartTime = startOfDay;

        for (BookingEntity booking : bookings) {
            if (currentStartTime.plusMinutes(durationMinutes).isBefore(booking.getStartTime())) {
                availableTimeFrames.add(currentStartTime + " - " + currentStartTime.plusMinutes(durationMinutes));
            }
            currentStartTime = booking.getEndTime().isAfter(currentStartTime) ? booking.getEndTime() : currentStartTime;
        }

        while (currentStartTime.plusMinutes(durationMinutes).isBefore(endOfDay)) {
            availableTimeFrames.add(currentStartTime + " - " + currentStartTime.plusMinutes(durationMinutes));
            currentStartTime = currentStartTime.plusMinutes(durationMinutes);
        }

        return availableTimeFrames;
    }

    public List<LocalDate> getAvailableDates(String calendarId, LocalDate startDate, LocalDate endDate) throws HeyRiseResourceNotFoundException {
        Calendar calendar = calendarRepository.findById(calendarId)
                .orElseThrow(() -> new HeyRiseResourceNotFoundException("Calendar not found."));

        Set<LocalDate> availableDates = new HashSet<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            List<BookingEntity> bookings = bookingRepository.findByDateAndCalendar(currentDate, calendar);
            if (bookings.isEmpty()) {
                availableDates.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }

        return new ArrayList<>(availableDates);
    }

    public List<LocalDate> getOverlappingAvailabilities(String calendarId1, String calendarId2, LocalDate startDate, LocalDate endDate) {
        Set<LocalDate> calendar1Availability = new HashSet<>(getAvailableDates(calendarId1, startDate, endDate));
        Set<LocalDate> calendar2Availability = new HashSet<>(getAvailableDates(calendarId2, startDate, endDate));

        calendar1Availability.retainAll(calendar2Availability);

        return new ArrayList<>(calendar1Availability);
    }
}
