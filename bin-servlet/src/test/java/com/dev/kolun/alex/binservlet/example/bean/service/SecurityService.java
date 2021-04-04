package com.dev.kolun.alex.binservlet.example.bean.service;

public interface SecurityService {

    String getToken(String clientUuid);

    void checkToken(String token);

    void removeToken(String token);

}
