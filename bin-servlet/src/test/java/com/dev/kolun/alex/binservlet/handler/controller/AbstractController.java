package com.dev.kolun.alex.binservlet.handler.controller;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

@BinController
public abstract class AbstractController {

    @BinRequestMapping(path = "abstract/method1")
    public abstract void method1(Request<?> request, Response<?> response);

    @BinRequestMapping(path = "abstract/method2")
    private void method2(Request<?> request, Response<?> response){

    }

    @BinRequestMapping(path = "abstract/method3")
    public void method3(Request<?> request, Response<?> response){

    }

    @BinRequestMapping(path = "abstract/method4")
    public void method4(Request<?> request, Response<?> response){

    };




}
