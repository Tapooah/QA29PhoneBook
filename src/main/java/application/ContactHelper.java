package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddNewContact() {
        pause(5000);//the response sometimes takes a long time. I guess this is because the server is asleep.
        click(By.xpath("//a[normalize-space()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        pause(1000);
        type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        type(By.cssSelector("input[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("input[placeholder='Phone']"), contact.getPhoneNumber());
        type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"), contact.getDescription());
    }

    public void submitButton() {
        pause(2000);
        click(By.cssSelector("div[class='add_form__2rsm2'] button b"));
    }

    public boolean isContactAdded() {
        return isElementPresent(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]"));
    }
}
