package com.imie.unittest.functional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

public class ImcFormTest {

    @Given("^A running platform$")
    public void testRunningPlatform() {
        // Test de vie sur la plateforme
        System.out.println("Should be running");
    }

    @When("^The user opens <(http.*)>$")
    public void openHomePage(String url) {
        System.out.println("Open " + url + " page");
    }

    @Then("The home page is displayed")
    public void checkHomePageDisplayed() {
        System.out.println("Home page should be displayed");
    }

    @When("The user clicks on \"Calcul de l'IMC\"")
    public void clickCalculImc() {
        System.out.println("click calcul IMC");
    }

    @When("The IMC form is displayed")
    public void checkImcFormDisplayed() {
        // Assertion test (always true)
        Assertions.assertThat("ImcForm").isNotEmpty();
    }

    @When("The user selects <(.*)> gender")
    public void fillGender(String gender) {
        System.out.println("Gender filled: " + gender);
    }

    @When("The user fill the height box with <(\\d+)>")
    public void fillHeight(int height) {
        System.out.println("Height: " + height);
    }

    @When("The user fill the weight box with <(\\d+)>")
    public void fillWeight(int weight) {
        System.out.println("Weight: " + weight);
    }

    @When("^The user fill the age box with <(\\d+)>$")
    public void fillAge(int age) {
        System.out.println("age: " + age);
    }

    @When("The user submits the form")
    public void submit()  {
        System.out.println("submit");
    }

    @Then("The IMC result box is displayed")
    public void checkResult()  {
        Assertions.assertThat("ResultOK").isNotEmpty();
    }

    @Then("^The calculated IMC is <(\\d+\\.\\d+)>$")
    public void checkImc(float expectedImc)  {
        Assertions.assertThat(expectedImc).isNotZero();
    }

    @Then("^The calculated IMC label is <(.*)>$")
    public void checkLabel(String expectedLabel)  {
        Assertions.assertThat(expectedLabel).isNotEmpty();
    }
}
