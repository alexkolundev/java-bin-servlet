package com.dev.kolun.alex.binservlet.example.protocol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationResponse implements HasResponseData {

    private ResponseData responseData;

    private long balance;

}
