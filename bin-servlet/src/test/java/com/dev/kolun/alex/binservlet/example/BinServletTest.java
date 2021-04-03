package com.dev.kolun.alex.binservlet.example;

import com.dev.kolun.alex.binservlet.example.bean.TestConfiguration;
import com.dev.kolun.alex.binservlet.dispatcher.BinServlet;
import com.dev.kolun.alex.binservlet.example.dto.OperationRequest;
import com.dev.kolun.alex.binservlet.example.dto.OperationResponse;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestConfiguration.class)
public class BinServletTest {

    @Autowired
    private BinServlet binServlet;

    @Test
    @DisplayName("Test charge method in controller")
    public void chargeTest() {
        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest("123", "charge", "5220202020202020205", 100L, "salary")
        );
        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals((short) 200, wrapResponse.getResponse().getStatus());
        assertEquals("Success", wrapResponse.getResponse().getMessage());

    }

    @Test
    @DisplayName("Test charge method in controller")
    public void cashWithdrawalTest() {
        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest("123", "cashWithdrawal", "5220202020202020205", 100L, "salary")
        );
        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals((short) 404, wrapResponse.getResponse().getStatus());
        assertEquals("Pan not found", wrapResponse.getResponse().getMessage());
    }

    @ParameterizedTest
    @DisplayName("Test filter and interceptor sequence")
    @ValueSource(strings = {"charge", "cashWithdrawal"})
    public void filterAndInterceptorSequenceTest(String operationType) {
        OperationWrapRequest wrapRequest = new OperationWrapRequest(
                new OperationRequest("123", operationType, "5220202020202020205", 100L, "salary")
        );
        OperationWrapResponse wrapResponse = new OperationWrapResponse(new OperationResponse());

        binServlet.service(wrapRequest, wrapResponse);

        assertEquals("FirstFilter", wrapResponse.getAttribute(0));
        assertEquals("SecondFilter", wrapResponse.getAttribute(1));
        assertEquals("FirstIsoInterceptor before", wrapResponse.getAttribute(2));
        assertEquals("SecondIsoInterceptor before", wrapResponse.getAttribute(3));
        assertEquals("SecondIsoInterceptor after", wrapResponse.getAttribute(4));
        assertEquals("FirstIsoInterceptor after", wrapResponse.getAttribute(5));
        assertEquals("SecondFilter finally", wrapResponse.getAttribute(6));
        assertEquals("FirstFilter finally", wrapResponse.getAttribute(7));

    }

}
