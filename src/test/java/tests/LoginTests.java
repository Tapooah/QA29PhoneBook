package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void positiveLoginTest() {

        User user = new User().withEmail("pablus_tester@telran.com").withPassword("Best_Tester123");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().clickLogButton();

        Assert.assertTrue(app.getUserHelper().isLoggedRegistered());
    }

    @Test
    public void negativeLoginTestWrongPassword() {
        User user = new User().withEmail("pablus_tester@telran.com").withPassword("Best_Tester");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().clickLogButton();
//        app.getUserHelper().isAlertPresent();


        Assert.assertTrue(app.getUserHelper().isAlertPresent());
    }

}
