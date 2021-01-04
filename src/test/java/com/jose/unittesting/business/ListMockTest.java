package com.jose.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mock;
public class ListMockTest {

    List<String> list=mock(List.class);

    @Test
    public void size_basic(){
        List list=mock(List.class);
        when(list.size()).thenReturn(5);
        assertEquals(5,list.size());
    }

    @Test
    public void returnDifferentValues(){
        List list=mock(List.class);
        when(list.size()).thenReturn(5).thenReturn(8);
        assertEquals(5,list.size());
        assertEquals(8,list.size());
    }

    @Test
    public void withParameters(){
        List list=mock(List.class);
        when(list.get(0)).thenReturn("jose");
        assertEquals("jose",list.get(0));
        assertEquals(null,list.get(1));
    }

    @Test
    public void anyParameters(){

        when(list.get( anyInt() )).thenReturn("jose");
        assertEquals("jose",list.get(0));
        assertEquals("jose",list.get(1));
    }

    @Test
    public void verificationBasic(){
        //sut
        String value1=list.get(0);
        String value2=list.get(1);
        //verify
        verify(list,times(2)).get(anyInt());
        verify(list,atLeast(2)).get(anyInt());
        verify(list,atLeastOnce()).get(anyInt());
        verify(list,atMost(3)).get(anyInt());
        verify(list,never()).get(99);
    }

    @Test
    public void argumentCapturing(){
        //sut
        list.add("java");
        //verify
        ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
        verify(list).add(argumentCaptor.capture());
        assertEquals("java",argumentCaptor.getValue());
    }

    @Test
    public void multipleArgumentCapturing(){
        //sut
        list.add("java");
        list.add("spring");

        //verify
        ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
        //verifying is the list's arguments are string
        verify(list,times(2)).add(argumentCaptor.capture());

        //verifying the list's values are the same that the initializing
        List<String> arguments=argumentCaptor.getAllValues();
        assertEquals("java",arguments.get(0));
        assertEquals("spring",arguments.get(1));
    }

    @Test
    public void spying_intro(){
        ArrayList arrayListMock=mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); //0
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size()); //0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5
    }

    @Test
    public void spying(){
        ArrayList arrayListMock=spy(ArrayList.class);
        arrayListMock.add("test0");
        System.out.println(arrayListMock.get(0)); //test0
        System.out.println(arrayListMock.size()); //1
        arrayListMock.add("test");
        arrayListMock.add("test2");
        System.out.println(arrayListMock.size()); //3

        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); //5
    }
}
