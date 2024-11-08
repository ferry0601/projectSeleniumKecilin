package test.kecilin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import test.kecilin.drivers.DriverSingleton;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

//locator
//    WebElement dropdown = driver.findElement(By.id("filter_ai"));
    @FindBy(xpath = "//*[@id=\"start_date\"]")
    WebElement startDate;
    @FindBy(xpath = "//*[@id=\"end_date\"]")
    WebElement endDate;
    @FindBy(xpath = "//*[@id=\"select2-regional-container\"]")
    WebElement klikregional;
    @FindBy(xpath = "//*[@id=\"select2-branch-container\"]")
    WebElement kliksupervisi;
    @FindBy(xpath = "//input[@role='searchbox']")
    WebElement inputTxt;
    @FindBy(xpath = "//*[@id=\"btnFilter\"]")
    WebElement btnSearch;
    @FindBy(xpath = "//*[@id='chart_sla']")
    WebElement hasil;
    @FindBy(xpath = "//*[@id=\"navbarBlur\"]/div/nav/ol/li[1]/a")
    WebElement backDashboard;
    @FindBy(xpath = "//*[@id=\"loading_sla\"]/div/div/p")
    WebElement empty;
    @FindBy(xpath = "/html/body/main/div[1]/div[4]/div[1]/div/div/div/div[1]/div/p")
    WebElement target;



//method
//    public void aiType(String option){
//        dropdown.click();
//        Select select = new Select(dropdown);
//        select.selectByVisibleText(option);
//        System.out.println(option);
//    }

    public void setTanggal(){
        String startdate = "07-10-2024";
        String enddate = "07-11-2024";
        startDate.sendKeys(startdate);
        endDate.sendKeys(enddate);

    }

//    public void scrollDown(){
//        startDate.sendKeys(Keys.PAGE_DOWN);
//    }

    public void regionalOfffice(){
        Actions actions = new Actions(driver);
        actions.moveToElement(klikregional).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        klikregional.click();
        inputTxt.clear();
        inputTxt.sendKeys("Jakarta 2");
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
    }

    public void setSupervisi(String suvisi){
        kliksupervisi.click();
        inputTxt.clear();
        inputTxt.sendKeys(suvisi);
        DriverSingleton.delay(1);
        inputTxt.sendKeys(Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnSearch).perform();
    }

    public void btnFind(){
        btnSearch.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(target).perform();
        DriverSingleton.delay(2);
    }

    public String getTxtResult(String txtField){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        String heigh = null;
        if (txtField.equals("1080")){
            heigh = hasil.getAttribute("height");
            DriverSingleton.delay(1);
            actions.moveToElement(klikregional).perform();
        } if (txtField.equals("Data is Empty")){
            heigh = empty.getText();
            DriverSingleton.delay(1);
            actions.moveToElement(klikregional).perform();
        }
        System.out.println(heigh);
        return heigh;

    }



    public String resultEmpty(){return empty.getText();}
}
