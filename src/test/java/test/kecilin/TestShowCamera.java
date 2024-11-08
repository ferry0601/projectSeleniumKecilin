package test.kecilin;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import test.kecilin.drivers.DriverSingleton;
import test.kecilin.pages.LoginPage;
import test.kecilin.pages.ShowCameraPage;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class TestShowCamera {
    static WebDriver driver;
    static ExtentTest extentTest;
    static ShowCameraPage showCameraPage = new ShowCameraPage();

    public TestShowCamera() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik Total CCTV")
    public void Klik_Total_CCTV(){
        showCameraPage.klikCCTV();
        extentTest.log(LogStatus.PASS,"Klik Total CCTV");
    }
    @Then("Get validation")
    public void Get_validation(){
        Assert.assertEquals(showCameraPage.getTitlecctv(),"CCTV Banking Hall");
        System.out.println(showCameraPage.getTitlecctv());
//        showCameraPage.scrollDown();
//        DriverSingleton.delay(0.5);
//        Assert.assertEquals(showCameraPage.getTxtTotalCCTV(),"Showing 1 to 10 of 120 entries");


        extentTest.log(LogStatus.PASS,"Get validation");
    }

    @When("Klik regional office")
    public void Klik_regional_office(){
        showCameraPage.klikRegionalOffice();
        extentTest.log(LogStatus.PASS,"Klik regional office");
    }

    @And("Input option")
    public void Input_option(){
        showCameraPage.inputRegionalOffice();
        extentTest.log(LogStatus.PASS,"Input option");
    }

    @Then("Validasi regional")
    public void validasi_regional(){
        Assert.assertEquals(showCameraPage.notFound(),"No results found");
        extentTest.log(LogStatus.PASS,"Validasi regional");
    }

    @And("Select option dari list Regional Office")
    public void Select_option_dari_list_Regional_Office(){
        showCameraPage.klikregional();
        extentTest.log(LogStatus.PASS,"Select option {string} dari list Regional Office");
    }
//    @And("Result {string} harus tampil")
//    public void Result_option_harus_tampil_di_field(String expectoption){
//        WebElement dropdownElement = driver.findElement(By.id("select2-regional-results"));
//        Select dropdown = new Select(dropdownElement);
//        WebElement selectOption = dropdown.getFirstSelectedOption();
//        Assert.assertEquals(expectoption,selectOption.getText());
//        extentTest.log(LogStatus.PASS,"Result option harus tampil");
//    }
    @Then("Validation result")
    public void Validation_result(){
        DriverSingleton.delay(1);
        showCameraPage.scrollDown();
        Assert.assertEquals(showCameraPage.getAssert(),"Yogyakarta Test");
        extentTest.log(LogStatus.PASS,"Validation result");
    }

    @When("Klik tombol export")
    public void setExportTest(){
        showCameraPage.Export();
        extentTest.log(LogStatus.PASS,"Klik tombol export");
    }

//    @Then("Validasi download")
//    public void validasi_download(){
//        try {
//            String downloadDir = System.getProperty("user.dir") + "/downloads";
//            File downloadedFile = new File(downloadDir + "/Data CCTV.Xlsx");
//            boolean fileExists = downloadedFile.exists();
//
//            Assert.assertEquals(fileExists, "File tidak ditemukan di direktori unduhan");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    @And("Show CCTV")
    public void show_CCTV(){
        showCameraPage.setShowCCTV();
        extentTest.log(LogStatus.PASS,"show CCTV");
    }

    @Then("Validasi show CCTV")
    public void Validasi_show_CCTV(){
        String parent = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles){
            if(!handle.equals(parent)){
                driver.switchTo().window(handle);
                Assert.assertEquals(showCameraPage.setTxtCCTV(),"Stream CCTV");
                DriverSingleton.delay(5);
                showCameraPage.setBackDashboard();
                DriverSingleton.delay(1);
            }
        }
        extentTest.log(LogStatus.PASS,"Validasi show CCTV");
    }
}
