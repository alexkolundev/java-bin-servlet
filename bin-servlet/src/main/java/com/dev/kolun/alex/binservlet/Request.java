package com.dev.kolun.alex.binservlet;

import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;

/**
 * Represents an abstract request message.
 * Method {@linkplain #getPath method} and {@linkplain #getRequest method}
 *
 * @param <T> the POJO request type
 *
 */
public interface Request<T> {

    /**
     * Get request
     * @return POJO request message
     */
    T getRequest();

    /**
     * Get redirect path for request message
     *
     * @see BinController annotation
     * @see BinRequestMapping annotation
     *
     * @return redirect path to controller method
     */
    String getPath();

}
