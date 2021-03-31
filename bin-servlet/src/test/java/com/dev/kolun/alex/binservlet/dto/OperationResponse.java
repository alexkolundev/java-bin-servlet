package com.dev.kolun.alex.binservlet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OperationResponse {

    private Short status;

    private String message;

}
