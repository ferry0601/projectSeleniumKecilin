package test.kecilin.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.kecilin.drivers.strategies.DriverStrategy;
import test.kecilin.drivers.strategies.DriverStrategyImplementer;
import test.kecilin.utils.Constants;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;
    private DriverSingleton(String driver){instantiate(driver);}

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


    public static DriverSingleton getInstance(String driver){
        if (instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
        }
        return driver;}
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Clear the instance after quitting
        }
    }

    public static void delay(double detik){
        try{
            Thread.sleep((long) (detik*1000));
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
//    public static void (WebDriver driver){
//        driver.findElement(locator)
//    }

    public static void closeObjectInstance(){
        instance = null;
        quitDriver();
    }



    public static void switchToNewTab(String targetUrl) {
//        driver.get("https://staging.ptkta.com/psikotest-web/rules/29");
//        ((JavascriptExecutor) driver).executeScript("window.open('https://staging.ptkta.com/psikotest-web/question/29','_blank');");
        Set<String> allHandles = driver.getWindowHandles();
        // Iterasi melalui semua handle
        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(targetUrl)) {
                break;
            }
        }
        System.out.println("Saat ini berada di tab dengan URL: " + driver.getCurrentUrl());
    }
}
