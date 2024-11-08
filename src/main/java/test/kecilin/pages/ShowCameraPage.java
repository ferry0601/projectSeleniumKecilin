package test.kecilin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.kecilin.drivers.DriverSingleton;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ShowCameraPage {
    private WebDriver driver;

    public ShowCameraPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

//locator
    @FindBy(xpath = "/html/body/main/div[1]/div[1]/div[1]/a/div")
    WebElement TotalCCTV;
    @FindBy(xpath = "/html/body/main/div[1]/div[5]/div[1]/h5[1]")
    WebElement getTitle;
    @FindBy(xpath = "//*[@id=\"data_table_info\"]")
    WebElement getTotalCCTV;
    @FindBy(xpath = "//select[@id='regional']//following-sibling::span/span[1]/span[1]")
    WebElement fieldRegionalOffice;
    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement inputRegional;
    @FindBy(xpath = "//*[@id=\"select2-regional-results\"]/li")
    WebElement nofound;
    @FindBy(xpath = "//*[@id=\"iconNavbarSidenav\"]")
    WebElement menu;
    @FindBy(xpath = "//*[@id=\"sidenav-collapse-main\"]/ul/li[1]/a")
    WebElement submenusidebar;
    @FindBy(xpath = "//*[@id=\"submenu-dashboard\"]/li[1]/a")
    WebElement menuDashboard;

//    List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']"));
    @FindBy(xpath = "//*[@id=\"select2-regional-container\"]")
    WebElement resultField;
    @FindBy(xpath = "//*[@id=\"data_table\"]/tbody/tr/td[2]")
    WebElement listtabel;
    @FindBy(xpath = "//*[@id=\"select2-regional-results\"]/li[15]")
    WebElement yogyakarta;
    @FindBy(xpath = "/html/body/main/div[1]/div[5]/div[2]/div/div/div[1]/button")
    WebElement buttonExport;
    @FindBy(xpath = "//*[@id=\"data_table\"]/tbody/tr/td[8]/a")
    WebElement showCCTV;
    @FindBy(xpath = "//*[@id=\"navbarBlur\"]/div/nav/h6")
    WebElement txtCCTV;


//method
    public void klikCCTV(){
        TotalCCTV.click();
    }
    public void scrollDown(){
        System.out.println("test click");
        fieldRegionalOffice.sendKeys(Keys.PAGE_DOWN);
    }
    public String getTitlecctv(){return getTitle.getText();}
    public String getTxtTotalCCTV(){return getTotalCCTV.getText();}

    public void inputRegionalOffice(){

        inputRegional.sendKeys("ferrtest");
        DriverSingleton.delay(3);
    }

    public void setBackDashboard(){
        menu.click();
        submenusidebar.click();
        menuDashboard.click();
        DriverSingleton.delay(1);
    }

    public void klikRegionalOffice(){fieldRegionalOffice.click();}
    public String notFound(){return nofound.getText();}
    public void FilterRegionalOffice(String txtOption){
//        for (WebElement option: options){
//            if (option.getText().equals(txtOption)){
//                option.click();
//                break;
//            }
//        }
    }
    public void klikregional(){
        fieldRegionalOffice.click();
        fieldRegionalOffice.click();
        yogyakarta.click();}
    public String getFieldRegional(){return resultField.getText();}
    public String getAssert(){return listtabel.getText();}
    public void Export(){
        buttonExport.click();
    }
    public void setShowCCTV(){
        showCCTV.click();
    }
    public String setTxtCCTV(){
        return txtCCTV.getText();

    }

}
