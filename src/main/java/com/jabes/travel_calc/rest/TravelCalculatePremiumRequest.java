package com.jabes.travel_calc.rest;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TravelCalculatePremiumRequest {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;

    public TravelCalculatePremiumRequest() {
    }

    public TravelCalculatePremiumRequest(String personFirstName, String personLastName, Date agreementDateFrom, Date agreementDateTo) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = agreementDateFrom;
        this.agreementDateTo = agreementDateTo;
    }

}
