package test.kecilin.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.kecilin.drivers.DriverSingleton;

import javax.swing.*;

public class ReliabilityPage {
    private WebDriver driver;

    public ReliabilityPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

//locator
    @FindBy(xpath = "/html/body/main/div[1]/div[2]/div/div/div/h6")
    WebElement validasiHalaman;
    @FindBy(xpath = "//*[@id=\"iconNavbarSidenav\"]")
    WebElement navbar;
    @FindBy(xpath = "//*[@id=\"submenu-dashboard\"]/li[2]/a")
    WebElement submenuRealibility;
    @FindBy(xpath = "//*[@id=\"filter\"]/option[2]")
    WebElement nol;
    @FindBy(xpath = "//*[@id=\"start_date\"]")
    WebElement startdate;
    @FindBy(xpath = "//*[@id=\"start_date\"]")
    WebElement enddate;
    @FindBy(xpath = "//*[@id=\"select2-regional-container\"]")
    WebElement regional;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement inputTxt;
    @FindBy(xpath = "//*[@id=\"select2-branch-container\"]")
    WebElement kcSupervisi;
    @FindBy(xpath = "//*[@id=\"search_filter\"]")
    WebElement btnSearch;
    @FindBy(xpath = "//*[@id=\"data_table\"]/tbody/tr[1]/td[8]")
    WebElement validasiNol;
    @FindBy(xpath = "//*[@id=\"filter\"]/option[3]")
    WebElement sembilandelapan;
    @FindBy(xpath = "//table[@id='data_table']/tbody/tr/td")
    WebElement validasisembilandelapan;
    @FindBy(xpath = "//*[@id=\"filter\"]/option[4]")
    WebElement seratus;
    @FindBy(xpath = "//*[@id=\"filter\"]/option[5]")
    WebElement max;






//method
    public void klikNavbar(){
        Actions actions = new Actions(driver);
        actions.moveToElement(navbar).perform();
        navbar.click();
    }
    public void setSubmenuRealibility(){
        submenuRealibility.click();
    }
    public String getvalidasiHalaman(){
        return validasiHalaman.getText();
    }
    public void filter(String filterin){
        DriverSingleton.delay(2);
        if (filterin.equals("0%")){
            nol.click();
        } else if (filterin.equals("98%")){
            sembilandelapan.click();
        } else if (filterin.equals("100%")){
            seratus.click();
        } else if (filterin.equals("max")) {
            max.click();
        }

    }
    public void setStartdate(){
        startdate.sendKeys("07-10-2024");
    }
    public void setEnddate(){
        enddate.sendKeys("07-11-2024");
        enddate.sendKeys(Keys.PAGE_DOWN);
    }
    public void setRegional(){
        regional.click();
        inputTxt.clear();
        inputTxt.sendKeys("Jakarta 2");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public void setRegionalLain(){
        regional.click();
        inputTxt.clear();
        inputTxt.sendKeys("Jakarta 3");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public void setKcSupervisi(){
        kcSupervisi.click();
        inputTxt.clear();
        inputTxt.sendKeys("KC Bekasi");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public void setSupervisilain(){
        kcSupervisi.click();
        inputTxt.clear();
        inputTxt.sendKeys("KC Serang");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    public void setBtnSearch(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        DriverSingleton.delay(1);
        btnSearch.click();

            }
    public String setValidasiNol(){
        return validasiNol.getText();
    }
    public String setvalidasisembilanDelapan(){
        return validasisembilandelapan.getText();
    }
}
