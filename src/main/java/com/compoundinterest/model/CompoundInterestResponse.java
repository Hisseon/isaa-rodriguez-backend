package com.compoundinterest.model;

import java.math.BigDecimal;

public class CompoundInterestResponse {
    private double interest;
    private double total;
    private BigDecimal principalAmount;
    private BigDecimal annualContribution;

    public CompoundInterestResponse(double interest, double total) {
        this.interest = interest;
        this.total = total;
        this.principalAmount = principalAmount;
        this.annualContribution = annualContribution;
    }

    public CompoundInterestResponse(BigDecimal setScale) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public BigDecimal getCompoundInterest() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTotalAmount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getInterestAmount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPrincipalAmount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getYears() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getAnnualContribution() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getInterestRate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
//En este caso, la clase CompoundInterestResponse tiene dos propiedades: interest y total, que representan la cantidad de interés ganado y el monto total después de aplicar el interés compuesto, respectivamente. La clase tiene un constructor que recibe estos dos valores y dos métodos para obtener y establecer estos valores.





