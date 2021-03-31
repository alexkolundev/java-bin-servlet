package com.dev.kolun.alex.binservlet.protocol;

import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.dto.OperationResponse;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class OperationWrapResponse implements Response<OperationResponse> {

    private final OperationResponse response;
    private List<String> attributes = new ArrayList<>();

    public OperationWrapResponse(OperationResponse response) {
        this.response = response;
    }

    public void addAttribute(String attribute){
        attributes.add(attribute);
    }

    public String getAttribute(int index){
        return attributes.get(index);
    }

    @Override
    public OperationResponse getResponse() {
        return response;
    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void setCommitted(boolean committed) {

    }
}
