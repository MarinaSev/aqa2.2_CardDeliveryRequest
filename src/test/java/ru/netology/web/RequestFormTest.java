package ru.netology.web;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;


public class RequestFormTest {
    private String meetingDay;

    @BeforeEach
    public void dateSetUp() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        meetingDay = dateFormat.format(calendar.getTime());
    }

    @Test
    public void shouldSendForm() {
        open("http://localhost:9999");
        $(".input__control[placeholder='Город']").setValue("Киров");
//        $(".input__control[placeholder='Дата встречи']").shouldHave(exactValue(meetingDay));
        $(".input__control[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE, meetingDay);
        $(".input__control[name='name']").setValue("Иванов Иван");
        $(".input__control[name='phone']").setValue("+78889996633");
        $(".checkbox__box").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(appear, Duration.ofSeconds(15));
//        $(".notification__content").getText().contains("Встреча успешно забронирована на ");
//        $(".notification__content").getText().contains(meetingDay);
    }
}
