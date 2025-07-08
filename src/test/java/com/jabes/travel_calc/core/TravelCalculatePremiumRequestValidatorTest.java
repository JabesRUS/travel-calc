package com.jabes.travel_calc.core;

import com.jabes.travel_calc.dto.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.dto.ValidationError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class TravelCalculatePremiumRequestValidatorTest {

    TravelCalculatePremiumRequestValidator requestValidator = new TravelCalculatePremiumRequestValidator();

    @Test
    public void shouldReturnErrorWhenFirstNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn(null);
        Mockito.when(request.getPersonLastName()).thenReturn("LastName");

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("personFirstName", errors.get(0).getField());
        Assertions.assertEquals("Must not be empty.", errors.get(0).getMessage());
    }

    @Test
    public void shouldReturnErrorWhenFirstNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("");
        Mockito.when(request.getPersonLastName()).thenReturn("LastName");

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("personFirstName", errors.get(0).getField());
        Assertions.assertEquals("Must not be empty.", errors.get(0).getMessage());
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsNull() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("FirstName");
        Mockito.when(request.getPersonLastName()).thenReturn(null);

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("personLastName", errors.get(0).getField());
        Assertions.assertEquals("Must not be empty.", errors.get(0).getMessage());
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsEmpty() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("FirstName");
        Mockito.when(request.getPersonLastName()).thenReturn("");

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("personLastName", errors.get(0).getField());
        Assertions.assertEquals("Must not be empty.", errors.get(0).getMessage());
    }

    @Test
    public void shouldNotReturnErrorWhenPersonAndLastNameIsValid() {
        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("FirstName");
        Mockito.when(request.getPersonLastName()).thenReturn("LastName");

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertTrue(errors.isEmpty());

    }

}