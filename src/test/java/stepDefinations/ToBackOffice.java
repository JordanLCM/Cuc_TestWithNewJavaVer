package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utility.Base;

public class ToBackOffice {

	Base base;

	public ToBackOffice(Base base) {
		this.base = base;
	}
	
	@Given("user opens {string}")
	public void user_opens(String url) {
		base.getDriver().get(url);
	}

	@And("user checks that site opened is {string}")
	public void user_checks_that_site_opened_is(String url) {
		String urlLink = base.getDriver().getCurrentUrl();
		if (!urlLink.equals(url)) {
			Assert.assertTrue("Failed! Link is not = " + urlLink, false);
		} else {
			System.out.println("Passed! Link shows = " + urlLink);
		}
	}
}
