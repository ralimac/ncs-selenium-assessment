package com.aus.ncs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://d3ovkzfkbrwp1z.cloudfront.net/#/");


    }

    @Test
    public void loginPage(){


        //Click login button
//        WebElement toolbarElement = driver.findElement(By.className("v-app-bar"));
//        WebElement loginElement = toolbarElement.findElement(By.className("v-toolbar__content"));
//        loginElement.findElement(By.className("nav-login-signup"));
//
//        driver.findElements(By.cssSelector("div a.v-size--default"));

//        for(WebElement e : driver.findElements(By.className("v-toolbar__content"))){
//            System.out.println(e.findElement(By.className("nav-login-signup")).getText());
//            if(e.findElement(By.className("nav-login-signup")).getText().equalsIgnoreCase("person"))
//            {
//                e.click();
//            }
//        }
//        List<WebElement> toolBarList = driver.findElements(By.className("v-toolbar__content"));
//        for(WebElement e:toolBarList){
//            if(e.findElement(By.cssSelector("[aria-label=login or signup]")).isDisplayed()){
//                e.click();
//
//            }
//        }

        driver.findElement(By.xpath("//div/a[@class=\"nav-login-signup v-btn v-btn--text theme--light v-size--default\"]")).click();


        //Type Username
        driver.findElement(By.id("gen-20230630-username")).sendKeys("bob");
        //Type password
        driver.findElement(By.id("gen-20230630-password")).sendKeys("ilovepizza");
        //Click Login
        driver.findElement(By.cssSelector("[aria-label=login]")).click();

        //Verify Welcome Bob
        driver.findElement(By.xpath("//i[@class=\"v-icon notranslate material-icons theme--light green--text text--darken-2\"]")).click();
        WebElement h2 = driver.findElement(By.tagName("h2"));
        String welcome = h2.getText();
        System.out.println(h2.getText());
        //assertEquals("Welcome bob", welcome);
        String url = driver.getCurrentUrl();
        //Click profile
        driver.findElement(By.xpath("//i[@class=\"v-icon notranslate material-icons theme--light green--text text--darken-2\"]")).click();
        //click logout
        driver.findElement(By.cssSelector("[role=menu]")).click();
        //click yes
        driver.findElement(By.cssSelector("[aria-label=yes]")).click();
        //Navigate to homepage
        driver.navigate().to(url);

        //Assert homepage
        assertEquals("Welcome to NCSPizza", driver.findElement(By.tagName("h1")).getText());


    }

    @Test
    public void OrderCountSubTotal(){

        //Click menu
    driver.findElement(By.xpath("//a[@class=\"v-btn v-btn--router v-btn--text theme--light v-size--default\"][1]")).click();
    List<WebElement> menuList = driver.findElements(By.className("v-slide-group__wrapper"));
    //driver.findElement(By.xpath("//div[@class=\"v-tab\"][2]"));
    for (WebElement e : menuList){
        System.out.println(e.getText());
        if(e.findElement(By.cssSelector("aria-selected=true")).getText().equalsIgnoreCase("Drinks")){
            e.click();
        }
    }

    }

    @AfterEach
    public void clean(){
        //driver.quit();
    }

    private WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
