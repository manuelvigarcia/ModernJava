package com.modernjava.paymentservice.domain;

public record OrderDetails(String orderId,

                           Card card,
                           double finalAmount) {
}
