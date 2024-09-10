package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity(name = "bookings")
public class BookingEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public BookingEntity(){}

    public BookingEntity(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
