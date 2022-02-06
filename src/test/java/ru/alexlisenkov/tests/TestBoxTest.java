package ru.alexlisenkov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        //$("#addNewRecordButton").click();
        $("#firstName").setValue("Alexei");
        $("#lastName").setValue("Lisenkov");
        $("#userEmail").setValue("alexlis@mail.ru");


        $("#genterWrapper").$(byText("Male")).click(); //наиболее стабильный локатор с выбором родительского элемента
        //$(byText("Male")).click(); мой вариант
        //$("#gender-radio-1").parent().click(); альтернатива клика по родительскому элементу

        $("#userNumber").setValue("8999666555");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("2022");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
//        $$(".react-datepicker__day--006").filter(not(cssClass("react-datepicker__day--outside-month")))
//        .first().click(); //альтернатива с использованием массива элементов

//        react-datepicker__day react-datepicker__day--006 react-datepicker__day--today react-datepicker__day--weekend
//        react-datepicker__day react-datepicker__day--008 react-datepicker__day--outside-month



//       $("[aria-label=\"Choose Sunday, February 6th, 2022\"]").click(); //альтернатива для календаря
//       $x("//*[@aria-label=\"Choose Sunday, February 6th, 2022\"]").click(); //альтернатива для календаря xPath
//       $x("//div[contains(@aria-label, \"Choose Sunday, February 6th, 2022\")]").click(); //альтернатива календаря xPath 2
//       aria-label="Choose Sunday, February 6th, 2022"

        $("#subjectsInput").setValue("Physics").pressEnter();
//        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png");  //менее лаконичная альтернатива  (требует доработки)

        $("#currentAddress").setValue("Saint-Petersburg");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();



        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alexei Lisenkov"), text("alexlis@mail.ru"), text("Male"), text("8999666555"),
                text("Saint-Petersburg"), text("NCR Delhi"));  //грубый вариант

//        $(".table-responsive").$(byText("Student Name")).shouldHave(text("Alexei Lisenkov")); //более гибкий и правильный вариант
//        $x("//td[text()='Student Name']").parent().shouldHave(text("Alexei Lisenkov"));



    }


//    @Test
//    void borderColorTest() {
//        open("/automation-practice-form");
//        $("#submit").click();
//        $("#firstName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
//    }

}
