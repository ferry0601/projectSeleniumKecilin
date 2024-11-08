package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import test.kecilin.drivers.DriverSingleton;
import test.kecilin.pages.LoginPage;
import test.kecilin.pages.ReliabilityPage;

public class TestReliability {
    static WebDriver driver;
    static ExtentTest extentTest;
    static ReliabilityPage reliabilityPage = new ReliabilityPage();

    public TestReliability() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik menu")
    public void klik_menu() {
        reliabilityPage.klikNavbar();
        extentTest.log(LogStatus.PASS,"klik navbar");
    }
    @And("Klik sub menu")
    public void klik_sub_menu() {
        reliabilityPage.setSubmenuRealibility();
        extentTest.log(LogStatus.PASS,"submenu");
    }
    @Then("validasi halaman reli")
    public void validasi_halaman_reli() {
        DriverSingleton.delay(2);
        Assert.assertEquals(reliabilityPage.getvalidasiHalaman(),"Reliability Percentage");
        extentTest.log(LogStatus.PASS,"validasi halaman reliability");
    }

    @When("Pilih filter {string}")
    public void pilih_filter(String option) {
        reliabilityPage.filter(option);
        extentTest.log(LogStatus.PASS,"pilih filter");
    }
    @And("Input start date")
    public void input_start_date() {
        reliabilityPage.setStartdate();
        extentTest.log(LogStatus.PASS,"start date");
    }
    @And("Input end date")
    public void input_end_date() {
        reliabilityPage.setEnddate();
        extentTest.log(LogStatus.PASS,"end date");
    }
    @And("Input regional")
    public void input_regional() {
        reliabilityPage.setRegional();
        extentTest.log(LogStatus.PASS,"regional");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    @And("Input KC supervisi")
    public void input_kc_supervisi() {
        reliabilityPage.setKcSupervisi();
        extentTest.log(LogStatus.PASS,"supervisi");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    @And("Klik tombol search")
    public void klik_tombol_search() {
        reliabilityPage.setBtnSearch();
        extentTest.log(LogStatus.PASS,"tombol search");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
    @Then("validasi percentage {string}")
    public void validasi_percentage(String validasi) {
        DriverSingleton.delay(2);
        if (validasi.equals("0%")){
            Assert.assertEquals(reliabilityPage.setValidasiNol(),"0.00 %");
        } else if (validasi.equals("98%")){
            Assert.assertEquals(reliabilityPage.setvalidasisembilanDelapan(),"No data available in table");
        } else if (validasi.equals("100%")){
            Assert.assertEquals(reliabilityPage.setValidasiNol(),"0.00 %");
        } else if (validasi.equals("max")) {
            Assert.assertEquals(reliabilityPage.setValidasiNol(),"0.00 %");
        }

        extentTest.log(LogStatus.PASS,"validasi percentage");
        DriverSingleton.delay(2);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    @When("Input KC supervisi jakarta3")
    public void input_kc_supervisi_jakarta3() {
        reliabilityPage.setSupervisilain();
        extentTest.log(LogStatus.PASS,"supervisi");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    @And("Input regional jakarta3")
    public void Input_regional_jakarta3(){
        reliabilityPage.setRegional();
        extentTest.log(LogStatus.PASS,"regional");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }
}
