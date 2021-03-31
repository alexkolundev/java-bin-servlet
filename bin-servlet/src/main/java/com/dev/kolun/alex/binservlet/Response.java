package com.dev.kolun.alex.binservlet;

/**
 * Represents an abstract response message.
 *
 * @param <T> the POJO response type
 */
public interface Response<T> {

    /**
     * Returns a boolean flag if the response has been committed.
     *
     * @return a boolean indicating if the response message has been committed
     */
    boolean isCommitted();

    /**
     * Set a boolean flag if the response message has been committed.
     * <br>
     * Can be used for final resolve response.
     *
     * @param committed a boolean indicating if the response message has been committed
     */
    void setCommitted(boolean committed);

    /**
     * Get response
     *
     * @return POJO response message
     */
    T getResponse();

    /**
     * Set response
     *
     * @param response POJO response message
     */
    void setResponse(T response);

}
