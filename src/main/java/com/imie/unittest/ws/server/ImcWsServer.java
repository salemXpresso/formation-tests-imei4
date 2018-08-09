package com.imie.unittest.ws.server;

import com.imie.unittest.imc.ImcCalculator;
import com.imie.unittest.imc.ImcCategory;
import com.imie.unittest.math.Division;
import com.imie.unittest.ws.model.ImcResponse;
import com.imie.unittest.ws.model.IntegerResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImcWsServer {

    @Autowired
    private ImcCalculator imcCalculator;

    @Autowired
    private ImcCategory imcCategory;

    @RequestMapping("/imc")
    public ImcResponse calculateImc(@RequestParam int taille, @RequestParam int poids)
            throws IOException, JSONException {
        int imc = imcCalculator.calculateImc(taille, poids);
        int category = imcCategory.getCategory(imc);
        String label = imcCategory.getCategoryLabel(category);
        return new ImcResponse(imc, category, label);
    }
}
