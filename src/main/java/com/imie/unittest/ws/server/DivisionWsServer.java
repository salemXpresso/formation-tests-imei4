package com.imie.unittest.ws.server;

import com.imie.unittest.math.Division;
import com.imie.unittest.ws.model.IntegerResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DivisionWsServer {

    @Autowired
    private Division division;

    @RequestMapping("/divide")
    public IntegerResponse divide(@RequestParam int a, @RequestParam int b) throws IOException, JSONException {
        return new IntegerResponse(division.divide(a, b));
    }
}
