package com.jabes.travel_calc.core;

import com.jabes.travel_calc.rest.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class TravelCalculatePremiumServiceImplTest {

    private final TravelCalculatePremiumServiceImpl calculate = new TravelCalculatePremiumServiceImpl();

    @Test
    public void testCalculatePremium_ReturnsCorrectFirstName() {
        String firstNameExpected = "Иван";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                firstNameExpected, null, null, null);

        TravelCalculatePremiumResponse response = calculate.calculatePremium(request);

        Assertions.assertEquals(firstNameExpected, response.getPersonFirstName(), "Имена должны совпадать.");
    }

    @Test
    public void testCalculatePremium_ReturnsCorrectLastName() {
        String lastNameExpected = "Петров";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, lastNameExpected, null, null);

        TravelCalculatePremiumResponse response = calculate.calculatePremium(request);

        Assertions.assertEquals(lastNameExpected, request.getPersonLastName(), "Фамилии должны совпадать.");
    }

    @Test
    public void testCalculatePremium_ReturnsCorrectDateFrom() {
        Date dateFromExpected = new Date(2025, 6, 1);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, dateFromExpected, null);

        TravelCalculatePremiumResponse response = calculate.calculatePremium(request);

        Assertions.assertEquals(dateFromExpected, request.getAgreementDateFrom(), "dateFrom не совпадают.");

    }

    @Test
    public void testCalculatePremium_ReturnsCorrectDateTo() {
        Date dateToExpected = new Date(2025, 6, 9);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, null, dateToExpected);

        TravelCalculatePremiumResponse response = calculate.calculatePremium(request);


        Assertions.assertEquals(dateToExpected, request.getAgreementDateTo(), "dateTo не совпадает.");
    }

}