package gun04.progressbar;

import org.openqa.selenium.By;

public interface ILocators {

    String url = "https://demoqa.com/progress-bar";
    By lBody = By.xpath("//body");
    By lStartStopButton = By.id("startStopButton");
    By lResetButton = By.id("resetButton");
    By lProgressBar = By.cssSelector("#progressBar");
}
