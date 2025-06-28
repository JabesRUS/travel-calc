package com.jabes.travel_calc.rest;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Getter
@Setter
public class TravelCalculatePremiumResponse {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;

    public TravelCalculatePremiumResponse() {
    }

    public TravelCalculatePremiumResponse(
            String personFirstName,
            String personLastName,
            Date agreementDateFrom,
            Date agreementDateTo) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = agreementDateFrom;
        this.agreementDateTo = agreementDateTo;

        if (agreementDateFrom != null && agreementDateTo != null) {
            this.agreementPrice = calculateDaysBetween( agreementDateFrom, agreementDateTo);
        }

    }

    private static BigDecimal calculateDaysBetween(Date from, Date to) {
        // Преобразуем java.util.Date в java.time.LocalDate
        LocalDate fromLocal = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate toLocal = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Вычисляем количество дней между датами
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(fromLocal, toLocal));
    }
}
