package com.modernjava.paymentservice.service;

import com.modernjava.paymentservice.domain.CheckOutStatus;
import com.modernjava.paymentservice.domain.OrderDetails;
import com.modernjava.paymentservice.domain.PaymentResponse;
import com.modernjava.paymentservice.payment.PaymentService;

public class CheckoutService {

    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public CheckOutStatus checkoutOrder(OrderDetails orderDetails){

        var paymentResponse = paymentService.makePayment(orderDetails);
        if(paymentResponse.equals(PaymentResponse.SUCCESS)){
            return CheckOutStatus.SUCCESS;
        }
        return CheckOutStatus.FAILURE;

    }
}
