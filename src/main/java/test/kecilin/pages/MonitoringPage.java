package test.kecilin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.kecilin.drivers.DriverSingleton;

public class MonitoringPage {
    private WebDriver driver;

    public MonitoringPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }


//locator
    @FindBy(xpath = "//*[@id=\"iconNavbarSidenav\"]")
    WebElement navbar;
    @FindBy(xpath = "//*[@id=\"submenu-dashboard\"]/li[3]/a")
    WebElement submenuMon;
    @FindBy(xpath = "//*[@id=\"navbarBlur\"]/div/nav/h6")
    WebElement validasiMonitoring;
    @FindBy(xpath = "/html/body/main/div[1]/div[1]/a")
    WebElement btnmonSet;
    @FindBy(xpath = "//*[@id=\"navbarBlur\"]/div/nav/h6")
    WebElement validasiMonSet;
    @FindBy(xpath = "//*[@id=\"select2-regional_office-container\"]")
    WebElement regional;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement inputTxt;
    @FindBy(xpath = "//*[@id=\"select2-kc_supervisi-container\"]/span")
    WebElement supervisi;
    @FindBy(xpath = "//*[@id=\"select2-search_tid-container\"]/span")
    WebElement cctvID;
    @FindBy(xpath = "//*[@id=\"data_table1\"]/tbody/tr/td[2]")
    WebElement validasiFilter;
    @FindBy(xpath = "//*[@id=\"btn_check_667988d136671935e2083c92\"]")
    WebElement checkBox;
    @FindBy(xpath = "/html/body/main/div[1]/div[1]/div/span[2]")
    WebElement validasiCheckbox;
    @FindBy(xpath = "//span[@class='alert-text']")
    WebElement validasiError;
    @FindBy(xpath = "//*[@id=\"select2-regional_office-container\"]/span")
    WebElement removeRegional;
    @FindBy(xpath = "//*[@id=\"data_table2\"]/tbody/tr[1]/td[2]")
    WebElement listexists;
    @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/div/div[2]/a")
    WebElement btnDone;
    @FindBy(xpath = "/html/body/main/div[1]/div[2]/div/div/div/div[1]/a/div/div/p")
    WebElement validasiFront;



//method
    public void pilihMenu(){
        navbar.click();
    }
    public void menuMonitoring(){
        submenuMon.click();
    }
    public String validasiMonitoringHalaman(){
        return validasiMonitoring.getText();
    }
    public void klikMonSet(){
        btnmonSet.click();
    }
    public String setvalidasiMonSet(){
        return validasiMonSet.getText();
    }
    public void setRegional(){
        regional.click();
        inputTxt.clear();
        inputTxt.sendKeys("Jakarta 2");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
    }
    public void setSupervisi(){
        supervisi.click();
        inputTxt.clear();
        inputTxt.sendKeys("KC Cibinong");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
    }
    public void setCctvID(){
        cctvID.click();
        inputTxt.clear();
        inputTxt.sendKeys("Bhall_Cikaret");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
    }
    public String setValidasiFilter(){
        return validasiFilter.getText();
    }
    public void actionCheckbox(){
        checkBox.click();
    }
    public String setvalidasiCheckbox(){
        return validasiCheckbox.getText();
    }
    public String setValidasiError(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        DriverSingleton.delay(1);
        return validasiError.getText();
    }
    public void setAndResetRegional(){
        removeRegional.click();
        inputTxt.clear();
        inputTxt.sendKeys("Jakarta 2");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public void checkExists(String eksis){
        if (eksis.equals(listexists.getText())){
            System.out.println("list ada");
        }
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    public void setBtnDone(){
        Actions actions = new Actions(driver);
        actions.moveToElement(btnDone).click().perform();
    }
    public String setValidasiFront(){
        return validasiFront.getText();
    }

}
