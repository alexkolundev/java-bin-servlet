package com.dev.kolun.alex.binservlet.example.protocol;

import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.example.protocol.dto.HasResponseData;
import com.dev.kolun.alex.binservlet.example.protocol.dto.OperationResponse;
import com.dev.kolun.alex.binservlet.example.protocol.dto.ResponseData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class OperationWrapResponse implements Response<OperationResponse>, HasResponseData {

    @Setter
    @Getter
    private OperationResponse response;

    @Setter
    @Getter
    private boolean committed;

    private final List<String> attributes = new ArrayList<>();

    public OperationWrapResponse(OperationResponse response) {
        this.response = response;
    }

    @Override
    public void setResponseData(ResponseData responseData) {
        response.setResponseData(responseData);
    }

    @Override
    public ResponseData getResponseData() {
        return response.getResponseData();
    }

    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }

    public String getAttribute(int index) {
        return attributes.get(index);
    }
}
