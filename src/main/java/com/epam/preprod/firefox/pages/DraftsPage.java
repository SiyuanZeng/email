package com.epam.preprod.firefox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Oksana_Nytrebych on 5/25/2016.
 */
public class DraftsPage extends BasePage {

    @FindBy(xpath = ".//*[@class='F cf zt']/tbody")
    private WebElement lettersTable;

    @FindBy(xpath = ".//*[@class='F cf zt']/tbody/tr")
    private List<WebElement> letters;

    @FindBy(xpath = ".//*/div[@role='main']//*/tr[@class=\"zA yO\" and position()=1]")
    private WebElement letterToSend;

    @FindBy(xpath = "//div[text()='Send']")
    private WebElement sendButton;


    public DraftsPage(WebDriver webDriver) {
        super(webDriver);
        this.init(webDriver);
    }

    public boolean checkNewDraft(String message) {

        for (WebElement letter : letters) {
            if (letter.getText().contains(message)) {
                return true;

            }
        }
        return false;
    }

    public DraftsPage sendMail(String message) {
        letterToSend.click();
        sendButton.click();
        return this;
    }
}
