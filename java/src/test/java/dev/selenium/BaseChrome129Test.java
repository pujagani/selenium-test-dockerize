package dev.selenium;

import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class BaseChrome129Test extends BaseTest {

  @BeforeEach
  public void setup() throws MalformedURLException {
    startChromeDriver("129");
  }
}
