package com.imie.unittest.math;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MultiplicationTest {

    @Test
    public void testMultiply_aPostiveBNegative_returnNegative() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(5, -3);
        assertThat(resultat).isEqualTo(-15);
    }

    @Test
    public void testMultiply_bPostiveANegative_returnNegative() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(-5, 3);
        assertThat(resultat).isEqualTo(-15);
    }

    @Test
    public void testMultiply_aPostiveBPositive_returnPositive() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(5, 3);
        assertThat(resultat).isEqualTo(15);
    }

    @Test
    public void testMultiply_aNegativeBNegative_returnPositive() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(-5, -3);
        assertThat(resultat).isEqualTo(15);
    }

    @Test
    public void testMultiply_aZero_returnZero() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(0, -3);
        assertThat(resultat).isZero();
    }

    @Test
    public void testMultiply_bZero_returnZero() {

        Multiplication multiplication = new Multiplication();
        int resultat = multiplication.multiply(15, 0);
        assertThat(resultat).isZero();
    }
}
