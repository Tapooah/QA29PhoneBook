package application;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("a[href='/login']"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
        pause(1000);
    }

    public boolean isLoggedRegistered() {
        String res = wd.findElement(By.xpath("//button[normalize-space()='Sign Out']")).getText();
        return res.equals("Sign Out");
    }

    public void clickRegButton() {
        click(By.xpath("//button[normalize-space()='Registration']"));
    }

    public void clickLogButton() {
        click(By.xpath("//button[normalize-space()='Login']"));

    }

    public void clickContactsButton() {
        click(By.xpath("//a[normalize-space()='CONTACTS']"));
    }

    public void clickOnContactCard() {

        click(By.cssSelector("div[class='contact-page_leftdiv__yhyke'] div div:nth-child(1)"));
    }

    public void clickRemoveButton() {

        click(By.xpath("//button[normalize-space()='Remove']"));
        pause(1000);
    }

    public boolean isLogOutPresent() {
        pause(1000);

        return isElementPresent(By.xpath("//button[normalize-space()='Sign Out']"));
    }

    public void logout() {

        click(By.xpath("//button[normalize-space()='Sign Out']"));
    }


    public boolean isAlertPresent() {

//        try {
//            Alert alert = (new WebDriverWait(wd, 30)).until(ExpectedConditions.alertIsPresent());
//            wd.switchTo().alert();
////            pause(2000);
//            alert.dismiss();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
        Alert alert = (new WebDriverWait(wd, 30)).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }

    public void removeAll() {

        for (int i = wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size(); i > 0; i--) {
            clickOnContactCard();
            clickRemoveButton();
            pause(1000);
        }
    }
}