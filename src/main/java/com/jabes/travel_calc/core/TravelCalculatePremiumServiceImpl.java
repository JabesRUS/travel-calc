package com.jabes.travel_calc.core;

import com.jabes.travel_calc.dto.ValidationError;
import com.jabes.travel_calc.dto.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.dto.TravelCalculatePremiumResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    private final TravelCalculatePremiumRequestValidator requestValidator;
    private final DateTimeService dateTimeService;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {

        List<ValidationError> errors = requestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new TravelCalculatePremiumResponse(errors);
        }


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
