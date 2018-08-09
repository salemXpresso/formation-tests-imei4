package com.imie.unittest.imc;

import com.imie.unittest.imc.ImcCalculator;
import static org.assertj.core.api.Assertions.assertThat;

import com.imie.unittest.ws.client.WsClient;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class ImcCalculatorTest {

    @InjectMocks
    private ImcCalculator imcCalculator;

    @Mock
    private WsClient wsClient;

    @Before
    public void setUp() throws IOException, JSONException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(wsClient.multiply(60, 10000)).thenReturn(600000);
        Mockito.when(wsClient.multiply(165, 165)).thenReturn(27225);
        Mockito.when(wsClient.divide(600000, 27225)).thenReturn(22);
    }

    @Test
    public void testCalculate_nominal_returnNoError() throws IOException, JSONException {

        assertThat(imcCalculator.calculateImc(165, 60)).isEqualTo(22);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculate_weightInfZero_returnException() throws IOException, JSONException {

        imcCalculator.calculateImc(165, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculate_heightInfZero_returnException() throws IOException, JSONException {

        imcCalculator.calculateImc(-100, 5);
    }
}
