package com.example.xperttest.service;

import com.example.xperttest.helper.OperationsDelegator;
import com.example.xperttest.model.dto.Request;
import com.example.xperttest.model.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSummationService implements  SummationService {

    @Autowired
    private OperationsDelegator delegator;

    @Override
    public Response processCube(Request request) {
        Response response = new Response();
        List<BigInteger> result = new ArrayList<>();
        BigInteger testCases = request.getTestCaseNumber();
        if (testCases.intValue() == request.getValues().size()) {
            for (int i = 0; i < testCases.intValue(); i++) {
                List<String> operations = request.getValues().get(i).getOperations();
                String setTestCaseValues = operations.get(0);
                String[] testCasesValuesSplit = setTestCaseValues.trim().split(" ");
                int initialSet = Integer.parseInt(testCasesValuesSplit[0]);
                int numOperations = Integer.parseInt(testCasesValuesSplit[1]);
                if (numOperations == operations.size()-1) {
                    getDelegator().setMethod(initialSet);
                    for (int j = 1; j <= numOperations; j++) {
                        String OpsLine = operations.get(j);
                        String[] OpsLineSplits = OpsLine.split(" ");
                        if (OpsLineSplits[0].equals("UPDATE")) {
                            delegator.update(Integer.parseInt(OpsLineSplits[1])-1, Integer.parseInt(OpsLineSplits[2])-1,             Integer.parseInt(OpsLineSplits[3])-1, Integer.parseInt(OpsLineSplits[4]));
                        }
                        if (OpsLineSplits[0].equals("QUERY")) {
                            result.add(delegator.query(Integer.parseInt(OpsLineSplits[1])-1, Integer.parseInt(OpsLineSplits[2])-1,             Integer.parseInt(OpsLineSplits[3])-1, Integer.parseInt(OpsLineSplits[4])-1, Integer.parseInt(OpsLineSplits[5])-1, Integer.parseInt(OpsLineSplits[6])-1));
                        }
                    }
                }

            }
        }
        response.setValues(result);
        return response;
    }


    public OperationsDelegator getDelegator() {
        return delegator;
    }
}
