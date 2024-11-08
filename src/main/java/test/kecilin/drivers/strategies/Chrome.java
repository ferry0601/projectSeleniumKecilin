package test.kecilin.drivers.strategies;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements DriverStrategy{
    @Override
    public ChromeDriver setStrategy(){
        String path = "C:\\Fikri\\chromedriver.exe" ;
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--no-sanbox");
        return new ChromeDriver(options);

    }
}
