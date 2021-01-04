package com.jose.unittesting.business;

import com.jose.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTestv2 {

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Mock
    SomeDataService someDataService;

    @BeforeEach
    private void setSomeDataService(){
        someBusiness.setSomeDataService(someDataService);
    }

    @Test
    void calculateSumUsingDataService_basic() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6, someBusiness.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_basic_empty() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0, someBusiness.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_one_value() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{3});
        assertEquals(3, someBusiness.calculateSumUsingDataService());
    }

}