package test.kecilin;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/main/resources/features/",
//                "src/main/resources/features/01Login.feature",
//                "src/main/resources/features/02ShowCamera.feature",
//                "src/main/resources/features/03Dashboard.feature",
//                "src/main/resources/features/04Reliability.feature",
//                "src/main/resources/features/05Monitoring.feature",
//                "src/main/resources/features/06Logout.feature",
        },
        glue = "test.kecilin",
        plugin = {"pretty", "html:target/cucumber-report.html","json:target/cucumber.json"}
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
