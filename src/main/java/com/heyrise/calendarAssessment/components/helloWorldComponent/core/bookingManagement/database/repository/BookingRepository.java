package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.repository;

import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.BookingEntity;
import com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.database.entity.Calendar;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, String>  {
    List<BookingEntity> findByDateAndStartTimeLessThanAndEndTimeGreaterThan(LocalDate date, LocalTime startTime, LocalTime endTime);
    List<BookingEntity> findByDate(LocalDate date);

    List<BookingEntity> findByDateAndCalendar(LocalDate currentDate, Calendar calendar);
}