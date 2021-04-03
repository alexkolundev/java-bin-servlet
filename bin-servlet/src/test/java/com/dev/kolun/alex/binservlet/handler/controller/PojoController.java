package com.dev.kolun.alex.binservlet.handler.controller;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

@BinController
public class PojoController {

    @BinRequestMapping(path = "pojo/method1")
    public void method1(Request<?> request, Response<?> response) {

    }

    @BinRequestMapping(path = "pojo/method2")
    private void method2(Request<?> request, Response<?> response) {

    }

    @BinRequestMapping(path = "pojo/method3")
    public static void method3(Request<?> request, Response<?> response) {

    }
}
