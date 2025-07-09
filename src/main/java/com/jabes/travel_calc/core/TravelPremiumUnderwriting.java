package com.jabes.travel_calc.core;

import com.jabes.travel_calc.dto.TravelCalculatePremiumRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TravelPremiumUnderwriting {

    private final DateTimeService dateTimeService;

    public BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        var daysBetween = dateTimeService.calculateDaysBetween(request.getAgreementDateFrom(), request.getAgreementDateTo());
        return daysBetween;
    }
}
