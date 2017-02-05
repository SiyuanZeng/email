package com.epam.preprod.firefox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oksana_Nytrebych on 5/24/2016.
 */
public class LoginPage extends BasePage {
    @FindBy(id = "Email")
    private WebElement email;

    @FindBy(id = "Passwd")
    private WebElement password;

//    @FindBy(xpath = "html/body/div/form/div/div//section/div/div/div/div/div/div[2]/div/div/div[3]/div/div/div/div")
    @FindBy(id = "i0118")
    private WebElement passwords;

    @FindBy(id = "ap_password")
    private WebElement passwosrds;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "signIn")
    private WebElement signInButton;
//    @FindBy(xpath = "html/body/div/form/div/div//section/div/div/div/div/div/div[2]/div/div/div[5]/div/div/div[2]/input")
    @FindBy(id = "idSIButton9")
    private WebElement signInButtons;

    @FindBy(id = "signInSubmit-input")
    private WebElement sddignInButtons;

    @FindBy(xpath = "html/body/div/div[2]/div[2]/div[1]")
    private WebElement cardPassword;

//    @FindBy(xpath = "//html/body/div/form/div/div/section/div/div/div/div/div/div[2]/div/div/div[3]/div/div/div[2]/div")
//    @FindBy(how = How.CLASS_NAME, using = "has-focus placeholder")
//    @FindBy(css = "div[class='has-focus placeholder']")
//    @FindBy(xpath = "//*[class='has-focus placeholder']")
    @FindBy(id = "i0116")
    private WebElement cardPasswords;

    @FindBy(id = "ap_email")
    private WebElement cardPasswordsss;

//    @FindBy(xpath = "html/body/div/form/div/div/section/div/div/div/div/div/div[2]/div/div/div[3]/div[2]/div")
    @FindBy(id = "idSIButton9")
    private WebElement cardPasswordss;

    @FindBy(id = "ap_signin_existing_radio")
    private WebElement scardPasswordss;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.init(webDriver);
    }

    public LoginPage emailInput(String email) {
        this.email.clear();
        this.email.sendKeys(email);
        nextButton.click();
        return this;
    }

    public LoginPage emailsInput(String email) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cardPasswords.clear();
        this.cardPasswords.sendKeys(email);
        cardPasswordss.click();
        return this;
    }

    public LoginPage semailsInput(String email) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cardPasswordsss.clear();
        this.cardPasswordsss.sendKeys(email);
        scardPasswordss.click();
        return this;
    }

    public InboxPage passwordInput(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
        return new InboxPage(webDriver);
    }

    public InboxPage passwordInputs(String password) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.passwords.clear();
        this.passwords.sendKeys(password);
        signInButtons.click();
        return new InboxPage(webDriver);
    }

    public InboxPage spasswordInputs(String password) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.passwosrds.clear();
        this.passwosrds.sendKeys(password);
        sddignInButtons.click();
        return new InboxPage(webDriver);
    }

}
