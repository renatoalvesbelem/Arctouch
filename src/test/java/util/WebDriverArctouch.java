package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverArctouch {

    public WebDriver firefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/util/geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }
}
