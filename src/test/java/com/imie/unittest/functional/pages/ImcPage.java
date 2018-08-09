package com.imie.unittest.functional.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;

public class ImcPage extends FluentPage {

    public boolean isResultDisplayed() {

        FluentWebElement resultBox = $(By.id("resultat")).first();
        // The result is displayed when some paragraphs ("p") are present
        return resultBox.displayed() && !resultBox.$(By.tagName("p")).isEmpty();
    }

    public boolean isResultInconsistent() {

        FluentWebElement resultBox = $(By.id("resultat")).first();
        // The inconsistent result is displayed when there is only one paragraph ("p")
        return resultBox.displayed() && resultBox.$(By.tagName("p")).size() == 1;
    }
}
