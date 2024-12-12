package dev.selenium.elements;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import dev.selenium.BaseFirefoxTest;

import org.openqa.selenium.WebElement;

class LocatorsTest extends BaseFirefoxTest {

    @Test
    void ByChainedTest() {
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        // Find username-field inside of login-form
        By example = new ByChained(By.id("login-form"), By.id("username-field"));
        WebElement username_input = driver.findElement(example);

        //return placeholder text
        String placeholder = username_input.getAttribute("placeholder");
        assertEquals("Username", placeholder);
    }
}
