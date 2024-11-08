package test.kecilin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.kecilin.drivers.DriverSingleton;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

//locator
    @FindBy(xpath = "/html/body/div/div[2]/form/div[5]/button")
    WebElement txtBtnLogin;
    @FindBy(xpath = "//*[@id=\"navbar\"]/ul/li[4]/form/button")
    WebElement btnLogout;

//method
    public void setBtnLogout(){
        btnLogout.click();
    }
    public String validasiLogout(){
        return txtBtnLogin.getText();
    }
}
