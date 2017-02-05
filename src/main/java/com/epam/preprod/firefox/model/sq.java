package com.epam.preprod.firefox.model;

import com.epam.preprod.firefox.pages.DraftsPage;
import com.epam.preprod.firefox.pages.InboxPage;
import com.epam.preprod.firefox.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oksana_Nytrebych on 5/24/2016.
 */
public class sq {


    static final Logger logger = LogManager.getLogger(sq.class);

    protected WebDriver firefoxDriver;
    private LoginPage loginPage;
    private String URL_LOGIN_PAGE = "http://www.gmail.com/";
    private String EMAIL = "zengb45@gmail.com";
    private String PASSWORD = "Guanli2016";
    private User user;

    private InboxPage inboxPage;
    private String URL_INBOX_PAGE = "https://mail.google.com/mail/#inbox";
    private String TO = "ksenija.volynj@gmail.com";
    private String SUBJECT = "subject";
    private String MESSAGE = "Hello my friend!";
    private Message message;

    private DraftsPage draftsPage;
    private String URL_DRAFTS_PAGE = "https://mail.google.com/mail/u/0/#drafts";


    @BeforeClass
    public void beforeLoginPageTest() {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(URL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(EMAIL, PASSWORD);
        message = new Message(TO, SUBJECT, MESSAGE);
    }

    @Test
    public void testOpenLogin() {
        System.setProperty("webdriver.gecko.driver","C:\\email\\geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(URL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(EMAIL, PASSWORD);
        message = new Message(TO, SUBJECT, MESSAGE);
        loginPage = loginPage.emailInput(user.getLogin());
        inboxPage = loginPage.passwordInput(user.getPassword());
        firefoxDriver.get(URL_INBOX_PAGE);
        Assert.assertEquals(URL_INBOX_PAGE, firefoxDriver.getCurrentUrl());
        logger.info("testOpenLogin pass");
    }

    @Test(dependsOnMethods = {"testOpenLogin"})
    public void testNewMessage() {
        inboxPage.composeButtonClick();
        inboxPage.inputEmailFields(message.getTo(), message.getSubject(), message.getBody());
        inboxPage.closeButtonClick();
        logger.info("testNewMessage pass");
    }

    @Test(dependsOnMethods = {"testNewMessage"})
    public void testCheckDrafts() {
        firefoxDriver.get(URL_DRAFTS_PAGE);
        firefoxDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        draftsPage = new DraftsPage(firefoxDriver);
        Assert.assertTrue(draftsPage.checkNewDraft(message.getBody()));
        logger.info("testCheckDrafts pass");
    }

    @Test(dependsOnMethods = {"testCheckDrafts"})
    public void testSendMessage() {
        draftsPage = draftsPage.sendMail(message.getBody());
        logger.info("testSendMessage pass");
    }

    @AfterClass
    public void afterLoginPageTest() {
        firefoxDriver.close();
    }

}
