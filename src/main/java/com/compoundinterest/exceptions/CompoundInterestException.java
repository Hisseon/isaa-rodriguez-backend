/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compoundinterest.exceptions;

public class CompoundInterestException extends RuntimeException {

    public CompoundInterestException(String message) {
        super(message);
    }

    public CompoundInterestException(String invalid_input_data, InvalidDataException e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

