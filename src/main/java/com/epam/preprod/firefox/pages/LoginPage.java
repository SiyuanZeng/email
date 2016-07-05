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

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(xpath = "html/body/div/div[2]/div[2]/div[1]")
    private WebElement cardPassword;


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

    public InboxPage passwordInput(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
        return new InboxPage(webDriver);
    }

}
