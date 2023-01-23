package ru.alexlisenkov.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "3840x2400";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
