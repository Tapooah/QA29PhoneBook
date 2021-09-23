package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void positiveRegistrationTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User().withEmail("pablus_tester" + i + "@gmail.com").withPassword("Pablus_Tester" + i);

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().clickRegButton();

        Assert.assertTrue(app.getUserHelper().isLoggedRegistered());
    }
}
