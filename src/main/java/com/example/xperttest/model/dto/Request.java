package com.example.xperttest.model.dto;

import java.math.BigInteger;
import java.util.List;

public class Request {
    private BigInteger testCaseNumber;
    private List<Values> values;

    public BigInteger getTestCaseNumber() {
        return testCaseNumber;
    }

    public void setTestCaseNumber(BigInteger testCaseNumber) {
        this.testCaseNumber = testCaseNumber;
    }

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }
}
