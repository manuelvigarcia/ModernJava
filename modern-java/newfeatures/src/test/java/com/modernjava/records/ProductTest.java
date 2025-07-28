package com.modernjava.records;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void createProduct(){
        var product = new Product("Iphone", new BigDecimal("999.99"), "ELECTRONICS");

        System.out.println("product= " + product);
        assertEquals("Iphone", product.name());
        assertEquals("ELECTRONICS", product.type());
        assertEquals(new BigDecimal("999.99"), product.cost());
    }

    @Test
    void createProduct_nameNotValid(){
        var exception = assertThrows(IllegalArgumentException.class,
                () ->new Product("", new BigDecimal("999.99"), "ELECTRONICS"));
        assertEquals("name cannot be blank.", exception.getMessage());
    }

    @Test
    void createProduct_costNotValid(){
        var exception = assertThrows(IllegalArgumentException.class,
                () ->new Product("Iphone", new BigDecimal("-1"), "ELECTRONICS"));
        assertEquals("cost cannot be negative.", exception.getMessage());

    }

    @Test
    void createProduct_customConstructor(){
        var product = new Product("Iphone", new BigDecimal("999.99"));
        assertEquals("Iphone", product.name());
        assertEquals(new BigDecimal("999.99"), product.cost());
        assertEquals("GENERAL", product.type());
    }

    @Test
    void productComparison(){
        var product = new Product("Iphone", new BigDecimal("999.99"), "ELECTRONICS");
        var product1 = new Product("Iphone", new BigDecimal("999.99"), "ELECTRONICS");

        assertEquals(product, product1);
    }
}