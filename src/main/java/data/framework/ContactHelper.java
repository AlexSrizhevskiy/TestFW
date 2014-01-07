package data.framework;

import data.objects.ContactObjects;

public class ContactHelper {

    private NavigationHelper manager;

    public ContactHelper(NavigationHelper manager) {
        this.manager = manager;
    }

    public void createContact(ContactObjects contactObject) {
        manager.openAddNewContactPage();
        fillContactForm(contactObject);
        manager.clickByText("submit");
        manager.clickByLinkText("home");
    }

    public void fillContactForm(ContactObjects contactObject) {
        manager.inputValue("firstname", contactObject.firstName);
        manager.inputValue("lastname", contactObject.lastName);
        manager.inputValue("address", contactObject.address);
        manager.inputValue("home", contactObject.homeTelNum);
        manager.inputValue("mobile", contactObject.mobileTelNum);
        manager.inputValue("work", contactObject.workTelNum);
        manager.inputValue("email", contactObject.email);
        manager.inputValue("email2", contactObject.emailSecondary);
        manager.select("bday", "3");
        manager.select("bmonth", "February");
        manager.inputValue("byear", "1939");
        //new Select(findElementByName("new_group")).selectByVisibleText("12");
    }
}
