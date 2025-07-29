package com.modernjava.paymentservice.payment;

import com.modernjava.paymentservice.domain.CardType;

public class PaymentFactory {
    public static PaymentGateway paymentGateway(CardType cardType){
        return switch (cardType){
            case DEBIT -> new DebitCardPayment();
            case CREDIT -> new CreditCardPayment();
            case REWARDS -> new RewardsCardPayment();
            case null -> throw new IllegalArgumentException("Card Type null not supported!");
        };
    }
}
