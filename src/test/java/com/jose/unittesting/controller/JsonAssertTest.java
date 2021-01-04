package com.jose.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAsset_StringTrue_ExactMatchExceptForSpaces() throws JSONException {
        //permite espacios , pero deben estar todos los elementos del JSON
        String expectedResponse="{\"id\": 1,\"name\" :\"Ball\",\"price\": 10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonAsset_StringFalse() throws JSONException {
        //para hacer match comprueba los parametros que existen en expected no son necesarios todos los parametros
        String expectedResponse="{\"id\": 1,\"name\" :\"Ball\",\"price\": 10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }
}
