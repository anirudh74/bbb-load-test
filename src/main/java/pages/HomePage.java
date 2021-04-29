package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;

import java.util.ArrayList;

import static utils.WebElementUtils.enterText;


public class HomePage extends BasePage{


    @FindBy(name = "username")
    private WebElement username;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement loginButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void entername(String name) {
        enterText(username, name);
    }

    public void clickLoginButton(){
        loginButton.click();

    }

    public void loginMeeting(int user, String name) throws InterruptedException {
        if(user>0){
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(user));
            driver.get(Config.URL+"/demo/demo1.jsp");
        }
        entername(name);
        clickLoginButton();
        WebDriverWait wait=new WebDriverWait(driver, 60);
        WebDriverWait wait1=new WebDriverWait(driver, 60);

        WebElement mic=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/div/div/span/button[2]/span[1]")));
        mic.click();
//        WebElement ok=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/div/span/button[1]/span[1]")));
//        ok.click();
//        Thread.sleep(45000);
    }
}
