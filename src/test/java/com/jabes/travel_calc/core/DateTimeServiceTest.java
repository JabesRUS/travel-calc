package com.jabes.travel_calc.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeServiceTest {

    private final DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void shouldReturnNullWhenDateFromIsNull() {
        Date dateTo = new Date(2025, 6, 1);

        BigDecimal result = dateTimeService.calculateDaysBetween(null, dateTo);

        Assertions.assertNull(result, "При dateFrom = null, result должен быть null.");
    }

    @Test
    public void shouldReturnNullWhenDateToIsNull() {
        Date dateFrom = new Date(2025, 6, 1);

        BigDecimal result = dateTimeService.calculateDaysBetween(dateFrom, null);

        Assertions.assertNull(result, "При dateTo = null, result должен быть null.");
    }

    @Test
    public void shouldReturnCorrectNumberOfDaysWhenDatesAreValid() {
        Date dateFrom = new Date(2025, 6, 1);
        Date dateTo = new Date(2025, 6, 9);

        BigDecimal result = dateTimeService.calculateDaysBetween(dateFrom, dateTo);

        Assertions.assertEquals(BigDecimal.valueOf(8), result, "Количество дней не совпадают");
    }



}