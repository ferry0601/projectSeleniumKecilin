package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test.kecilin.pages.LogoutPage;
import test.kecilin.pages.MonitoringPage;

public class TesLogout {
    static WebDriver driver;
    static ExtentTest extentTest;
    static LogoutPage logoutPage = new LogoutPage();

    public TesLogout() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("klik tombol logout")
    public void klik_tombol_logout() {
        logoutPage.setBtnLogout();
        extentTest.log(LogStatus.PASS,"klik tombol logout");
    }
    @And("validasi logout")
    public void validasi_logout() {
        Assert.assertEquals(logoutPage.validasiLogout(),"LOG IN");
        extentTest.log(LogStatus.PASS,"validasi Logout");
    }
}
