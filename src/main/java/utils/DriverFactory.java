package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static String browserName=Config.BROWSER;

    private static String driverLocation="src/main/resources/drivers/";

    public DriverFactory(){
        this.driver=getDriver();
    }

    public static WebDriver createDriver() {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--use-fake-ui-for-media-stream=1");
            options.addArguments("--disable-cache");
//            options.addArguments("headless");
//            options.addArguments("window-size=1200x600");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverLocation + "geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--use-fake-ui-for-media-stream=1");
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

        public static WebDriver getDriver () {
            if (driver == null) {
                createDriver();
            }
            return driver;
        }


        public static void closeDriver () {
            driver.close();
            driver.quit();
        }

    }


