package com.tradesanta.tests;

import com.tradesanta.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class TradesantaTests extends TestBase {

    static final String BASE_URL = "https://tradesanta.com/ru/";

    @Test
    @DisplayName("Закрыть плашку с cookies policy")
    void cookieTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open(BASE_URL);
        });
        step("Закрыть плашку с cookies policy'", () -> {
            $("#allow_cookies_button").click();
        });
    }

    @Test
    @DisplayName("Проверка надписи на главной")
    void checkMainPageTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open(BASE_URL);
        });
        step("Проверить что есть надпись 'Автоматизированная торговля криптовалютой'", () -> {
            $(".position-relative").shouldHave(text("Автоматизированная торговля криптовалютой"));
        });
    }

    @Test
    @DisplayName("Перейти на вкладку 'О сервисе'")
    void aboutTabTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open(BASE_URL);
        });
        step("Перейти на вкладку 'О сервисе'", () -> {
            $(By.linkText("О сервисе")).click();
        });
        step("Проверить что есть надпись 'Что такое TradeSanta?'", () -> {
            $(".wysiwyg").shouldHave(text("Что такое TradeSanta?"));
        });
    }

    @Test
    @DisplayName("Незаполненные поля при регистрации")
    void tryRegistrationTest() {
        step("Открыть страницу регистрации", () -> {
            open(BASE_URL + "signup");
        });
        step("Нажать на кнопку 'Зарегистрироваться'", () -> {
            $(byName("signup-button")).click();
        });
        step("Корректная ошибка о пустом имени пользователя", () -> {
            $(".invalid-feedback", 0).shouldHave(text("Необходимо заполнить Username"));
        });
        step("Корректная ошибка о пустом Email", () -> {
            $(".invalid-feedback", 1).shouldHave(text("Необходимо заполнить Email"));
        });
        step("Корректная ошибка о пустом пароле", () -> {
            $(".invalid-feedback", 2).shouldHave(text("Необходимо заполнить Password"));
        });
    }

    @Test
    @DisplayName("Тайтл страницы содержит текст из хедера")
    void titleTest() {
        step("Open url 'https://tradesanta.com/ru'", () -> {
            open(BASE_URL);
        });
        step("Тайтл страницы содержит текст 'TradeSanta: Торговые боты для Binance, Huobi, Okex & Hitbtc'", () -> {
            String expectedTitle = "TradeSanta: Торговые боты для Binance, Huobi, Okex & Hitbtc";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Проверить что в консоли нет ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://tradesanta.com/ru'", () -> {
            open(BASE_URL);
        });
        step("Проверить что в консоли нет 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

}