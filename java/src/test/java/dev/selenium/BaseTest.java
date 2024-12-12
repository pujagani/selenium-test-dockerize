package dev.selenium;

import com.titusfortner.logging.ChromeDriverLogger;
import com.titusfortner.logging.GeckoDriverLogger;
import com.titusfortner.logging.SeleniumLogger;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class BaseTest {
  protected WebDriver driver;

  protected FirefoxDriver startFirefoxDriver() {
    return startFirefoxDriver(new FirefoxOptions());
  }

  protected FirefoxDriver startFirefoxDriver(FirefoxOptions options) {
    List<String> arguments = new LinkedList<>();
    arguments.add("--disable-gpu");
    arguments.add("--headless");
    arguments.add("--no-sandbox");
    options.addArguments(arguments);

    SeleniumLogger.enable();

    driver = new FirefoxDriver(options);
    return (FirefoxDriver) driver;
  }

  protected WebDriver startChromeDriver(String version) throws MalformedURLException {
    ChromeOptions options = new ChromeOptions();
    List<String> arguments = new LinkedList<>();
    arguments.add("--no-sandbox");
    arguments.add("--headless=new");
    arguments.add("--disable-dev-shm-usage");
    arguments.add("--remote-debugging-pipe");
    arguments.add("enable-automation");
    arguments.add("--disable-extensions");
    arguments.add("--disable-gpu-sandbox");
    arguments.add("--disable-gpu");
    arguments.add("--remote-allow-origins=*");

    options.addArguments(arguments);

    options.setBrowserVersion(version);

    SeleniumLogger.enable();

    return startChromeDriver(options);
  }

  protected WebDriver startChromeDriver(ChromeOptions options) {
    driver = new ChromeDriver(options);
    ChromeDriverLogger.enable().setLevel(ChromiumDriverLogLevel.INFO);
    SeleniumLogger.enable().setLevel(Level.INFO);
    return driver;
  }

  protected EdgeDriver startEdgeDriver() {
    EdgeOptions options = new EdgeOptions();

    List<String> arguments = new LinkedList<>();
    arguments.add("--no-sandbox");
    arguments.add("--headless=new");
    arguments.add("--disable-dev-shm-usage");
    arguments.add("--remote-debugging-pipe");
    arguments.add("enable-automation");
    arguments.add("--disable-extensions");
    arguments.add("--disable-gpu-sandbox");
    arguments.add("--disable-gpu");
    arguments.add("--remote-allow-origins=*");

    options.addArguments(arguments);
    SeleniumLogger.enable();
    return startEdgeDriver(options);
  }

  protected EdgeDriver startEdgeDriver(EdgeOptions options) {
    driver = new EdgeDriver(options);
    return (EdgeDriver) driver;
  }

  @AfterEach
  public void quit() {
    if (driver != null) {
      driver.quit();
    }
  }
}
