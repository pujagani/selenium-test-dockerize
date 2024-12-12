package dev.selenium.elements;

import dev.selenium.BaseChromeTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InteractionTest extends BaseChromeTest {

    @Test
    void interactWithElements() {
    // Navigate to Url
    driver.get("https://www.selenium.dev/selenium/web/inputs.html");

    // Click on the element
    WebElement checkInput = driver.findElement(By.name("checkbox_input"));
    checkInput.click();
    Boolean isChecked = checkInput.isSelected();
    assertEquals(isChecked, false);
    }
}