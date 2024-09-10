package com.heyrise.calendarAssessment.components.helloWorldComponent.restController;


import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.BookingDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto.PossibleTimeCheckDto;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.resource.BookingEntityResource;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.service.CalendarManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingManagementController {

    @Autowired
    private CalendarManagementServiceImpl service;

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingDto booking) {
        try {
            BookingEntityResource createdBooking = service.createBooking(booking);
            return ResponseEntity.ok(createdBooking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable String id, @RequestBody BookingDto booking) {
        try {
            BookingEntityResource updatedBooking = service.updateBooking(id, booking);
            return ResponseEntity.ok(updatedBooking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable String id) {
        service.deleteBooking(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available-times")
    public ResponseEntity<List<String>> getAvailableTimeFrames(
            @RequestParam PossibleTimeCheckDto dto) {
        List<String> availableTimeFrames = service.getPossibleBookingTime(dto);
        return ResponseEntity.ok(availableTimeFrames);
    }



    @GetMapping("/available-times")
    public ResponseEntity<List<String>> getAvailableTimeFrames(
            @PathVariable String calendarId,
            @RequestParam LocalDate date, @RequestParam int durationMinutes) {
        try {
            List<String> availableTimeFrames = service.getAvailableTimeFrames(calendarId, date, durationMinutes);
            return ResponseEntity.ok(availableTimeFrames);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of(e.getMessage()));
        }
    }

    @GetMapping("/available-dates")
    public ResponseEntity<List<LocalDate>> getAvailableDates(
            @PathVariable String calendarId,
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            List<LocalDate> availableDates = service.getAvailableDates(calendarId, startDate, endDate);
            return ResponseEntity.ok(availableDates);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of());
        }
    }

    @GetMapping("/overlapping-availabilities")
    public ResponseEntity<List<LocalDate>> getOverlappingAvailabilities(
            @RequestParam String calendarId1,
            @RequestParam String calendarId2,
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        try {
            List<LocalDate> overlappingAvailabilities = service.getOverlappingAvailabilities(calendarId1, calendarId2, startDate, endDate);
            return ResponseEntity.ok(overlappingAvailabilities);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of());
        }
    }
}
