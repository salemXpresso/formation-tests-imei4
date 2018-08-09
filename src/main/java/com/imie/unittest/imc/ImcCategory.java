package com.imie.unittest.imc;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ImcCategory {

    private static Map<Integer, String> categoriesLabel = new HashMap<Integer, String>() {
        {
            put(1, "Famine");
            put(2, "Maigreur");
            put(3, "Corpulence normale");
            put(4, "Surpoids");
            put(5, "Obésité modérée");
            put(6, "Obésité sévère");
            put(7, "Obésité morbide ou massive");
        }
    };

    public int getCategory(int imc) {
        if(imc < 0) {
            throw new IllegalArgumentException("Imc can't be less than zero");
        } else if(imc < 17) {
            return 1;
        } else if(imc == 17 || imc == 18) {
            return 2;
        } else if(imc > 18 && imc <= 25) {
            return 3;
        } else if(imc > 25 && imc <= 30) {
            return 4;
        } else if(imc > 30 && imc <= 35) {
            return 5;
        } else if(imc > 35 && imc <= 40) {
            return 6;
        } else {
            return 7;
        }
    }

    public String getCategoryLabel(int category) {
        String categoryName = categoriesLabel.get(category);
        if(categoryName == null ) {
            throw new IllegalArgumentException("Unknown category");
        }
        return categoryName;
    }
}
