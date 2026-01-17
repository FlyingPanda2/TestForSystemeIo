package utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    @BeforeEach
    public void setUp(){
        Configuration.remote = "http://localhost:4444";
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
    }

    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }
}