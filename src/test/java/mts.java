import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class mts {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void mtsTest1(){
        String street = "Ленина";
        String building = "101";

        open("https://e-burg.mts.ru/personal/dlya-doma/checkconnect/e-burg-city/3805553");
        $("[data-suggest-id=suggestMtsTvCity]").setValue("Нижний Тагил").pressEnter();
        $("[data-suggest-id=suggestStreet]").setValue(street).pressEnter();
        $("[name=building]").setValue(building).pressEnter();

        $(".home-internet-connect-form-message").shouldHave(Condition.text("К сожалению, по указанному адресу нет возможности подключить пакетную услугу МТС."));

    }

    @Test
    void mtsTest2(){

        String name = "John Doe";
        String phone = "9999999999";
        String comment = "Call me ASAP!";
        String city = "Екатеринбург";
        String street = "ул Мичурина";
        String building = "98";

        open("https://e-burg.mts.ru/personal/dlya-doma/checkconnect/e-burg-city/3805553");
        $("[name=userName]").setValue(name);
        $("[name=phone]").setValue(phone);
        $("[name=comment]").setValue(comment);
        $("[data-suggest-id=bottomSuggestMtsTvCity]").setValue(city);
        $("[data-suggest-id=bottomSuggestStreet]").setValue(street).pressEnter();
        $("[name=building]").setValue(building).pressTab().pressEnter();

        $(".home-internet-connect-form-message").shouldHave(Condition.text("Поздравляем! Ваш адрес подходит для подключения пакетной услуги МТС"));

        $(".checkbox__icon").doubleClick();
        $(".btn.btn_large.btn-loader").click();

        $(".section-box__title").shouldHave(Condition.text("Ваша заявка отправлена!"));




    }
}
