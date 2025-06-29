package com.jabes.travel_calc.core;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class DateTimeService {

    public BigDecimal calculateDaysBetween(Date from, Date to) {

        if (from == null || to == null) {
            return null;
        }
        // Преобразуем java.util.Date в java.time.LocalDate
        LocalDate fromLocal = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate toLocal = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Вычисляем количество дней между датами
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(fromLocal, toLocal));
    }
}
