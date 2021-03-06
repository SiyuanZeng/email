package com.epam.preprod.firefox.model;

import com.epam.preprod.firefox.pages.DraftsPage;
import com.epam.preprod.firefox.pages.InboxPage;
import com.epam.preprod.firefox.pages.LoginPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
    private String sURL_LOGIN_PAGE = "http://www.hotmail.com/";
    private String EMAIL = "abuizeng@gmail.com";
    private String sEMAIL = "siyuanzeng@hotmail.com";
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
    private String sURL_DRAFTS_PAGE = "https://onedrive.live.com";
    private String ssssURL_DRAFTS_PAGE = "https://us-west-2.console.aws.amazon.com/ec2/v2/home?region=us-west-2#Instances:sort=instanceId";
    private String ssURL_DRAFTS_PAGE = "https://www.amazon.com/ap/signin?openid.assoc_handle=aws&openid.return_to=https%3A%2F%2Fsignin.aws.amazon.com%2Foauth%3Fresponse_type%3Dcode%26client_id%3Darn%253Aaws%253Aiam%253A%253A015428540659%253Auser%252Fawssignupportal%26redirect_uri%3Dhttps%253A%252F%252Fportal.aws.amazon.com%252Fbilling%252Fsignup%253Fredirect_url%253Dhttps%25253A%25252F%25252Faws.amazon.com%25252Fregistration-confirmation%2526state%253DhashArgs%252523%2526isauthcode%253Dtrue%26noAuthCookie%3Dtrue&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&action=&disableCorpSignUp=&clientContext=&marketPlaceId=&poolName=&authCookies=&pageId=aws.ssop&siteState=pre-register%2Cen_US&accountStatusPolicy=P1&sso=&openid.pape.preferred_auth_policies=MultifactorPhysical&openid.pape.max_auth_age=120&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&server=%2Fap%2Fsignin%3Fie%3DUTF8&accountPoolAlias=&forceMobileApp=0&language=en_US&forceMobileLayout=0";

    public class PreferenceTest {
        public Preferences prefs;

        public void setPreference() {
            // This will define a node in which the preferences can be stored
            prefs = Preferences.userRoot().node(this.getClass().getName());
            String ID1 = "abuizeng@gmail.com";
            String ID2 = "siyuanzeng@hotmail.com";
            String ID3 = "siyuanzeng@gmail.com";
            String ID4 = "github";
            String ID5 = "github";

            // First we will get the values
            // Define a boolean value
//            //System.out.println(prefs.getBoolean(ID1, true));
//             Define a string with default "Hello World
//            //System.out.println(prefs.get(ID2, "Hello World"));
//             Define a integer with default 50
//            //System.out.println(prefs.getInt(ID3, 50));

            // now set the values
            // oh yea
            // oh yea

            // oh yea
            prefs.put(ID1, "");
            prefs.put(ID2, "");
            prefs.put(ID3, "");
            prefs.put(ID4, "");
            prefs.put(ID5, "");

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


    @Test(dependsOnMethods = {"testOpenLogin"})
    public void testNewMessagew() {
        System.setProperty("webdriver.gecko.driver",new File("geckodriver.exe").getAbsolutePath());
        PreferenceTest p = new PreferenceTest();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(sURL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(sEMAIL , p.prefs.get(sEMAIL , "error"));
        message = new Message(TO, SUBJECT, MESSAGE);

        loginPage = loginPage.emailsInput(user.getLogin());
        inboxPage = loginPage.passwordInputs(user.getPassword());
        firefoxDriver.get(sURL_DRAFTS_PAGE);

    }

    @Test(dependsOnMethods = {"testOpenLogin"})
    public void atestNewMessagew() {
        System.setProperty("webdriver.gecko.driver",new File("geckodriver.exe").getAbsolutePath());
        PreferenceTest p = new PreferenceTest();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(sURL_LOGIN_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(sEMAIL , p.prefs.get(sEMAIL , "error"));
        message = new Message(TO, SUBJECT, MESSAGE);

        loginPage = loginPage.emailsInput(user.getLogin());
        inboxPage = loginPage.passwordInputs(user.getPassword());
//        firefoxDriver.get(sURL_DRAFTS_PAGE);

    }

    @Test(dependsOnMethods = {"testOpenLogin"})
    public void stestNewMessagew() {
        System.setProperty("webdriver.gecko.driver",new File("geckodriver.exe").getAbsolutePath());
        PreferenceTest p = new PreferenceTest();
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get(ssURL_DRAFTS_PAGE);
        loginPage = new LoginPage(firefoxDriver);
        user = new User(sEMAIL , p.prefs.get(sEMAIL , "error"));
        message = new Message(TO, SUBJECT, MESSAGE);

        loginPage = loginPage.semailsInput(user.getLogin());
        inboxPage = loginPage.spasswordInputs(user.getPassword());
        firefoxDriver.get(ssssURL_DRAFTS_PAGE );

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

//    @AfterClass
//    public void afterLoginPageTest() {
//        firefoxDriver.close();
//    }

}
