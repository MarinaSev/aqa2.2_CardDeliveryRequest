package ru.netology.web;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;

public class RequestFormTest {

    //получаем теущую дату и прибавляем к ней 3 дня, переводим в строку

    @Test
    public void shouldSendForm(){
        open("http://localhost:9999");
        $(".input__control[placeholder='Город']").setValue("Киров");
        $(".input__control[placeholder='Дата встречи']").shouldHave (exactValue("27.11.2021"));
        $(".input__control[name='name']").setValue("Иван Иванов");
        $(".input__control[name='phone']").setValue("+78889996633");
        $(".checkbox__box").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(appear, Duration.ofSeconds(15));
    }
}
