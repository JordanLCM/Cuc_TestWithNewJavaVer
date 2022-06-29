package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	SystemInfo system;
	Base base;
	Scenario scenario;
	
	public Hooks(Base base) {
		this.base = base;
	}

	@Before(order = 1)
	public void setUp() {
		base.setDriver();
	}

	@Before(order = 0)
	public void beforeScenarioStart() {
		System.out.println("-----------------Start of Scenario" + scenario +"-----------------");
	}

	@After(order = 0)
	public void afterScenarioFinish() {
		System.out.println("-----------------End of Scenario-----------------");
	}

	@After(order = 1)
	public void tearDown() throws InterruptedException {
		Thread.sleep(1500);
		base.getDriver().quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) base.getDriver();
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.log("Scenario -> " + scenario.getStatus());
			scenario.attach(screenshot, "image/png", "Result");
		}
	}
	
	@Before(value = "@OpenSite")
	public void setSystemInfo() {
		system = new SystemInfo();
		system.setSystemInfo();
	}
}
