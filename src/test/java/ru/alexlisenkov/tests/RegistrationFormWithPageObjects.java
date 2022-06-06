package ru.alexlisenkov.tests;

import org.junit.jupiter.api.Test;
import ru.alexlisenkov.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void myFirstTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Alexei");
        registrationPage.typeLastName("Lisenkov");
        registrationPage.typeEmail("alexlis@mail.ru");
        registrationPage.chooseGender("Male");
        registrationPage.choosePhone("8999666555");
        registrationPage.selectCalendar.setDate("15", "July", "2022");
        registrationPage.chooseSience("Physics");
        registrationPage.chooseHobbies("Sports");
        registrationPage.chooseHobbies("Music");
        registrationPage.chooseHobbies("Reading");
        registrationPage.uploadPicture("img/1.png");
        registrationPage.typeAddress("Saint-Petersburg");
        registrationPage.stateComponent.setState("NCR");
        registrationPage.cityComponent.setCity("Delhi");
        registrationPage.clickButton();

        registrationPage.finalAssert();
        registrationPage.finalAssertOfTable();
    }
}
