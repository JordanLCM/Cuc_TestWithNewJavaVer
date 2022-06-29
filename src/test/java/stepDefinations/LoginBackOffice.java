package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesData.BackOfficeLoginPage;
import utility.Base;

public class LoginBackOffice {
	static String userID = "jordan";
	Base base;
	BackOfficeLoginPage loginData;

	public LoginBackOffice(Base base) {
		this.base = base;
	}

	@When("user opens site {string}")
	public void user_opens_site(String url) throws InterruptedException {
		base.getDriver().get(url);
		Thread.sleep(1500);
	}

	@Given("user inputs username1 {string}")
	public void user_inputs_username1(String username) {
		loginData = new BackOfficeLoginPage(base);
		loginData.usernameField(username);
	}

	@And("user inputs password1 {string}")
	public void user_inputs_password1(String password) {
		loginData = new BackOfficeLoginPage(base);
		loginData.passwordField(password);
	}

	@And("user inputs QR code {string}")
	public void user_inputs_qr_code(String QR) {
		loginData = new BackOfficeLoginPage(base);
		loginData.otpField(QR);
	}

	@Then("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginData = new BackOfficeLoginPage(base);
		loginData.loginButton(userID);
	}
}
