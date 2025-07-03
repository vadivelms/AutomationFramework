package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com/");
        SearchContext shadoRoot = driver.findElement(By.cssSelector("book-app[apptitle=\"BOOKS\"]")).getShadowRoot();
        shadoRoot.findElement(By.id("input")).sendKeys("Testing");

    }
}
