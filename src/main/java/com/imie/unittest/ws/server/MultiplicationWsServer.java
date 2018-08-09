package com.imie.unittest.ws.server;

import com.imie.unittest.math.Multiplication;
import com.imie.unittest.ws.model.IntegerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicationWsServer {

    @Autowired
    private Multiplication multiplication;

    @RequestMapping("/multiply")
    public IntegerResponse multiply(@RequestParam int a, @RequestParam int b) {
        return new IntegerResponse(multiplication.multiply(a, b));
    }

    @RequestMapping("/negative")
    public IntegerResponse negative(@RequestParam int a) {
        return new IntegerResponse(multiplication.negative(a));
    }
}
