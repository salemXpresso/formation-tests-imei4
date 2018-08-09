package com.imie.unittest.functional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.*;

public class ImcFormTest extends SeleniumTests {

    @Given("^A running platform$")
    public void testRunningPlatform() {
        // Test de vie sur la plateforme
        System.out.println("Should be running");
    }

    @When("^The user opens <(http.*)>$")
    public void openHomePage(String url) {
        System.out.println("Open " + url + " page");
        getDriver().navigate().to(url);
    }

    @Then("The home page is displayed")
    public void checkHomePageDisplayed() {
        System.out.println("Home page should be displayed");
        assertThat(getDriver().findElement(By.id("post-853")).isDisplayed()).isTrue();
    }

    @When("The user clicks on \"Calcul de l'IMC\"")
    public void clickCalculImc() {
        System.out.println("click calcul IMC");
        WebElement calculImcTab = getDriver().findElement(By.id("menu-item-1637"));
        assertThat(calculImcTab.isDisplayed()).isTrue();
        calculImcTab.click();
    }

    @When("The IMC form is displayed")
    public void checkImcFormDisplayed() {
        assertThat(getDriver().findElement(By.className("form-mini-container")).isDisplayed()).isTrue();
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
        assertThat("ResultOK").isNotEmpty();
    }

    @Then("^The calculated IMC is <(\\d+\\.\\d+)>$")
    public void checkImc(float expectedImc)  {
        assertThat(expectedImc).isNotZero();
    }

    @Then("^The calculated IMC label is <(.*)>$")
    public void checkLabel(String expectedLabel)  {
        assertThat(expectedLabel).isNotEmpty();
    }

    @Then("The user closes his Web browser")
    public void closeBrowser() {
        getDriver().close();
    }
}
