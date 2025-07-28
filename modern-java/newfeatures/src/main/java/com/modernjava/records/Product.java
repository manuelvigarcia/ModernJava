package com.modernjava.records;

import java.math.BigDecimal;

public record Product(String name,
                      BigDecimal cost,
                      String type) {

    public Product {
        if (name!= null && name.isBlank()){
            throw new IllegalArgumentException("name cannot be blank.");
        }
        if (cost.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("cost cannot be negative.");
        }
    }

    public Product (String name, BigDecimal cost){
        this(name, cost, "GENERAL");
    }
}
