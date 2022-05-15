package ru.alexlisenkov.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.alexlisenkov.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormRefactorWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().streetAddress();
    String name = faker.name().firstName(),
            familyName = faker.name().lastName(),
            email = faker.internet().emailAddress();

    @Test
    void myFirstTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(name);
        registrationPage.typeLastName(familyName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(TestData.genderMale);
        registrationPage.choosePhone(phone);
        registrationPage.selectCalendar.setDate("15", "July", "2022");
        registrationPage.chooseSience(TestData.sincePhysics);
        registrationPage.chooseHobbies(TestData.hobbieOne);
        registrationPage.chooseHobbies(TestData.hobbieTwo);
        registrationPage.uploadPicture("img/1.png");
        registrationPage.typeAddress(address);
        registrationPage.stateComponent.setState("NCR");
        registrationPage.cityComponent.setCity("Delhi");
        registrationPage.clickButton();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(name + " " + familyName), text(email), text(TestData.genderMale), text(phone),
                text(address), text("NCR Delhi"));
    }
}
