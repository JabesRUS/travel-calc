package com.jabes.travel_calc.core;

import com.jabes.travel_calc.rest.TravelCalculatePremiumRequest;
import com.jabes.travel_calc.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        String personFirstName = request.getPersonFirstName();
        String personLastName = request.getPersonLastName();
        Date agreementDateFrom = request.getAgreementDateFrom();
        Date agreementDateTo = request.getAgreementDateTo();

        return new TravelCalculatePremiumResponse(
                personFirstName, personLastName, agreementDateFrom, agreementDateTo
        );
    }

}
