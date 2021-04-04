package com.dev.kolun.alex.binservlet.example.protocol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationRequest {

    private String token;

    private String type;

    private String card;

    private long amount;

}
