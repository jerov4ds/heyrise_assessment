package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.repository;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, String> {
}
