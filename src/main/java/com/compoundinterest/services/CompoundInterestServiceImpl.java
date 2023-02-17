package com.compoundinterest.services;
import com.compoundinterest.exceptions.CompoundInterestException;
import com.compoundinterest.exceptions.InvalidDataException;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestResponse;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompoundInterestServiceImpl extends CompoundInterestService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CompoundInterestServiceImpl.class);

@Autowired
private ValidationService validationService;

public CompoundInterestServiceImpl(ValidationService validationService) {
    super(validationService);
}

//@Override
public CompoundInterestResponse calculateInterest(CompoundInterestRequest request) throws CompoundInterestException {

    LOGGER.info("Calculating compound interest");

    try {
        validationService.validate(request);
    } catch (InvalidDataException e) {
        LOGGER.error("Validation error: {}", e.getMessage());
        throw new CompoundInterestException("Invalid input data", e);
    }

    BigDecimal principal = request.getPrincipal();
    BigDecimal rate = request.getInterestRate();
    int years = request.getYears();
    int compoundsPerYear = request.getCompoundsPerYear();

    BigDecimal one = new BigDecimal(1);
    BigDecimal compoundedRate = rate.divide(new BigDecimal(compoundsPerYear), MathContext.DECIMAL128)
            .add(one);
    BigDecimal compoundsPerYearTimesYears = new BigDecimal(compoundsPerYear * years);

    BigDecimal amount = principal.multiply(compoundedRate.pow(compoundsPerYearTimesYears.intValue()));

    return new CompoundInterestResponse(amount);
    }
}
