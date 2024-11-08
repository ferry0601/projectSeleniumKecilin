package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.kecilin.drivers.DriverSingleton;
import test.kecilin.pages.DashboardPage;

public class TestDashboard {

    static WebDriver driver;
    static ExtentTest extentTest;
    static DashboardPage dashboardPage = new DashboardPage();

    public TestDashboard(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

//    @When("Klik dan pilih type")
//    public void klik_dan_pilih() {
//        dashboardPage.scrollDown();
//        WebElement dropdown = driver.findElement(By.id("filter_ai"));
//        Select select = new Select(dropdown);
//        select.selectByVisibleText(type);
//        System.out.println(type);
//        dashboardPage.setBackDashboard();
//        dashboardPage.aiType("sla_frontliner");
//        extentTest.log(LogStatus.PASS,"Klik dan pilih type");
//    }
    @When("Atur tanggal")
    public void atur_tanggal() {
        dashboardPage.setTanggal();
        extentTest.log(LogStatus.PASS,"Atur tanggal");
    }
    @And("Pilih regionalnya")
    public void pilih_regional() {
        dashboardPage.regionalOfffice();
        extentTest.log(LogStatus.PASS,"Pilih Regional");
    }
    @And("Pilih supervisi {string}")
    public void pilih_supervisi(String supervisi) {
        dashboardPage.setSupervisi(supervisi);
        extentTest.log(LogStatus.PASS,"Pilih Supervisi");
    }
    @When("Klik tombol find result")
    public void klik_tombol_find_result() {
        dashboardPage.btnFind();
        extentTest.log(LogStatus.PASS,"Klik tombol find result");
    }
    @Then("Validasi tampil {string}")
    public void validasi_tampil(String result) {
        if (result.equals("1080")) {
            Assert.assertEquals(dashboardPage.getTxtResult(result),"1080");
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }else if (result.equals("Data is Empty...")) {
            Assert.assertEquals(dashboardPage.getTxtResult(result),"Data is Empty");
            extentTest.log(LogStatus.PASS, "User should see text for validation in dashboard page");
        }
    }
}
