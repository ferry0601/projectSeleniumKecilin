package test.kecilin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.kecilin.drivers.DriverSingleton;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

//locator
    @FindBy(xpath = "/html/body/div/div[2]/form/div[3]/a")
    WebElement clickforgotPass;
    @FindBy(xpath = "/html/body/div/div[2]/form/div[2]/button")
    WebElement submitforgotPass;
    @FindBy(xpath = "/html/body/div/div/div/div/div/p")
    WebElement validasiforgotPass;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"remember_me\"]")
    WebElement rememberme;
    @FindBy(xpath = "//*[@id=\"btnToggle\"]/i")
    WebElement showPassword;
    @FindBy(xpath = "/html/body/div/div[2]/form/div[5]/button")
    WebElement login;
    @FindBy(xpath = "/html/body/div/div[2]/form/div[1]/ul/li")
    WebElement invalidLogin;
    @FindBy(xpath = "//*[@id=\"navbarBlur\"]/div/nav/h6")
    WebElement txtDashboard;


//method
    public void setClickforgotPass(){clickforgotPass.click();}
    public void setSubmitforgotPass(){submitforgotPass.click();}
    public String setValidasiForgotPass(){ return validasiforgotPass.getText();}
    public void inputEmail(String email){
        this.email.clear();
        this.email.sendKeys(email);
    }
    public void inputPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }
    public void clickRememberme(){rememberme.click();}
    public void clickShow(){showPassword.click();}
    public void clickLogin(){login.click();}
    public String getTxtFillOut(String txtField){
        String output = "";
        String required = null;
        this.email.clear();
        this.password.clear();
        if (txtField.equals("email")){
            required = email.getAttribute("required");
        } else if (txtField.equals("password")) {
            required = password.getAttribute("required");
        } if (required.equals("true")){
            output += "Please fill out this field";
        }
        System.out.println(output);
        return output;
    }
    public String getTxtInvalidLogin(){ return invalidLogin.getAttribute("required");}
    public String getTxtValidLogin(){ return txtDashboard.getAttribute("required");}
}
