package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//proxy server acts as intermediary for requests between
//a client and a server
//Capture network traffic
//Mock backend calls made by the website
//Access a website under corporate restrictions/policies
//charles proxy.com
public class ProxyDemo {
    public static void main(String[] args) {

        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
       // proxy.setHttpProxy("localhost:8080");
        proxy.setSslProxy("localhost:8080");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("proxy",proxy);
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https:/google.com");
        driver.quit();
    }
}
