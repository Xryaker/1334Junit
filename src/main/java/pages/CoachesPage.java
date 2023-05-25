package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoachesPage {
    @FindBy(id = "btn-consultation-hero")
    private WebElement consultationButton;

    @FindBy(className = "section-content_descriptor")
    WebElement titleSmall;

    public void openConsultationScreen() {
        consultationButton.click();
    }

    public String getTitleSmall() {
        return titleSmall.getText();
    }


}
