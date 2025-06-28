package com.jabes.travel_calc.core;

import com.jabes.travel_calc.rest.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TravelCalculatePremiumServiceImplTest {

    private final TravelCalculatePremiumServiceImpl calculate = new TravelCalculatePremiumServiceImpl();

    @Test
    public void testCalculatePremium_ReturnsCorrectResponse() {

        String firstNameExpected = "Иван";
        String lastNameExpected = "Петров";
        Date dateFromExpected = new Date(2025, 6, 1);
        Date dateToExpected = new Date(2025, 6, 9);

        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(firstNameExpected, lastNameExpected, dateFromExpected, dateToExpected);

        TravelCalculatePremiumResponse response = calculate.calculatePremium(request);

        Assertions.assertEquals(firstNameExpected, response.getPersonFirstName(), "Имена должны совпадать.");
        Assertions.assertEquals(lastNameExpected, request.getPersonLastName(), "Фамилии должны совпадать.");
        Assertions.assertEquals(dateFromExpected, request.getAgreementDateFrom(), "dateFrom не совпадают.");
        Assertions.assertEquals(dateToExpected, request.getAgreementDateTo(), "dateTo не совпадает.");

    }

}