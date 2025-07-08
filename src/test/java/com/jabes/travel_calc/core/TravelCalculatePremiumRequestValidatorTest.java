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

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertEquals(1, errors.size());
        Assertions.assertEquals("personFirstName", errors.get(0).getField());
        Assertions.assertEquals("Must not be empty.", errors.get(0).getMessage());
    }

    @Test
    public void shouldNotReturnErrorWhenFirstNameIsValid() {

        TravelCalculatePremiumRequest request = Mockito.mock(TravelCalculatePremiumRequest.class);
        Mockito.when(request.getPersonFirstName()).thenReturn("John");

        List<ValidationError> errors = requestValidator.validate(request);

        Assertions.assertTrue(errors.isEmpty());

    }

}