package com.imie.unittest.ws.model;

public class ImcResponse {

    private int imc, category;

    private String categoryLabel;

    public ImcResponse(int imc, int category, String categoryName) {
        this.imc = imc;
        this.category = category;
        this.categoryLabel = categoryName;
    }

    public int getImc() {
        return imc;
    }

    public int getCategory() {
        return category;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }
}
