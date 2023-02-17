package com.compoundinterest.controller;

import com.compoundinterest.exceptions.CompoundInterestException;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestInput;
import com.compoundinterest.exceptions.InvalidDataException;
import com.compoundinterest.model.CompoundInterestInput;
import com.compoundinterest.model.CompoundInterestRequest;
import com.compoundinterest.model.CompoundInterestResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.compoundinterest.services.CompoundInterestService;
import com.compoundinterest.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/compound-interest")
public class CompoundInterestController {

    @Autowired
    private CompoundInterestService compoundInterestService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("/calculate")
    public ResponseEntity<CompoundInterestResponse> calculateCompoundInterest(@RequestBody CompoundInterestInput input) {
        try {
            CompoundInterestRequest request = new CompoundInterestRequest(
                input.getPrincipal(), input.getInterestRate(), input.getYears(), input.getAdditionalContribution(),
                input.getContributionIncreaseRate()
            );
            validationService.validateRequest(request);

            CompoundInterestResponse response = compoundInterestService.calculateCompoundInterest(request);
            validationService.validateResponse(request, response);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidDataException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (CompoundInterestException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}




