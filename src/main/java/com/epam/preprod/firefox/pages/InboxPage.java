package com.epam.preprod.firefox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oksana_Nytrebych on 5/24/2016.
 */
public class InboxPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement composeButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement to;

    @FindBy(xpath = "//input[@class='aoT']")
    private WebElement subject;

    @FindBy(xpath = "//td[@class='Ap']/div[2]/div[@class='Am Al editable LW-avf']")
    private WebElement message;

    @FindBy(xpath = "//img[@class='Ha']")
    private WebElement closeButton;

    public InboxPage(WebDriver webDriver) {
        super(webDriver);
        this.init(webDriver);
    }

    public InboxPage composeButtonClick() {
        composeButton.click();
        return this;
    }

    public void inputEmailFields(String to, String subject, String message) {


        this.to.sendKeys(to);
        this.subject.sendKeys(subject);
        this.message.sendKeys(message);
    }

    public InboxPage closeButtonClick() {
        closeButton.click();
        return this;
    }
}
