package com.modernjava.paymentservice.payment;

import com.modernjava.paymentservice.domain.Card;
import com.modernjava.paymentservice.domain.PaymentResponse;

public final class DebitCardPayment extends PaymentGateway {
    @Override
    public PaymentResponse makePayment(Card card, double amount) {
        System.out.println("Acquire Debit Card Payment for the amount = " + amount);
        return PaymentResponse.SUCCESS;
    }
}
