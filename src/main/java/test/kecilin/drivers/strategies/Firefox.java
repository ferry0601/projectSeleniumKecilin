package test.kecilin.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        String path = "D:\\browserDriver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
