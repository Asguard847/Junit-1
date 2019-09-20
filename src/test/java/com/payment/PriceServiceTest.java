package com.payment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PriceServiceTest {

    PriceService priceService = new PriceService();

    @Test
    public void priceServiceCorrectInputTest(){
        priceService.validatePrice(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void priceServiceExceptionThrownTest() {
        priceService.validatePrice(-1);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void priceServiceExceptionMessageTest() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Incorrect total Price");
        priceService.validatePrice(-1);
    }
}