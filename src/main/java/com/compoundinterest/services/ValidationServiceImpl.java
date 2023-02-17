package com.compoundinterest.services;
import com.compoundinterest.exceptions.CompoundInterestException;
import com.compoundinterest.exceptions.InvalidDataException;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestResponse;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 *
 * @author bulle
 */
@Service
public class ValidationServiceImpl extends ValidationService {

    @Override
    public void validateRequest(CompoundInterestRequest request) throws InvalidDataException {
        if (request.getPrincipal() == null || request.getPrincipal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidDataException("Principal must be a positive value");
        }
        if (request.getInterestRate() == null || request.getInterestRate().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidDataException("Interest rate must be a positive value");
        }
        if (request.getYears() == 0 || request.getYears() <= 0) {
            throw new InvalidDataException("Years must be a positive value");
        }
    }

    public void validateResponse(CompoundInterestRequest request, CompoundInterestResponse response)
            throws CompoundInterestException {
        if (response == null || response.getCompoundInterest() == null) {
            throw new CompoundInterestException("Error calculating compound interest");
        }
        if (response.getCompoundInterest().compareTo(request.getPrincipal()) <= 0) {
            throw new CompoundInterestException("Error calculating compound interest, result is not greater than the principal");
        }
    }
}
