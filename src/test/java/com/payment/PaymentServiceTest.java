package com.payment;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    PaymentService paymentService = new PaymentService();

    @Test
    public void paymentResultRandomGenTestArray() {

        List<PaymentResult> resultList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            resultList.add(paymentService.getPaymentResult());
        }

        assertTrue(!resultList.isEmpty()
                && resultList.contains(PaymentResult.SUCCESS)
                && resultList.contains(PaymentResult.FAILURE));
    }

    @Test
    public void paymentResultRandomGenTestCounter() {

        int successCounter = 0;
        int failureCounter = 0;

        for (int i = 0; i < 1000; i++) {
            PaymentResult paymentResult = paymentService.getPaymentResult();
            if (paymentResult.equals(PaymentResult.SUCCESS)) {
                successCounter++;
            } else {
                failureCounter++;
            }
        }

        assertTrue(successCounter != 0 && failureCounter != 0);

    }
}