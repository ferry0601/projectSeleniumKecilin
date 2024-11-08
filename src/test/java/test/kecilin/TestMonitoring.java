package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import test.kecilin.drivers.DriverSingleton;
import test.kecilin.pages.LoginPage;
import test.kecilin.pages.MonitoringPage;

import java.util.List;

public class TestMonitoring {
    static WebDriver driver;
    static ExtentTest extentTest;
    static MonitoringPage monitoringPage = new MonitoringPage();

    public TestMonitoring() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    @And("Klik sub menu monitoring")
    public void klik_submenu_monitoring(){
        monitoringPage.menuMonitoring();
        extentTest.log(LogStatus.PASS,"klik submenu monitoring");
    }
    @Then("validasi halaman moni")
    public void validasi_halaman_moni(){
        DriverSingleton.delay(1);
        Assert.assertEquals(monitoringPage.validasiMonitoringHalaman(),"Monitoring");
        extentTest.log(LogStatus.PASS,"validasi halaman moni");
    }

    @When("klik tombol monitoring setting")
    public void klik_tombol_monitoring_setting() {
        monitoringPage.klikMonSet();
        extentTest.log(LogStatus.PASS,"klik tombol monitoring setting");
    }
    @Then("validasi monitoring setting")
    public void validasi_monitoring_setting() {
        DriverSingleton.delay(1);
        Assert.assertEquals(monitoringPage.setvalidasiMonSet(),"Monitoring Setting");
        extentTest.log(LogStatus.PASS,"validasi monitoring setting");
    }


    @When("Pilih regional")
    public void pilih_regional() {
        monitoringPage.setRegional();
        extentTest.log(LogStatus.PASS,"pilih regional");
    }
    @And("Pilih supervisi")
    public void pilih_supervisi() {
        monitoringPage.setSupervisi();
        extentTest.log(LogStatus.PASS,"Pilih supervisi");
    }
    @And("Pilih CCTV ID")
    public void pilih_cctv_id() {
        monitoringPage.setCctvID();
        extentTest.log(LogStatus.PASS,"Pilih CCTV ID");
    }
    @Then("Validasi filter")
    public void validasi_filter() {
        Assert.assertEquals(monitoringPage.setValidasiFilter(),"Bhall_Cikaret");
        extentTest.log(LogStatus.PASS,"validasi filter");
    }


    @When("Klik action tabel")
    public void klik_action_tabel() {
        monitoringPage.actionCheckbox();
        extentTest.log(LogStatus.PASS,"klik action tabel");
    }
    @Then("validasi tampil di list")
    public void validasi_tampil_di_list() {
        Assert.assertEquals(monitoringPage.setvalidasiCheckbox(),"CCTV update show monitoring");
        extentTest.log(LogStatus.PASS,"validasi tampil list");
        Actions actions = new Actions(driver);
    }

    @When("Klik action tabel lebih sembilan")
    public void klik_action_tabel_lebih_sembilan() {
        monitoringPage.setAndResetRegional();
        DriverSingleton.delay(1);
        Actions actions = new Actions(driver);
        DriverSingleton.delay(1);
        List<WebElement> checkboxes = driver.findElements(By.name("A"));
        for (int i = 0; i < 5 && i < checkboxes.size(); i++){
            WebElement checkbox = checkboxes.get(i);
            if (!checkbox.isSelected()){
                checkbox.click();
            } else if(checkbox.isSelected()){
                break;
            }
        }
        extentTest.log(LogStatus.PASS,"klik action tabel lebih dari sembilan");
        DriverSingleton.delay(2);
    }
    @Then("validasi maximum list")
    public void validasi_maximum_list() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform();
        DriverSingleton.delay(1);
        Assert.assertEquals(monitoringPage.setValidasiError(),"A maximum of 9 cameras can be displayed");
        extentTest.log(LogStatus.PASS,"validasi maximum");

    }


    @When("pastikan ada cctv list")
    public void pastikan_ada_cctv_list() {
        monitoringPage.checkExists("Hall_Ps_Baru");
        extentTest.log(LogStatus.PASS,"check list");
        Actions actions = new Actions(driver);
        DriverSingleton.delay(1);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 350);");
    }
    @And("klik tombol done")
    public void klik_tombol_done() {
        DriverSingleton.delay(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        monitoringPage.setBtnDone();
        extentTest.log(LogStatus.PASS,"klik tombol done");
    }
    @Then("validasi tampil cctv")
    public void validasi_tampil_cctv() {
        Assert.assertEquals(monitoringPage.setValidasiFront(),"Unit Kayuringin - Tel_Kringin");
        extentTest.log(LogStatus.PASS,"validasi tampil CCTV");
    }
}
