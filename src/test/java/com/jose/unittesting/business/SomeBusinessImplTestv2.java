package com.jose.unittesting.business;

import com.jose.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceStubEmpty implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceStubOneValue implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[]{3};
    }
}

class SomeBusinessImplTestv2 {

    @Test
    void calculateSumUsingDataService_basic() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStub());
        int actualResult=someBusiness.calculateSumUsingDataService();
        int expectedResult=6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSumUsingDataService_basic_empty() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStubEmpty());
        int actualResult=someBusiness.calculateSumUsingDataService();
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void calculateSumUsingDataService_one_value() {
        SomeBusinessImpl someBusiness=new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStubOneValue());
        int actualResult=someBusiness.calculateSumUsingDataService();
        int expectedResult=3;
        assertEquals(expectedResult,actualResult);
    }

}