package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HillelPage {
    private final String becomeSelector = "//button[@data-modal=\"become-coach\"]";

    static WebDriver driverInHillelPage;
    @FindBy(id = "btn-consultation-hero")
    private WebElement cunsultButton;
    @FindBy(xpath = "//button[@data-dropdown-trigger=\"coursesMenu\"]")
    private WebElement courseButton;
    @FindBy(xpath = "//button[@data-category=\"programming\"]")
    private WebElement programingButton;

    @FindBy(xpath = "//*[@id=\"block-203050\"]//a[@href=\"https://dnipro.ithillel.ua/courses/java-pro\"]/..")
    private WebElement javaProButton;
    @FindBy(xpath = "//*[@id=\"coursesMenuMainContent\"]//div[@class=\"subcats-nav\"]//button[@data-value=\"java\"]")
    private WebElement javaButton;
    @FindBy(xpath = becomeSelector)
    private WebElement becomeCoach;
    @FindBy(xpath = "//p[@class=\"section-content_descriptor\"]")
    WebElement title;

    public HillelPage(WebDriver driver) {
        driverInHillelPage = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getCourseButton() {
        return courseButton;
    }

    public WebElement getCunsultButton() {
        return cunsultButton;
    }

    public String getTitle() {
        return title.getText();
    }

    public void openJavaUsingButtons() {
        courseButton.click();
        programingButton.click();
        javaButton.click();
        javaProButton.click();

    }

    public void clickToBecomeCoach() {
        scrollToElementVisibilityOf(driverInHillelPage, By.xpath(becomeSelector));
        becomeCoach.click();
    }


    private static void scrollToElementVisibilityOf(WebDriver driver, By by) {//метод который скролит до элемента
        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean bool = false;


        while (!bool) {//цикл проверяет есть ли элемент, если не находит скролит до тех пор пока не найдет этот элемент
            try {
                driver.findElement(by);
                bool = true;
            } catch (Exception ignore) {
                js.executeScript("window.scrollBy(0,500)");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
