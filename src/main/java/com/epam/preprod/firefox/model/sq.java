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

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

/**
 * Created by Oksana_Nytrebych on 5/24/2016.
 */
public class sq {


    static final Logger logger = LogManager.getLogger(sq.class);

    protected WebDriver firefoxDriver;
    private LoginPage loginPage;
    private String URL_LOGIN_PAGE = "http://www.gmail.com/";
    private String EMAIL = "abuizeng@gmail.com";
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

    public class PreferenceTest {
        public Preferences prefs;

        public void setPreference() {
            // This will define a node in which the preferences can be stored
            prefs = Preferences.userRoot().node(this.getClass().getName());
            String ID1 = "abuizeng@gmail.com";
            String ID2 = "siyuanzeng@hotmail.com";
            String ID3 = "siyuanzeng@gmail.com";

            // First we will get the values
            // Define a boolean value
//            System.out.println(prefs.getBoolean(ID1, true));
//             Define a string with default "Hello World
//            System.out.println(prefs.get(ID2, "Hello World"));
//             Define a integer with default 50
//            System.out.println(prefs.getInt(ID3, 50));

            // now set the values
            prefs.put(ID1, "d");
            prefs.put(ID2, "Hello Europa");
            prefs.putInt(ID3, 45);

            // Delete the preference settings for the first value
//            prefs.remove(ID1);

        }

        public PreferenceTest() {
            setPreference();
        }


        //        public static void main(String[] args) {
//            PreferenceTest test = new PreferenceTest();
//            test.setPreference();
//        }
    }


    @BeforeClass
    public void beforeLoginPageTest() {
        PreferenceTest p = new PreferenceTest();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(URL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(EMAIL, p.prefs.get(EMAIL, "error"));
        message = new Message(TO, SUBJECT, MESSAGE);
    }

    @Test
    public void testOpenLogin() {
        System.setProperty("webdriver.gecko.driver",new File("geckodriver.exe").getAbsolutePath());
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(URL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        PreferenceTest p = new PreferenceTest();

        user = new User(EMAIL, p.prefs.get(EMAIL, "error"));
        message = new Message(TO, SUBJECT, MESSAGE);
        loginPage = loginPage.emailInput(user.getLogin());
        inboxPage = loginPage.passwordInput(user.getPassword());
//        firefoxDriver.get(URL_INBOX_PAGE);
//        Assert.assertEquals(URL_INBOX_PAGE, firefoxDriver.getCurrentUrl());
//        logger.info("testOpenLogin pass");
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
