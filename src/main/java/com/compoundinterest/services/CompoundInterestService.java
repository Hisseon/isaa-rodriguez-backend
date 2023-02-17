/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compoundinterest.services;

import com.compoundinterest.exceptions.InvalidDataException;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestResponse;
import org.springframework.stereotype.Service;
import com.compoundinterest.services.ValidationService;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CompoundInterestService {

    private ValidationService ValidationService;

    public CompoundInterestService(ValidationService validationService) {
        this.ValidationService = validationService;
    }

    public CompoundInterestResponse calculateCompoundInterest(CompoundInterestRequest request) throws InvalidDataException {
    ValidationService.validate(request);

    BigDecimal principal = request.getPrincipal();
    BigDecimal rate = new BigDecimal(Double.toString(request.getRate())).divide(new BigDecimal(100));
    int years = (int) request.getYears();
    int compoundingsPerYear = request.getCompoundingsPerYear();

    BigDecimal base = BigDecimal.ONE.add(rate.divide(new BigDecimal(compoundingsPerYear), 10, RoundingMode.HALF_UP));
    BigDecimal exponent = BigDecimal.valueOf(compoundingsPerYear * years);
    BigDecimal amount = principal.multiply(base.pow(exponent.intValue())).setScale(2, RoundingMode.HALF_EVEN);



    return new CompoundInterestResponse(amount.setScale(2, RoundingMode.HALF_UP));
}

}
