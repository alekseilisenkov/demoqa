package ru.alexlisenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void myFirstTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Alexei");
        $("#lastName").setValue("Lisenkov");
        $("#userEmail").setValue("alexlis@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999666555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2022");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Saint-Petersburg");
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
