package com.dev.kolun.alex.binservlet.example.bean.service;

public interface OperationService {

    long cashWithdrawal(String card, long amount);

    long inCash(String card, long amount);

    long balance(String card);

}
