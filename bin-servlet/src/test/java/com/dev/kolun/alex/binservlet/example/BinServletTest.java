package com.dev.kolun.alex.binservlet.example;

import com.dev.kolun.alex.binservlet.dispatcher.BinServlet;
import com.dev.kolun.alex.binservlet.example.bean.TestConfiguration;
import com.dev.kolun.alex.binservlet.example.bean.service.OperationService;
import com.dev.kolun.alex.binservlet.example.bean.service.SecurityService;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import com.dev.kolun.alex.binservlet.example.protocol.dto.OperationRequest;
import com.dev.kolun.alex.binservlet.example.protocol.dto.OperationResponse;
import com.dev.kolun.alex.binservlet.example.protocol.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestConfiguration.class)
public class BinServletTest {

    @Autowired
    private BinServlet binServlet;

    @Autowired
    private OperationService operationService;

    @Autowired
    private SecurityService securityService;

    @Test
    public void inCashTest() {
        String token = "123";
        String card = "5220202020202020206";
        long amount = 100L;
        long balance = 150L;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.inCash(card, amount)).thenReturn(balance);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "inCash", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(0, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Success", wrapResponse.getResponse().getResponseData().getMessage());
        assertEquals(wrapResponse.getResponse().getBalance(), balance);
        checkFilterAndInterceptor(wrapResponse);
    }

    @Test
    public void inCashFailTest() {
        String token = "123";
        String card = "5220202020202020205";
        long amount = 100L;
        String message = "Card not found";
        int status = 102;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.inCash(card, amount)).thenThrow(new ServiceException(status, message));

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "inCash", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(status, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals(message, wrapResponse.getResponse().getResponseData().getMessage());
        checkFilterAndInterceptorWithFail(wrapResponse);
    }

    @Test
    public void inCashFailTokenTest() {
        String token = "125";
        String card = "5220202020202020205";
        long amount = 100L;

        Mockito.doThrow(new SecurityException()).when(securityService).checkToken(token);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "inCash", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(500, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Unknown error", wrapResponse.getResponse().getResponseData().getMessage());
        checkFilterAndInterceptorWithFail(wrapResponse);
    }

    @Test
    public void cashWithdrawalTest() {
        String token = "123";
        String card = "5220202020202020206";
        long amount = 100L;
        long balance = -50L;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.cashWithdrawal(card, amount)).thenReturn(balance);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "cashWithdrawal", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(0, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Success", wrapResponse.getResponse().getResponseData().getMessage());
        assertEquals(wrapResponse.getResponse().getBalance(), balance);
        checkFilterAndInterceptor(wrapResponse);
    }

    @Test
    public void cashWithdrawalFailTest() {
        String token = "123";
        String card = "5220202020202020205";
        String message = "Card not found";
        int status = 102;
        long amount = 100L;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.cashWithdrawal(card, amount)).thenThrow(new ServiceException(status, message));

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "cashWithdrawal", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(status, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Card not found", wrapResponse.getResponse().getResponseData().getMessage());
        checkFilterAndInterceptorWithFail(wrapResponse);
    }

    @Test
    public void cashWithdrawalFailTokenTest() {
        String token = "125";
        String card = "5220202020202020205";
        long amount = 100L;

        Mockito.doThrow(new SecurityException()).when(securityService).checkToken(token);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "cashWithdrawal", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(500, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Unknown error", wrapResponse.getResponse().getResponseData().getMessage());
        checkFilterAndInterceptorWithFail(wrapResponse);
    }

    @Test
    public void balanceTest() {
        String token = "123";
        String card = "5220202020202020205";
        long amount = 0L;
        long balance = 400L;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.balance(card)).thenReturn(balance);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "balance", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(0, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Success", wrapResponse.getResponse().getResponseData().getMessage());
        assertEquals(wrapResponse.getResponse().getBalance(), balance);
        checkFilterAndInterceptor(wrapResponse);
    }

    @Test
    public void balanceFailTest() {
        String token = "123";
        String card = "5220202020202020205";
        long amount = 100L;
        long balance = 400L;

        Mockito.doNothing().when(securityService).checkToken(token);
        Mockito.when(operationService.balance(card)).thenReturn(balance);

        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest(token, "balance", card, amount)
        );

        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals(100, wrapResponse.getResponse().getResponseData().getStatus());
        assertEquals("Balance transaction must be with a zero amount", wrapResponse.getResponse().getResponseData().getMessage());
        checkFilterAndInterceptorWithFail(wrapResponse);
    }

    private void checkFilterAndInterceptor(OperationWrapResponse wrapResponse){
        assertEquals("FirstFilter", wrapResponse.getAttribute(0));
        assertEquals("SecondFilter", wrapResponse.getAttribute(1));
        assertEquals("FirstIsoInterceptor before", wrapResponse.getAttribute(2));
        assertEquals("SecondIsoInterceptor before", wrapResponse.getAttribute(3));
        assertEquals("SecondIsoInterceptor after", wrapResponse.getAttribute(4));
        assertEquals("FirstIsoInterceptor after", wrapResponse.getAttribute(5));
        assertEquals("SecondFilter finally", wrapResponse.getAttribute(6));
        assertEquals("FirstFilter finally", wrapResponse.getAttribute(7));
    }

    private void checkFilterAndInterceptorWithFail(OperationWrapResponse wrapResponse){
        assertEquals("FirstFilter", wrapResponse.getAttribute(0));
        assertEquals("SecondFilter", wrapResponse.getAttribute(1));
        assertEquals("FirstIsoInterceptor before", wrapResponse.getAttribute(2));
        assertEquals("SecondIsoInterceptor before", wrapResponse.getAttribute(3));
        assertEquals("SecondIsoInterceptor after exception", wrapResponse.getAttribute(4));
        assertEquals("FirstIsoInterceptor after exception", wrapResponse.getAttribute(5));
        assertEquals("SecondFilter finally", wrapResponse.getAttribute(6));
        assertEquals("FirstFilter finally", wrapResponse.getAttribute(7));
    }


}
