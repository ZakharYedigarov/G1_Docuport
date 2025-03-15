package io.docuport_g1.step_definitions;


import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;


import io.docuport_g1.pages.LoginPage;
import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.ConfigurationReader;
import io.docuport_g1.utilities.DocuportConstants;
import io.docuport_g1.utilities.Driver;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginStepDefs {
    private static final Logger LOG = LogManager.getLogger(LoginStepDefs.class);
    LoginPage loginPage = new LoginPage();
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuporLoginPageUrl"));  // Укажи актуальный URL
        LOG.info("User navigates to Docuport login page");
    }
//    @When("user logs in as {string}")
//    public void user_logs_in_as_role(String role) {
//        BrowserUtils.waitForVisibility(loginPage.usernameInput,10);
//        loginPage.login(role);
//        loginPage.clickButton("login");
//        LOG.info("User logs in as " + role);
//    }

    @When("user unters credential as a {string}")
    public void user_unters_credential_as_a(String role) {
        BrowserUtils.waitForVisibility(loginPage.usernameInput,10);
        LOG.info("User logs in as " + role);
        loginPage.login(role);
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
       loginPage.loginButton.click();
    }


//    @Then("user should be able to see the home page for {string}")
//    public void user_should_see_home_page_for_role(String role) {
//       assertTrue(BrowserUtils.waitForVisibility(loginPage.continueButton, 10).isDisplayed(),
//               "Home page is not displayed");
//        LOG.info("Home page is successfully displayed for " + role);
//    }

    @Then("user should be able to see the home for {string}")
    public void user_should_be_able_to_see_the_home_for(String string) {
// here must be some code, I have not created
        System.out.println("User logged in on the home page");
    }
}
