package gun04.progressbar;

import org.openqa.selenium.By;

public class ProgressBarLocators {

    public static final String url = "https://demoqa.com/progress-bar";
    public static final By lButtonStartStop = By.id("startStopButton");
    public static final By lButtonReset = By.id("resetButton");
    public static final By lButton = By.cssSelector("#progressBarContainer button");
    public static final By lProgressBar = By.cssSelector("div[role='progressbar']");


}
