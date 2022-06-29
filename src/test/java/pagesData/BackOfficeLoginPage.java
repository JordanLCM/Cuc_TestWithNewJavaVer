package pagesData;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Base;

public class BackOfficeLoginPage {

	Base base;

	public BackOfficeLoginPage(Base base) {
		this.base = base;
	}

	public void usernameField(String username) {
		WebElement usernameField = base.getDriver().findElement(By.name("username"));
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public void passwordField(String password) {
		WebElement passwordField = base.getDriver().findElement(By.name("password"));
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void otpField(String otp) {
		WebElement otpField = base.getDriver().findElement(By.name("totp"));
		otpField.clear();
		otpField.sendKeys(otp);
	}

	public void loginButton(String userID) {
		WebElement loginButton = base.getDriver().findElement(By.tagName("button"));
		loginButton.click();

		WebElement userIDVerify = base.getDriver().findElement(By.xpath("(//a[normalize-space()='" + userID + "'])[1]"));
		String userIDVerifyTxt = userIDVerify.getText();
		if (!userIDVerifyTxt.equals(userID)) {
			Assert.assertTrue("Failed! Account is not = " + userIDVerifyTxt, false);
		} else {
			System.out.println("Passed! Account is = " + userIDVerifyTxt);
		}
	}
}