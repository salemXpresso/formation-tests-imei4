package com.imie.unittest.imc;

import com.imie.unittest.ws.client.WsClient;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ImcCalculator {

    @Autowired
    private WsClient wsClient;

    public int calculateImc(int heightCm, int weight) throws IOException, JSONException {

       if(heightCm <= 0 || weight <= 0) {
           throw new IllegalArgumentException("Height or weight shall not be less or equal 0");
       }
       return wsClient.divide(wsClient.multiply(weight, 10000), wsClient.multiply(heightCm, heightCm));
    }
}
