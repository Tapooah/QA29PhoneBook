package application;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initAddNewContact() {
        pause(1000);//the response sometimes takes a long time. I guess this is because the server is asleep.
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
        pause(1000);
        click(By.cssSelector("div[class='add_form__2rsm2'] button b"));
    }

    public boolean isContactAdded() {
        return isElementPresent(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div//div[1]"));
    }

    public int count() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void checkAndAddContacts() {
        int count = count();

        if (count < 5) {
            for (int j = 0; j < 5 - count; j++) {

                int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

                Contact contact = new Contact()
                        .withName("Pablus" + i)
                        .withLastName("Tester" + i)
                        .withPhoneNumber("05" + i + i)
                        .withEmail("pablus_tester" + i + "@telran.com")
                        .withAddress("Menakhem Plaut St " + i)
                        .withDescription("the best student");

                initAddNewContact();
                fillContactForm(contact);
                submitButton();
            }
        }
    }
}
