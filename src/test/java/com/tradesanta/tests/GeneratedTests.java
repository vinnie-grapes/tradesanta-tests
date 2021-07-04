package com.tradesanta.tests;

import com.tradesanta.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @Description("tradesanta.com")
    @DisplayName("Проверка надписи на сайте")
    void checkMainPageTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open("https://tradesanta.com/ru");
        });

        step("Проверить что есть надпись 'Автоматизированная торговля криптовалютой'", () -> {
            $(".position-relative").shouldHave(text("Автоматизированная торговля криптовалютой"));
        });
    }

    @Test
    @Description("tradesanta.com")
    @DisplayName("Перейти на вкладку 'О сервисе'")
    void aboutTabTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open("https://tradesanta.com/ru");
        });
        step("Перейти на вкладку 'О сервисе'", () -> {
            $(By.linkText("О сервисе")).click();
        });
        step("Проверить что есть надпись 'Что такое TradeSanta?'", () -> {
            $(".wysiwyg").shouldHave(text("Что такое TradeSanta?"));
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://tradesanta.com/ru'", () ->
            open("https://tradesanta.com/ru"));

        step("Page title should have text 'TradeSanta: Торговые боты для Binance, Huobi, Okex & Hitbtc'", () -> {
            String expectedTitle = "TradeSanta: Торговые боты для Binance, Huobi, Okex & Hitbtc";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://tradesanta.com/ru'", () ->
            open("https://tradesanta.com/ru"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("tradesanta.com")
    @DisplayName("Перейти на вкладку 'О сервисе'")
    void cookieTest() {
        step("Open url https://tradesanta.com/ru", () -> {
            open("https://tradesanta.com/ru");
        });
        step("Проверить что есть надпись 'Что такое TradeSanta?'", () -> {
            $("#allow_cookies_button").click();
        });
    }

}