package io.docuport_g1.pages;
import io.docuport_g1.utilities.BrowserUtils;
import io.docuport_g1.utilities.DocuportConstants;
import io.docuport_g1.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    /**
     *logins to docuport application
     * @param driver, which is initialized in the test base
     * @param role, comes from docuport constants
     * author nsh
     */


public void enterCredentials(String role) {
    if (role == null || role.isEmpty()) {
        throw new IllegalArgumentException("Role cannot be null or empty");
    }
    String username;
    switch (role.toLowerCase().trim()) {
        case "client":
            username = DocuportConstants.USERNAME_CLIENT;
            break;
        case "supervisor":
            username = DocuportConstants.USERNAME_SUPERVISOR;
            break;
        case "advisor":
            username = DocuportConstants.USERNAME_ADVISOR;
            break;
        case "employee":
            username = DocuportConstants.USERNAME_EMPLOYEE;
            break;
        default:
            throw new IllegalArgumentException("Invalid role: " + role);
    }
    // Clear the field before entering credentials
//        usernameInput.clear();
//        passwordInput.clear();
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(DocuportConstants.PASSWORD);
}
// Method for clicking button
public void clickButton(String button) {
    if (button == null || button.isEmpty()) {
        throw new IllegalArgumentException("Button name cannot be null or empty");
    }
    switch (button.toLowerCase().trim()) {
        case "login":
            BrowserUtils.waitForClickable(loginButton, 5);
            loginButton.click();
            break;
        case "continue":
            BrowserUtils.waitForVisibility(continueButton, 5);
            continueButton.click();
            break;
        default:
            throw new IllegalArgumentException("Unknown button: " + button);
    }
}
// full login process
public void login(String role) {
    enterCredentials(role);
    clickButton("login");
    // If it is a client needs to click  "Continue"
    if (role.equalsIgnoreCase("client")) {
        BrowserUtils.waitForVisibility(continueButton, 5);
        clickButton("continue");
    }
}
}
