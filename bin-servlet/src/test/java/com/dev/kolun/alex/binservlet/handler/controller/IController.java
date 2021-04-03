package com.dev.kolun.alex.binservlet.handler.controller;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

@BinController
public interface IController {


    void method1(Request<?> request, Response<?> response);

    @BinRequestMapping(path = "interface/method2")
    void method2(Request<?> request, Response<?> response);

    @BinRequestMapping(path = "interface/method3")
    default void method3(Request<?> request, Response<?> response){

    };


}
