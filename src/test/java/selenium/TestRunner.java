package selenium;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/Login.feature", "src/test/resources/Features/AddAgenda.feature"
		 }, glue = { "selenium" }, monochrome = true, plugin = { "pretty",
				"junit:target/JUnitReports/report.xml", "json:target/JSONReports/report.json",
				"html:target/HtmlReports" })
public class TestRunner {

}
