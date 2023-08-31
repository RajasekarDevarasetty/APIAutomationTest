package TestRunner;

import Configuration.ConfigReader;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/FeatureFiles"
        ,glue = "StepDefinitions"
        ,tags = "@SmokeTest"
        ,plugin = {"pretty","json:target/cucumber.json","html:target/cucumbar-html-report"})
public class Runner extends ConfigReader {


    @BeforeClass
    public static void saveConfig()
    {
        new ConfigReader();
    }

    @AfterClass
    public static void generateReport() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");
        String projectName = "API Test";
        String buildNumber = "1.0";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("User", "Rajasekar");
        configuration.addClassifications("Branch", "master");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
