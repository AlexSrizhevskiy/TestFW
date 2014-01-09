package data.framework;

import data.objects.ContactObjects;

public class ContactHelper {
    private NavigationHelper helper;

    public void createContact(ContactObjects contactObject) {
		helper = new NavigationHelper();
        helper.openAddNewContactPage();
        fillContactForm(contactObject);
        helper.clickByText("submit");
        helper.clickByLinkText("home");
    }

    public void fillContactForm(ContactObjects contactObject) {
        helper.inputValue("firstname", contactObject.firstName);
        helper.inputValue("lastname", contactObject.lastName);
        helper.inputValue("address", contactObject.address);
        helper.inputValue("home", contactObject.homeTelNum);
        helper.inputValue("mobile", contactObject.mobileTelNum);
        helper.inputValue("work", contactObject.workTelNum);
        helper.inputValue("email", contactObject.email);
        helper.inputValue("email2", contactObject.emailSecondary);
        helper.select("bday", "3");
        helper.select("bmonth", "February");
        helper.inputValue("byear", "1939");
        //new Select(findElementByName("new_group")).selectByVisibleText("12");
    }
}
