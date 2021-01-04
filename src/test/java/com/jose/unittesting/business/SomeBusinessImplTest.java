package com.jose.unittesting.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateSum_basic() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        int actualResult=someBusiness.calculateSum(new int[] {1,2,3});
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_empty() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        int actualResult=someBusiness.calculateSum(new int[] {});
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSum_one_value() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        int actualResult=someBusiness.calculateSum(new int[] {3});
        int expectedResult=3;
        assertEquals(expectedResult,actualResult);
    }
}