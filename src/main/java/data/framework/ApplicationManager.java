package data.framework;

import org.openqa.selenium.*;

public class ApplicationManager {
	private NavigationHelper helper;
    private WebDriverHelper webDriverHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private WebDriver driver;
    private boolean acceptNextAlert = true;

    public ApplicationManager() {
        webDriverHelper = new WebDriverHelper();
        driver = webDriverHelper.getDriver();
    }

    public void stop() {
        webDriverHelper.stop();
    }

    public GroupHelper getGroupHelper() {
		if (groupHelper == null){
			groupHelper = new GroupHelper();
		}
        return groupHelper;
    }


    public ContactHelper getContactHelper() {
		if (contactHelper == null){
			contactHelper = new ContactHelper();
		}
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
