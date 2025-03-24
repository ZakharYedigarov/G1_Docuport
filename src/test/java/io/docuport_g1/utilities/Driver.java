package io.docuport_g1.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    Creating the private constructor so this class's object is not reachable from outside
     */

    private Driver(){}

    /*
    making driver instance private
    static - run before everything else and use in static method
     */

    // private static WebDriver driver;
    // implement threadLocal ro achieve multi thread locally
    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    reusable method that will return the same driver instance everytime called
     */

    /**
     * singleton pattern
     * @return
     */
    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "safari":
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new"); // use "--headless=new" for newer versions
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-gpu"); // optional, useful in CI environments
                    options.addArguments("--remote-allow-origins=*"); // optional for CORS errors

                    WebDriver driver = new ChromeDriver(options);
                    break;

            }

        }
        return driverPool.get();
    }

    /**
     * closing driver
     * @author nsh
     */
    public static void closeDriver(){
        if(driverPool.get()!=null){
            driverPool.get().quit();
            //driver=null;
            driverPool.remove();
        }
    }
}
