package ru.alexlisenkov.docs;

import static ru.alexlisenkov.utils.RandomUtils.getRandomMessage;
import static ru.alexlisenkov.utils.RandomUtils.getRandomString;

public class RandomExamples {

    public static void main(String[] args) {
        System.out.println(getRandomString(32));

        String randomMessage = getRandomMessage(32, 42);
        System.out.println(randomMessage);

    }
}
