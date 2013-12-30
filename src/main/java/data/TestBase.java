package data;

import objects.ContactObjects;
import objects.GroupObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestBase {
	private static WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public void createGroup(GroupObjects groupObject) {
		openMainPage();
		openGroupTab();
		createNewGroup();
		fillGroupForm(groupObject);
		submitGroupCreation();
		openGroupTab();
	}

	public void createContact(ContactObjects contactObject) {
		openMainPage();
		openAddNewContact();
		fillContactForm(contactObject);
		submitGroupCreation();

		//TODO change to click(variable);
		openGroupTab();
	}

	private void fillContactForm(ContactObjects contactObject) {
		inputValue("ziga", contactObject.firstName);
		inputValue("Adolf", contactObject.lastName);
		inputValue("HH", contactObject.address);
		inputValue("123", contactObject.homeTelNum);
		inputValue("456", contactObject.mobileTelNum);
		inputValue("789", contactObject.workTelNum);
		inputValue("as@bg.fr", contactObject.email);
		inputValue("rt@ju.ik", contactObject.emailSecondary);

		//TODO extract methods
		driver.get(baseUrl + "/addressbookv4.1.4/edit.php");
		driver.findElement(By.linkText("add new")).click();
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText("3");
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("February");
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys("1939");
		new Select(driver.findElement(By.name("new_group"))).selectByVisibleText("12");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("home")).click();
	}

	private void openAddNewContact() {
		driver.get(baseUrl + "/addressbookv4.1.4/edit.php");
	}

	public void submitGroupCreation() {
		findElementByName("submit").click();
	}

	public void fillGroupForm(GroupObjects groupObjects) {
		inputValue("group_name", groupObjects.nameGroup);
		inputValue("group_header", groupObjects.headerGroup);
		inputValue("group_footer", groupObjects.footerGroup);
	}

	public void inputValue(String locator, String value) {
		findElementByName(locator).clear();
		findElementByName(locator).sendKeys(value);
	}

	public void createNewGroup() {
		findElementByName("new").click();
	}

	public WebElement findElementByName(String elementName) {
		return driver.findElement(By.name(elementName));
	}

	public void openGroupTab() {
		driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
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
