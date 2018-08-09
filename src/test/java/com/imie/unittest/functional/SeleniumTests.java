package com.imie.unittest.functional;

import cucumber.api.java.en.Then;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;

import java.io.File;
import java.util.HashMap;

@TestPropertySource("classpath:conf/conf.properties")
public class SeleniumTests {

    private WebDriver driver;

    // TODO @Value("${chrome.portable.path}")
    private String browserPath="C:/_work/tools/GoogleChromePortable/GoogleChromePortable.exe";

    // TODO @Value("${chrome.driver.path}")
    private String driverPath="C:/_work/tools/GoogleChromePortable/chromedriver.exe";

    public SeleniumTests() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserPath);

        HashMap<String, Object> chromePrefs = new HashMap<>();
        options.setExperimentalOption("prefs", chromePrefs);
        // Play with the window size
        options.addArguments("--start-maximized"); // full screen
        // options.addArguments("window-size=1024,768"); // or special size

        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, driverPath);

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverPath))
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(service, options);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
