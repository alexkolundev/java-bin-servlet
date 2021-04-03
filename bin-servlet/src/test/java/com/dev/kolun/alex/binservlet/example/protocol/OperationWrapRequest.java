package com.dev.kolun.alex.binservlet.example.protocol;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.example.dto.OperationRequest;
import lombok.Getter;
import lombok.ToString;

@ToString
public class OperationWrapRequest implements Request<OperationRequest> {

    @Getter
    private final OperationRequest request;

    public OperationWrapRequest(OperationRequest operation) {
        this.request = operation;
    }

    @Override
    public String getPath() {
        return "operation/" + request.getType();
    }



}
