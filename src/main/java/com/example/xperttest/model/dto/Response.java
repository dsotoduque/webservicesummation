package com.example.xperttest.model.dto;

import java.math.BigInteger;
import java.util.List;

public class Response {

    private List<BigInteger> values;

    public List<BigInteger> getValues() {
        return values;
    }

    public void setValues(List<BigInteger> values) {
        this.values = values;
    }
}
