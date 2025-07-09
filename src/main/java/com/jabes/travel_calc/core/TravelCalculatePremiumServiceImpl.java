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
    private final TravelPremiumUnderwriting premiumUnderwriting;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = requestValidator.validate(request);
        return  (errors.isEmpty())
                ? createResponse(request, premiumUnderwriting.calculatePremium(request))
                : createResponse(errors);

    }

    private TravelCalculatePremiumResponse createResponse(List<ValidationError> errors) {
        return new TravelCalculatePremiumResponse(errors);
    }

    private TravelCalculatePremiumResponse createResponse(TravelCalculatePremiumRequest request, BigDecimal premium) {
        TravelCalculatePremiumResponse response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());
        response.setAgreementPrice(premium);

        return response;
    }

}
