package com.jabes.travel_calc.core;

import com.jabes.travel_calc.dto.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.dto.ValidationError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock private DateTimeService dateTimeService;
    @Mock private TravelCalculatePremiumRequestValidator requestValidator;

    @InjectMocks private TravelCalculatePremiumServiceImpl service;

//    @BeforeEach
//    public void setUp() {
//        service = new TravelCalculatePremiumServiceImpl(dateTimeService);
//    }

    @Test
    public void shouldPopulatePersonFirstName() {
        var request = createRequestWithAllFields();
        when(dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(BigDecimal.ZERO);
        when(requestValidator.validate(request)).thenReturn(List.of());
        var response = service.calculatePremium(request);
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void shouldPopulatePersonLastName() {
        var request = createRequestWithAllFields();
        when(dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(BigDecimal.ZERO);
        when(requestValidator.validate(request)).thenReturn(List.of());
        var response = service.calculatePremium(request);
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void shouldPopulateAgreementDateFrom() {
        var request = createRequestWithAllFields();
        when(dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(BigDecimal.ZERO);
        when(requestValidator.validate(request)).thenReturn(List.of());
        var response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void shouldPopulateAgreementDateTo() {
        var request = createRequestWithAllFields();
        when(dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(BigDecimal.ZERO);
        when(requestValidator.validate(request)).thenReturn(List.of());
        var response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void shouldPopulateAgreementPrice() {
        var request = createRequestWithAllFields();
        when(dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(BigDecimal.ZERO);
        when(requestValidator.validate(request)).thenReturn(List.of());
        var response = service.calculatePremium(request);
        assertNotNull(response.getAgreementPrice());
    }

    @Test
    public void shouldPopulateResponseWithErrors() {
        var request = new TravelCalculatePremiumRequest();
        var validationError = new ValidationError("field", "message");
        when(requestValidator.validate(request)).thenReturn(List.of(validationError));
        var response = service.calculatePremium(request);

        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldPopulateResponseWithCorrectErrorCount() {
        var request = new TravelCalculatePremiumRequest();
        var validationError = new ValidationError("field", "message");
        when(requestValidator.validate(request)).thenReturn(List.of(validationError));
        var response = service.calculatePremium(request);

        assertEquals(1, response.getErrors().size());
    }

    @Test
    public void shouldReturnResponseWithCorrectError() {
        var request = new TravelCalculatePremiumRequest();
        var validationError = new ValidationError("field", "message");
        when(requestValidator.validate(request)).thenReturn(List.of(validationError));
        var response = service.calculatePremium(request);
        assertEquals("field", response.getErrors().get(0).getField());
        assertEquals("message", response.getErrors().get(0).getMessage());
        assertNull(response.getPersonFirstName());
    }

    @Test
    public void allFieldsMustBeEmptyWhenResponseContainsError() {
        var request = new TravelCalculatePremiumRequest();
        var validationError = new ValidationError("field", "message");
        when(requestValidator.validate(request)).thenReturn(List.of(validationError));
        var response = service.calculatePremium(request);
        assertNull(response.getPersonFirstName());
        assertNull(response.getPersonLastName());
        assertNull(response.getAgreementDateFrom());
        assertNull(response.getAgreementDateTo());
        assertNull(response.getAgreementPrice());
    }

    @Test
    public void shouldNOtBeInteractionWithDateTimeServiceWhenResponseContainsError() {
        var request = new TravelCalculatePremiumRequest();
        var validationError = new ValidationError("field", "message");
        when(requestValidator.validate(request)).thenReturn(List.of(validationError));
        var response = service.calculatePremium(request);
        verifyNoInteractions(dateTimeService);
    }

    private TravelCalculatePremiumRequest createRequestWithAllFields() {
        var request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Peterson");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }

}