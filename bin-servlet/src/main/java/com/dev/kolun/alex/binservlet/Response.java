package com.dev.kolun.alex.binservlet;

public interface Response<T> {

    boolean isCommitted();

    void setCommitted(boolean committed);

    T getResponse();


}
