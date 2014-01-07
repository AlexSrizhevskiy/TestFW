package data.framework;

import org.openqa.selenium.*;

public class ApplicationManager {
    private WebDriverHelper webDriverHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private WebDriver driver;
    private boolean acceptNextAlert = true;

    public ApplicationManager() {
        webDriverHelper = new WebDriverHelper();
        driver = webDriverHelper.getDriver();
        //groupHelper = new GroupHelper();
    }

    public void stop() {
        webDriverHelper.stop();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }


    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
