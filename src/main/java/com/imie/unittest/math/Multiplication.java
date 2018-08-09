package com.imie.unittest.math;

import org.springframework.stereotype.Component;

@Component
public class Multiplication {

    public int negative(int anyNumber) {
        return multiply(-1, anyNumber);
    }

    public int multiply(int a, int b) {

        int res = 0;

        if(b >= 0) {
            for(int i=0; i<b; i++) {
                res += a;
            }
        } else {
            for(int i=0; i>b; i--) {
                res -= a;
            }
        }
        return res;
    }
}
