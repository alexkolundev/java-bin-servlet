package com.dev.kolun.alex.binservlet.example.bean.controller;

import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;
import com.dev.kolun.alex.binservlet.example.protocol.exception.ServiceException;
import com.dev.kolun.alex.binservlet.example.bean.service.OperationService;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import com.dev.kolun.alex.binservlet.example.protocol.dto.OperationResponse;
import com.dev.kolun.alex.binservlet.example.protocol.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

@BinController
public class OperationController {

    private final OperationService operationService;



    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }


    @BinRequestMapping(path = "operation/cashWithdrawal")
    public void cashWithdrawal(OperationWrapRequest request, OperationWrapResponse response) {
        long balance = operationService.cashWithdrawal(request.getRequest().getCard(), request.getRequest().getAmount());
        response.setResponse(
                new OperationResponse(
                        new ResponseData(0, "Success"),
                        balance
                )
        );
    }

    @BinRequestMapping(path = "operation/inCash")
    public void inCash(OperationWrapRequest request, OperationWrapResponse response) {
        long balance = operationService.inCash(request.getRequest().getCard(), request.getRequest().getAmount());
        response.setResponse(
                new OperationResponse(
                        new ResponseData(0, "Success"),
                        balance
                )
        );
    }

    @BinRequestMapping(path = "operation/balance")
    public void balance(OperationWrapRequest request, OperationWrapResponse response) {
        if (request.getRequest().getAmount() != 0) {
            throw new ServiceException(100, "Balance transaction must be with a zero amount");
        }
        long balance = operationService.balance(request.getRequest().getCard());
        response.setResponse(
                new OperationResponse(
                        new ResponseData(0, "Success"),
                        balance
                )
        );
    }


}
