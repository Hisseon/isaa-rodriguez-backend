package com.examen.isaacrodriguez;
import com.compoundinterest.model.CompoundInterestInput;
import com.compoundinterest.model.CompoundInterestResponse;
import com.compoundinterest.exceptions.CompoundInterestException;
import com.compoundinterest.services.CompoundInterestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CompoundInterestServiceApplicationTests {

    @Autowired
    private CompoundInterestService compoundInterestService;

    @Test
    void testCompoundInterestCalculation() throws CompoundInterestException {
        BigDecimal initialInvestment = BigDecimal.valueOf(1000);
        BigDecimal interestRate = BigDecimal.valueOf(0.05);
        int years = 10;
        BigDecimal annualContribution = BigDecimal.valueOf(100);
        BigDecimal contributionIncreaseRate = BigDecimal.valueOf(0.0);

        CompoundInterestInput input = new CompoundInterestInput(initialInvestment, interestRate, years, annualContribution, contributionIncreaseRate);

        CompoundInterestResponse response = compoundInterestService.calculateCompoundInterest(input);

        assertEquals(BigDecimal.valueOf(1628.89).setScale(2), response.getTotalAmount());
        assertEquals(BigDecimal.valueOf(628.89).setScale(2), response.getInterestAmount());
        assertEquals(initialInvestment, response.getPrincipalAmount());
        assertEquals(years, response.getYears());
        assertEquals(annualContribution, response.getAnnualContribution());
        assertEquals(interestRate, response.getInterestRate());
    }

    @Test
void testCompoundInterestInvalidData() throws CompoundInterestException {
    // Crear objeto CompoundInterestInput con datos inválidos
    CompoundInterestInput input = new CompoundInterestInput();
    input.setPrincipal(BigDecimal.valueOf(500));
    input.setYears(0);
    input.setInterestRate(BigDecimal.ZERO);
    input.setAdditionalContribution(BigDecimal.valueOf(-10));

    // Verificar que se lance una excepción CompoundInterestException
    assertThrows(CompoundInterestException.class, () -> {
        compoundInterestService.calculateCompoundInterest(input);
    });
}
}
