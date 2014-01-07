package data;


import data.objects.ContactObjects;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
    @Test
    public void validContactCanBeCreated()throws Exception{
        ContactObjects validContact = new ContactObjects("ziga", "Adolf", "HH", "123", "456", "789", "as@bg.fr", "rt@ju.ik");
        app.getContactHelper().createContact(validContact);
    }
}
