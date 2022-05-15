package ru.alexlisenkov.pages;

import com.codeborne.selenide.SelenideElement;
import ru.alexlisenkov.pages.components.CalendarComponent;
import ru.alexlisenkov.pages.components.CityComponent;
import ru.alexlisenkov.pages.components.StateComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            genderButton = $("#genterWrapper"),
            hobbiesButton = $("#hobbiesWrapper"),
            inputPhone = $("#userNumber"),
            inputSience = $("#subjectsInput"),
            uploadPicturepath = $("#uploadPicture"),
            clickPath = $("#submit");


    private final String FORM_TITLE = "Student Registration Form";
    public CalendarComponent selectCalendar = new CalendarComponent();
    public StateComponent stateComponent = new StateComponent();
    public CityComponent cityComponent = new CityComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void typeAddress(String value) {
        currentAddress.setValue(value);
    }

    public void chooseGender(String value) {
        genderButton.$(byText(value)).click();
    }

    public void chooseHobbies(String value) {
        hobbiesButton.$(byText(value)).click();
    }

    public void choosePhone(String value) {
        inputPhone.setValue(value).click();
    }

    public void chooseSience(String value) {
        inputSience.setValue(value).pressEnter();
    }

    public void uploadPicture(String value) {
        uploadPicturepath.uploadFromClasspath(value);
    }

    public void clickButton() {
        clickPath.click();
    }
}
