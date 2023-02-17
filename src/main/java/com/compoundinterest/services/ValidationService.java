/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compoundinterest.services;

import com.compoundinterest.exceptions.InvalidDataException;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestResponse;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean validate(double principal, double rate, int periods) {
        return principal >= 0 && rate >= 0 && periods >= 0;
    }

    void validate(CompoundInterestRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void validateRequest(CompoundInterestRequest request) throws InvalidDataException {
    if (request.getPrincipal().compareTo(BigDecimal.valueOf(1000)) < 0) {
        throw new InvalidDataException("La inversión inicial debe ser mayor o igual a $1,000.00.");
    }

    if (request.getYears() <= 0) {
        throw new InvalidDataException("Los años de inversión deben ser mayores a cero.");
    }

    if (request.getInterestRate().compareTo(BigDecimal.ZERO) <= 0) {
        throw new InvalidDataException("El rendimiento de la inversión debe ser mayor a cero.");
    }

    if (request.getAdditionalContribution() == null) {
        request.setAdditionalContribution(BigDecimal.ZERO);
    }

    if (request.getContributionIncreaseRate() == null) {
        request.setContributionIncreaseRate(BigDecimal.ZERO);
    }
}

    public void validateResponse(CompoundInterestRequest request, CompoundInterestResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
