package com.jabes.travel_calc.core;

import com.jabes.travel_calc.rest.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final DateTimeService dateTimeService = new DateTimeService();

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        String personFirstName = request.getPersonFirstName();
        String personLastName = request.getPersonLastName();
        Date agreementDateFrom = request.getAgreementDateFrom();
        Date agreementDateTo = request.getAgreementDateTo();
        BigDecimal agreementPrice = dateTimeService.calculateDaysBetween(agreementDateFrom, agreementDateTo);

        return new TravelCalculatePremiumResponse(
                personFirstName, personLastName, agreementDateFrom, agreementDateTo, agreementPrice
        );
    }

}
