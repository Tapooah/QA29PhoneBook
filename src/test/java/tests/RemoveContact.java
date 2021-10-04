package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {
    @BeforeMethod
    public void precondition() {
        //login?
        User user = new User().withEmail("pablus_tester@telran.com").withPassword("Best_Tester123");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().clickLogButton();
        app.getUserHelper().clickContactsButton();
    }


    @Test
    public void removeOneContact() {
//if contact present?
        app.getContactHelper().checkAndAddContacts();
        int countBefore = app.getContactHelper().count();
        app.getUserHelper().clickOnContactCard();
        app.getUserHelper().clickRemoveButton();
        int countAfter = app.getContactHelper().count();
        Assert.assertEquals(countAfter, countBefore-1);
    }

    @Test
    public void removeAllContacts() {
        app.getContactHelper().checkAndAddContacts();
        app.getUserHelper().removeAll();
        int countAfter = app.getContactHelper().count();
        Assert.assertEquals(countAfter, 0);
    }


}
