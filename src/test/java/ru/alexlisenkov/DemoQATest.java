package ru.alexlisenkov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoQATest {

    @BeforeEach
    void beforeEach() {
        System.out.println("Before");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After");
    }

    @Test
    void firstTest() {
        System.out.println("I love you QA GURU");
    }
}
