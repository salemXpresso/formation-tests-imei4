package com.imie.unittest.functional;

import com.imie.unittest.functional.driverfactory.DriverFactory;
import com.imie.unittest.functional.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ImcFormStepTest extends FluentCucumberTest {

    @Page
    HomePage homePage;

    public ImcFormStepTest() {

        DriverFactory driverFactory = new DriverFactory();
        initFluent(driverFactory.getDriver());
    }

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

    @When("^The user selects <(.*)> gender$")
    public void fillGender(String gender) {
        WebElement genderSelect = getDriver().findElement(By.id("sexe"));
        assertThat(genderSelect.isDisplayed()).isTrue();
        Select genderElement = new Select(genderSelect);
        genderElement.selectByVisibleText(gender);

        System.out.println("Gender filled: " + gender);
    }

    @When("The user fill the height box with <(\\d+)>")
    public void fillHeight(int height) {
        WebElement heightElement = getDriver().findElement(By.id("taille"));
        heightElement.sendKeys("" + height);
        System.out.println("Height: " + height);
    }

    @When("The user fill the weight box with <(\\d+)>")
    public void fillWeight(int weight) {
        WebElement weightElement = getDriver().findElement(By.id("poids"));
        weightElement.sendKeys("" + weight);
        System.out.println("Weight: " + weight);
    }

    @When("^The user fill the age box with <(\\d+)>$")
    public void fillAge(int age) {
        WebElement ageElement = getDriver().findElement(By.id("age"));
        ageElement.sendKeys("" + age);
        System.out.println("age: " + age);
    }

    @When("The user submits the form")
    public void submit()  {
        getDriver().findElement(By.id("calcul")).click();
        System.out.println("submit");
    }

    @Then("The IMC result box is displayed")
    public void checkResult()  {
        assertThat(getDriver().findElement(By.id("resultat")).isDisplayed());
    }

    @Then("^The calculated IMC is <(\\d+\\.\\d+)>$")
    public void checkImc(float expectedImc)  {
        WebElement resultatDiv = getDriver().findElement(By.id("resultat"));
        List<WebElement> pTags = resultatDiv.findElements(By.tagName("p"));
        assertThat(pTags).isNotEmpty();
        String imc = pTags.get(0).findElement(By.tagName("span")).getText();
        assertThat(imc).startsWith("" + expectedImc);
    }

    @Then("^The calculated IMC label is <(.*)>$")
    public void checkLabel(String expectedLabel)  {
        WebElement resultatDiv = getDriver().findElement(By.id("resultat"));
        List<WebElement> pTags = resultatDiv.findElements(By.tagName("p"));
        String imcLabel = pTags.get(1).findElement(By.tagName("span")).getText();
        assertThat(imcLabel).isEqualTo(expectedLabel);
    }

    @Then("The user closes his Web browser")
    public void closeBrowser() {
        getDriver().close();
    }
}
