package hillelTest;

import configuration.BaseClass;
import configuration.DriverFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CoachesPage;
import pages.Util;

import java.util.List;

public class TestMainPage extends BaseClass {
    static CoachesPage coachesPage;
    @BeforeClass
    public static void openPage(){
        driver.get("https://dnipro.ithillel.ua/");
        coachesPage= PageFactory.initElements(driver,CoachesPage.class);
    }

    @Test
    public void testTitle(){
        Assert.assertEquals(coachesPage.getTitleSmall(),"Вдосклюйся!");
    }
    @Test
    public void testItButton(){
        driver.get("https://ithillel.ua/courses/front-end-basic");
        Util.scrollToElementVisibilityOf(driver,new By.ByXPath("//ul[@class=\"coach-list coaches_list\"]"));
        List<WebElement> webElementList=driver.findElements(By.className("coach-list_item"));
        for (WebElement element : webElementList) {
            System.out.println(element.findElement(By.className("coach-card_name")).getText());
        }
    }
}
