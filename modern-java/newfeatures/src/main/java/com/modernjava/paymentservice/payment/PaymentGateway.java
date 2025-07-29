package com.modernjava.paymentservice.payment;

import com.modernjava.paymentservice.domain.Card;
import com.modernjava.paymentservice.domain.PaymentResponse;

public sealed abstract class PaymentGateway permits DebitCardPayment, CreditCardPayment, RewardsCardPayment {
    public abstract PaymentResponse makePayment(Card card, double amount);
}
