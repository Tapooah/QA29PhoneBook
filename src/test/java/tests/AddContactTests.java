package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        User user = new User().withEmail("pablus_tester@telran.com").withPassword("Best_Tester123");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().clickLogButton();
    }

    //test
    @Test
    public void addNewContact() {
        //if number of contact <5
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        Contact contact = new Contact()
                .withName("Pablus" + i)
                .withLastName("Tester" + i)
                .withPhoneNumber("05" + i + i)
                .withEmail("pablus_tester" + i + "@telran.com")
                .withAddress("Menakhem Plaut St " + i)
                .withDescription("the best student");

        app.getContactHelper().initAddNewContact();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitButton();

        Assert.assertTrue(app.getContactHelper().isContactAdded());
    }


    @AfterMethod
    public void postCondition() {
        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }

    }
}
