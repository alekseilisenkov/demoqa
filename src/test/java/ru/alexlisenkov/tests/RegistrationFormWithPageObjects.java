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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999666555");
        registrationPage.selectCalendar.setDate("15", "July", "2022");
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        registrationPage.typeAddress("Saint-Petersburg");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alexei Lisenkov"), text("alexlis@mail.ru"), text("Male"), text("8999666555"),
                text("Saint-Petersburg"), text("NCR Delhi"));
    }
}
