package com.dev.kolun.alex.binservlet.protocol;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.dto.OperationRequest;
import lombok.ToString;

@ToString
public class OperationWrapRequest implements Request<OperationRequest> {

    private final OperationRequest operation;

    public OperationWrapRequest(OperationRequest operation) {
        this.operation = operation;
    }

    @Override
    public OperationRequest getRequest() {
        return operation;
    }

    @Override
    public String getPath() {
        return "operation/" + operation.getType();
    }



}
