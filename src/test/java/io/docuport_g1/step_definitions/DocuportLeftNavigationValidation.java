package io.docuport_g1.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.docuport_g1.pages.LoginPage;

import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DocuportConstants;
import io.docuport_g1.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DocuportLeftNavigationValidation {
    LoginPage home = new LoginPage();


    @Given("User login as {string}")
    public void user_login_as(String role) throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuporLoginPageUrl"));

        switch (role) {
            case "Advisor":
                home.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                home.passwordInput.sendKeys(DocuportConstants.PASSWORD);
                home.loginButton.click();
                break;
            case "Supervisor":
                home.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                home.passwordInput.sendKeys(DocuportConstants.PASSWORD);
                home.loginButton.click();
                break;
            case "Employee":
                home.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                home.passwordInput.sendKeys(DocuportConstants.PASSWORD);
                home.loginButton.click();
                break;
            case "Client":
                home.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
                home.passwordInput.sendKeys(DocuportConstants.PASSWORD);

                home.loginButton.click();
                Thread.sleep(5000);

                home.continueButton.click();

        }
    }

    @Then("validate {string}")
    public void validate(String items) {
        try {
            List<String> expectedItems = Arrays.asList(items.split(","));
            for (int i = 0; i < expectedItems.size(); i++) {
                String expectedSubItems = expectedItems.get(i).trim();
                WebElement menuItem = Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedSubItems + "']"));
                Assert.assertEquals(expectedSubItems, menuItem.getText());
            }
        } catch (StaleElementReferenceException e) {
            List<String> expectedItems = Arrays.asList(items.split(","));
            for (int i = 0; i < expectedItems.size(); i++) {
                String expectedSubItems = expectedItems.get(i).trim();
                WebElement menuItem = Driver.getDriver().findElement(By.xpath("//*[text()='" + expectedSubItems + "']"));
                Assert.assertEquals(expectedSubItems, menuItem.getText());
            }
        }
    }

}
