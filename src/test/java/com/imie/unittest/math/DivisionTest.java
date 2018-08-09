package com.imie.unittest.math;

import com.imie.unittest.ws.client.WsClient;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DivisionTest {

    @Mock
    private WsClient multiplication;

    @InjectMocks
    private Division division;

    @Before
    public void setUp() throws IOException, JSONException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(multiplication.negative(-512)).thenReturn(512);
        Mockito.when(multiplication.negative(-15)).thenReturn(15);
        Mockito.when(multiplication.negative(34)).thenReturn(-34);
    }

    @Test
    public void testDivide_oneParamNegative_returnNegative() throws IOException, JSONException {

        assertThat(division.divide(-512, 15)).isEqualTo(-34);
        assertThat(division.divide(512, -15)).isEqualTo(-34);
    }

    @Test
    public void testDivide_bothNegative_returnPositive() throws IOException, JSONException {

        assertThat(division.divide(-512, -15)).isEqualTo(34);
    }

    @Test
    public void testDivide_bothPositive_returnPositive() throws IOException, JSONException {

        assertThat(division.divide(15, 3)).isEqualTo(5);
        assertThat(division.divide(20, 6)).isEqualTo(3);
        assertThat(division.divide(4, 5)).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide_aZero_throwException() throws IOException, JSONException {

        division.divide(10, 0);
    }

    @Test
    public void testDivide_bZero_returnZero() throws IOException, JSONException {

        assertThat(division.divide(0, 10)).isZero();
    }
}