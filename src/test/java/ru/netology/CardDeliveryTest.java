package ru.netology;




import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    LocalDate currentDate = LocalDate.now().plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String formattedCurrentDate = currentDate.format(formatter);

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Москва");
        $(byName("name")).val("Георгий Пупкин");
        $("[name='phone']").setValue("+79262122636");
        $x("//label[@data-test-id='agreement']").click();
        $(withText("Забронировать")).click();
        $(withText("Встреча успешно забронирована")).shouldBe(appear, Duration.ofSeconds(15));
    }
}
