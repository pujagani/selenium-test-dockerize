package dev.selenium;

import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class BaseChromeTest extends BaseTest {

  @BeforeEach
  public void setup() throws MalformedURLException {
    startChromeDriver("132");
  }
}
