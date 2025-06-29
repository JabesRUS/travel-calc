package com.jabes.travel_calc.core;

import com.jabes.travel_calc.rest.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock private DateTimeService dateTimeService;
    @InjectMocks private TravelCalculatePremiumServiceImpl service;

//    @BeforeEach
//    public void setUp() {
//        service = new TravelCalculatePremiumServiceImpl(dateTimeService);
//    }

    @Test
    public void testCalculatePremium_ReturnsCorrectFirstName() {
        String firstNameExpected = "Иван";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                firstNameExpected, null, null, null);


        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        Assertions.assertEquals(firstNameExpected, response.getPersonFirstName(), "Имена должны совпадать.");
    }

    @Test
    public void testCalculatePremium_ReturnsCorrectLastName() {
        String lastNameExpected = "Петров";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, lastNameExpected, null, null);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        Assertions.assertEquals(lastNameExpected, request.getPersonLastName(), "Фамилии должны совпадать.");
    }

    @Test
    public void testCalculatePremium_ReturnsCorrectDateFrom() {
        Date dateFromExpected = new Date(2025, 6, 1);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, dateFromExpected, null);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        Assertions.assertEquals(dateFromExpected, request.getAgreementDateFrom(), "dateFrom не совпадают.");

    }

    @Test
    public void testCalculatePremium_ReturnsCorrectDateTo() {
        Date dateToExpected = new Date(2025, 6, 9);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, null, dateToExpected);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);


        Assertions.assertEquals(dateToExpected, request.getAgreementDateTo(), "dateTo не совпадает.");
    }

    @Test
    public void testCalculatePremium_ReturnsCorrectPrice() {
        Date dateFromExpected = new Date(2025, 6, 1);
        Date dateToExpected = new Date(2025, 6, 9);
        BigDecimal betweenDaysExpected = BigDecimal.valueOf(8);
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(
                null, null, dateFromExpected, dateToExpected);
        Mockito.when(dateTimeService.calculateDaysBetween(dateFromExpected, dateToExpected))
                .thenReturn(betweenDaysExpected);


        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        Assertions.assertEquals(betweenDaysExpected, response.getAgreementPrice());
    }

//    private static BigDecimal calculateDaysBetween(Date from, Date to) {
//        // Преобразуем java.util.Date в java.time.LocalDate
//        LocalDate fromLocal = from.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate toLocal = to.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//        // Вычисляем количество дней между датами
//        return BigDecimal.valueOf(ChronoUnit.DAYS.between(fromLocal, toLocal));
//    }

}