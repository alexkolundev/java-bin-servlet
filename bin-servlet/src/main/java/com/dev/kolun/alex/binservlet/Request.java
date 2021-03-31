package com.dev.kolun.alex.binservlet;

public interface Request<T> {

    T getRequest();

    String getPath();

}
