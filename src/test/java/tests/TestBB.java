package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.Config;
import utils.DriverFactory;

import java.util.Random;

import static utils.Config.ITERATION;
import static utils.Config.NUMBEROFUSERS;


public class TestBB {

    public HomePage homePage;
//    public static final int ITERATION= 1;
//    public static final int NUMBEROFUSERS= 1;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        WebDriver driver=DriverFactory.getDriver();
        String baseUrl =Config.URL+"demo/demo1.jsp";
        driver.get(baseUrl);
    }

    @Test
    public void LoginuserTest() throws InterruptedException {
        homePage = new HomePage();
        int itr=ITERATION-1;
        for (int i=0; i < NUMBEROFUSERS; i++){
            homePage.loginMeeting( i, "Anonymous"+ itr + i );
        }
    }
//
//    public String randomString() {
//        int leftLimit = 97; // letter 'a'
//        int rightLimit = 122; // letter 'z'
//        int targetStringLength = 10;
//        Random random = new Random();
//
//        String generatedString = random.ints(leftLimit, rightLimit + 1)
//                .limit(targetStringLength)
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString();
//
//        return generatedString;
//    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
//        profilePage.ClickOnFollow();
//        DriverFactory.closeDriver();

    }

}
