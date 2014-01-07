package data.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NavigationHelper {
    private WebDriverHelper webDriverHelper;
    private WebDriver driver;
    private String baseUrl = "http://localhost/";

    public NavigationHelper() {
        webDriverHelper = new WebDriverHelper();
        driver = webDriverHelper.getDriver();
    }

    public void openMainPage() {
        driver.get(baseUrl + "/addressbookv4.1.4/");
    }

    public void openGroupTab() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void clickByLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void select(String locator, String textForSelecting) {
        new Select(findElementByName(locator)).selectByVisibleText(textForSelecting);
    }

    public void openAddNewContactPage() {
        driver.get(baseUrl + "/addressbookv4.1.4/edit.php");
    }

    public void clickByText(String object) {
        findElementByName(object).click();
    }

    public void inputValue(String locator, String value) {
        findElementByName(locator).clear();
        findElementByName(locator).sendKeys(value);
    }

    public WebElement findElementByName(String elementName) {
        return driver.findElement(By.name(elementName));
    }

}
