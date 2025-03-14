package io.docuport_g1.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.docuport_g1.pages.HomePage;
import io.docuport_g1.pages.LoginPage;
import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DocuportConstants;
import io.docuport_g1.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    public static final Logger LOG = LogManager.getLogger();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuportUiUrl"));
        BrowserUtils.takeScreenshot();
        LOG.info("user is on docuport login page");
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        assertTrue("Login button is NOT displayed", loginPage.loginButton.isDisplayed());
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters username");
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters password");
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
        BrowserUtils.takeScreenshot();
        LOG.info("user clicks login button");
    }

    @Then("user should be able to see the home for client")
    public void user_should_be_able_to_see_the_home_for_client() {
        //BrowserUtils.takeScreenshot();
        assertTrue(BrowserUtils.waitForVisibility(homePage.receivedDocs, 10). isDisplayed());
        LOG.info("Home page is successfully loaded");
        //assertTrue(loginPage.continueButton.isDisplayed());
    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {

    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {

    }
    @Then("user should be able to see the home for employee")
    public void user_should_be_able_to_see_the_home_for_employee() {

    }

    @When("user enters username and password for advisor")
    public void user_enters_username_for_advisor() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.EXTRA_LARGE);
        assertTrue("Login button is NOT displayed", loginPage.loginButton.isDisplayed());
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters advisor username");
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
        BrowserUtils.takeScreenshot();
        LOG.info("user enters password for advisor");
    }

    @Then("user should be able to see the home for advisor")
    public void user_should_be_able_to_see_the_home_for_advisor() {

    }

    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {

    }
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {

    }
    @Then("user should be able to see the home for supervisor")
    public void user_should_be_able_to_see_the_home_for_supervisor() {

    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String > credentials) {
//        for (Map.Entry<String, String> entry : credentials.entrySet()) {
//            String key = entry.getKey();
//            System.out.println("key = " + key);
//
//            String value = entry.getValue();
//            System.out.println("value = " + value);
//
//            System.out.println("==========================");
//        }

        loginPage.login2(credentials.get("username"), credentials.get("password"));

    }
}

