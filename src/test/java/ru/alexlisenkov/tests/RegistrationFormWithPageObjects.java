package ru.alexlisenkov.tests;

import org.junit.jupiter.api.Test;
import ru.alexlisenkov.pages.RegistrationPage;

public class RegistrationFormWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void myFirstTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Alexei")
                .typeLastName("Lisenkov")
                .typeEmail("alexlis@mail.ru")
                .chooseGender("Male")
                .choosePhone("8999666555");
        registrationPage.selectCalendar.setDate("15", "July", "2022");
        registrationPage.chooseSience("Physics")
                .chooseHobbies("Sports")
                .chooseHobbies("Music")
                .chooseHobbies("Reading")
                .uploadPicture("img/1.png")
                .typeAddress("Saint-Petersburg");
        registrationPage.stateComponent.setState("NCR");
        registrationPage.cityComponent.setCity("Delhi");
        registrationPage.clickButton();

        registrationPage.finalAssert();
        registrationPage.finalAssertOfTable();
    }
}
