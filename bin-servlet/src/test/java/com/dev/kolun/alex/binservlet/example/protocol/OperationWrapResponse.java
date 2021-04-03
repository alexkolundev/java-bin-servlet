package com.dev.kolun.alex.binservlet.example.protocol;

import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.example.dto.OperationResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
public class OperationWrapResponse implements Response<OperationResponse> {

    @Setter
    @Getter
    private OperationResponse response;

    @Setter
    @Getter
    private boolean committed = false;

    private final List<String> attributes = new ArrayList<>();

    public OperationWrapResponse(OperationResponse response) {
        this.response = response;
    }

    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }

    public String getAttribute(int index) {
        return attributes.get(index);
    }

}
