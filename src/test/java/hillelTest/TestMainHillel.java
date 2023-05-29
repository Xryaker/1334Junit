package hillelTest;

import configuration.BaseClass;

import static junit.framework.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.HillelPage;


public class TestMainHillel extends BaseClass {
    static HillelPage hillelPage = null;

    @BeforeClass
    public static void startSite() {
        driver.get("https://dnipro.ithillel.ua/");
        //  hillelPage= new HillelPage(driver);
        hillelPage = new HillelPage(driver);
    }

    @After
    public void beforeTests() {
        if (!driver.getCurrentUrl().equals("https://dnipro.ithillel.ua/")) {
            driver.navigate().to("https://dnipro.ithillel.ua/");
        }
    }

    @Test
    public void test3() {
        hillelPage.getCunsultButton().click();
        assertEquals("https://dnipro.ithillel.ua/#consultation", driver.getCurrentUrl());

    }

    @Test
    public void test2() {
        hillelPage.openJavaUsingButtons();
        assertEquals("https://dnipro.ithillel.ua/courses/java-pro", driver.getCurrentUrl());
    }

    @Test
    public void test1() {
        hillelPage.clickToBecomeCoach();
        assertTrue(driver.findElement(By.id("form-become-coach")).isEnabled());
        driver.navigate().back();
    }
    @Test
    public void test4(){
        assertEquals("jhgkjkj",hillelPage.getTitle());
    }
}
