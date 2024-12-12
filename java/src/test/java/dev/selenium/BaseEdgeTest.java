package dev.selenium;

import org.junit.jupiter.api.BeforeEach;

public class BaseEdgeTest extends BaseTest {

  @BeforeEach
  public void setup() {
    startEdgeDriver();
  }
}
