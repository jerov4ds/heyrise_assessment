package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "calendar")
public class Calendar {
    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "calendar")
    private List<BookingEntity> bookings;
}
