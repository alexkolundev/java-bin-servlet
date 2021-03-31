package com.dev.kolun.alex.binservlet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperationRequest {

    private String id;

    private String type;

    private String pan;

    private Long amount;

    private String message;

}
