package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.kecilin.drivers.DriverSingleton;
import test.kecilin.pages.LoginPage;

public class TestLogin {
    static WebDriver driver;
    static ExtentTest extentTest;
    static LoginPage loginPage = new LoginPage();

    public TestLogin() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User access the url {string}")
    public void User_access_the_url(String url){
        driver.get(url);
        extentTest.log(LogStatus.PASS,"User access the url");
    }

    @When("Klik forgot password")
    public void Klik_forgot_password(){
        loginPage.setClickforgotPass();
        extentTest.log(LogStatus.PASS,"Klik forgot password");
    }

    @And("Input email")
    public void Input_email(){
        loginPage.inputEmail("admindoangkecilin@yopmail.com");
        extentTest.log(LogStatus.PASS,"Input email");
    }

    @And("Klik reset email")
    public void Klik_reset_email(){
        loginPage.setSubmitforgotPass();
        extentTest.log(LogStatus.PASS,"Klik reset email");
    }

    @Then("validation reset")
    public void validation_reset(){
        Assert.assertEquals(loginPage.setValidasiForgotPass(),"We have sent a link to change your password via email, please check your email inbox!");
        extentTest.log(LogStatus.PASS,"validation reset");
    }

    @When("Input email {string}")
    public void Input_email(String email){
        loginPage.inputEmail(email);
        extentTest.log(LogStatus.PASS,"User input email");
    }

    @And("Input password {string}")
    public void Input_password(String passwoord){
        loginPage.inputPassword(passwoord);
        extentTest.log(LogStatus.PASS,"User input password");
    }

    @And("Klik remember me")
    public void Klik_remember_me(){
        loginPage.clickRememberme();
        extentTest.log(LogStatus.PASS,"Klik remember me");
    }

    @And("Klik show password")
    public void Klik_show_password(){
        loginPage.clickShow();
        extentTest.log(LogStatus.PASS,"Klik show password");
    }

    @And("Klik tombol login")
    public void Klik_tombol_login(){
        loginPage.clickLogin();
        extentTest.log(LogStatus.PASS,"Klik tombol login");
    }

    @Then("User see text validation {string} {string}")
    public void User_see_text_validation(String result, String type){
        DriverSingleton.delay(2);
        if (type.contains("Semua kosong")) {
            Assert.assertTrue(loginPage.getTxtFillOut("email").contains(result));
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }
        else if (type.contains("Email kosong")) {
            Assert.assertTrue(loginPage.getTxtFillOut("email").contains(result));
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }
        else if (type.contains("Password")) {
            Assert.assertTrue(loginPage.getTxtFillOut("password").contains(result));
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }
        else if (type.contains("These credentials do not match our records.")) {
            Assert.assertTrue(loginPage.getTxtInvalidLogin().contains(result));
            extentTest.log(LogStatus.PASS, "User should see text for validation in email field");
        }
        else if (type.contains("Dashboard")) {
            Assert.assertTrue(loginPage.getTxtValidLogin().contains(result));
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }

    }
}
