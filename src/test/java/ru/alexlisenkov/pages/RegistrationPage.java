package ru.alexlisenkov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.alexlisenkov.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            currentAddress = $("#currentAddress");


    private final String formTitleText = "Student Registration Form";

    public CalendarComponent selectCalendar = new CalendarComponent();

    public void openPage(){
        open("/automation-practice-form");
        formTitle.shouldHave(text(formTitleText));
    }

    public void typeFirstName(String value){
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value){
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value){
        emailInput.setValue(value);
    }

    public void typeAddress(String value){
        currentAddress.setValue(value);
    }

}
