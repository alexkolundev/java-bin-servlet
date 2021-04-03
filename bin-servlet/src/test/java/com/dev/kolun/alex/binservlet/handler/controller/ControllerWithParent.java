package com.dev.kolun.alex.binservlet.handler.controller;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

public class ControllerWithParent extends AbstractController {

    @Override
    @BinRequestMapping(path = "abstract/method1")
    public void method1(Request<?> request, Response<?> response) {

    }


    @Override
    public void method4(Request<?> request, Response<?> response){

    };

    @BinRequestMapping(path = "abstract/method5")
    public void method5(Request<?> request, Response<?> response) {

    }

}
