package com.modernjava.paymentservice.service;

import com.modernjava.paymentservice.domain.Card;
import com.modernjava.paymentservice.domain.CardType;
import com.modernjava.paymentservice.domain.CheckOutStatus;
import com.modernjava.paymentservice.domain.OrderDetails;
import com.modernjava.paymentservice.payment.PaymentService;
import com.modernjava.paymentservice.service.CheckoutService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutServiceTest {


    PaymentService paymentService = new PaymentService();
    CheckoutService checkoutService = new CheckoutService(paymentService);

    @EnumSource(CardType.class)
    @ParameterizedTest(name = "Checkout for Card type : {0}")
    void checkout(CardType cardType){
        var orderDetails = orderDetails(cardType);
        var response = checkoutService.checkoutOrder(orderDetails);
        assertEquals(CheckOutStatus.SUCCESS, response);
    }

    static OrderDetails orderDetails(CardType cardType) {

        var card = new Card("ABC", "7676709809809809",
                "4567", "09/99", cardType);
        return new OrderDetails("1234", card, 99.0);

    }
}
