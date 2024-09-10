package com.heyrise.calendarAssessment.components.helloWorldComponent.core.bookingManagement.rest.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PossibleTimeCheckDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    private int durationInMinutes;
}
