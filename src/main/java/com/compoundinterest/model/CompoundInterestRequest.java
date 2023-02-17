package com.compoundinterest.model;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CompoundInterestRequest {
    private BigDecimal principal;
    private BigDecimal interestRate;
    private int years;
    private BigDecimal additionalContribution;
    private BigDecimal contributionIncreaseRate;

    public CompoundInterestRequest(BigDecimal principal, BigDecimal interestRate, int years, BigDecimal additionalContribution, BigDecimal contributionIncreaseRate) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.years = years;
        this.additionalContribution = additionalContribution;
        this.contributionIncreaseRate = contributionIncreaseRate;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public BigDecimal getAdditionalContribution() {
        return additionalContribution;
    }

    public void setAdditionalContribution(BigDecimal additionalContribution) {
        this.additionalContribution = additionalContribution;
    }

    public BigDecimal getContributionIncreaseRate() {
        return contributionIncreaseRate;
    }

    public void setContributionIncreaseRate(BigDecimal contributionIncreaseRate) {
        this.contributionIncreaseRate = contributionIncreaseRate;
    }

    public int getCompoundingsPerYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getRate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCompoundsPerYear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}