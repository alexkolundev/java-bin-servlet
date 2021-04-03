package com.dev.kolun.alex.binservlet.example.bean.controller;

import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;

@BinController
public class OperationController {

    @BinRequestMapping(path = "operation/charge")
    public void charge(OperationWrapRequest request, OperationWrapResponse response){
        response.getResponse().setStatus((short) 200);
        response.getResponse().setMessage("Success");
    }

    @BinRequestMapping(path = "operation/cashWithdrawal")
    public void cashWithdrawal(OperationWrapRequest request, OperationWrapResponse response){
        response.getResponse().setStatus((short) 404);
        response.getResponse().setMessage("Pan not found");
    }





}
