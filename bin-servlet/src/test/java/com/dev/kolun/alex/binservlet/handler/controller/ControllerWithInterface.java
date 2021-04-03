package com.dev.kolun.alex.binservlet.handler.controller;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

@BinController
public class ControllerWithInterface implements IController {


    @Override
    @BinRequestMapping(path = "interface/method1")
    public void method1(Request<?> request, Response<?> response) {

    }

    @Override
    public void method2(Request<?> request, Response<?> response) {

    }

    @BinRequestMapping(path = "interface/method4")
    public void method4(Request<?> request, Response<?> response) {

    }

}
