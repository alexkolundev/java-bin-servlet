package com.dev.kolun.alex.binservlet.filter;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;

/**
 * A filter is an object that processes requests and responses sequentially.
 * <br>
 * <p>
 * For example, you can create proxy request {@link Request} before
 * {@link BinController controllers} or
 * response {@link Response} after {@link BinController controllers}
 * <br>
 * A simplified analogue of the classic Chain of Responsibility is Servlet Filters in Java javax.servlet.Filter
 */
public interface Filter {

    void doFilter(Request<?> request, Response<?> response, FilterChain chain);
}
