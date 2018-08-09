package com.imie.unittest.math;

import com.imie.unittest.ws.client.WsClient;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Division {

    @Autowired
    private WsClient multClient;

    public int divide(int a, int b) throws IOException, JSONException {

        if (b == 0) {
            throw new IllegalArgumentException("Divide by zero error");
        } else if (a < 0 && b < 0) {
            return divide(multClient.negative(a), multClient.negative(b));
        }
        int sum = 0;
        int res = 0;

        if (b < 0) {
            return multClient.negative(divide(a, multClient.negative(b)));
        } else if (a < 0) {
            return multClient.negative(divide(multClient.negative(a), b));
        } else if (a >= 0) {
            while (sum < a) {

                sum += b;
                if (!(sum > a)) {
                    res++;
                }
            }
        }
        return res;
    }
}
