import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class mts {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void PPG(){
        String fillingLocation = "Facility-A";
        String customer = "Rich Customer";
        int customerNumber = 007;
        String billingAddress = "avenue the5, ,NEW YORK, NY, US, 10011";
        String name = "John Joe";
        String addressLine1 = "66 Raton st.";
        String addressLine2 = "77 Boca st.";
        String city = "Boca Raton";
        String country = "United States";
        String contact = "John Joe";
        String state = "Florida";
        String zip = "20010";
        String contactNum ="2771444";

        open("https://devppgsupplyorderingportal.azurewebsites.net/");
        $(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav/div/mat-nav-list/mat-list-item[3]/div/a")).click();
        $($x("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-customer-list/div[3]/div/div[1]/mat-card/mat-card-footer/div/div[2]/mat-icon[1]")).click();
        $(By.id("mat-radio-2")).click();
        $(By.className("mat-button-wrapper")).click();
        $(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/div[1]/app-order-add/div/form/mat-horizontal-stepper/div[2]/div[2]/div[1]/div[2]/mat-form-field/div/div[1]/div/input")).setValue(fillingLocation);

        $(By.id("mat-input-4")).setValue(customer);
        $(By.id("mat-input-5")).setValue(String.valueOf(customerNumber));
        $(By.id("mat-input-6")).setValue(billingAddress);

        $(By.xpath("//*[@id=\"cdk-step-content-0-1\"]/div[1]/div[8]/button/span[1]")).click();
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[1]/mat-form-field/div/div[1]/div/input")).setValue(name);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[2]/mat-form-field/div/div[1]/div/input")).setValue(addressLine1);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[3]/mat-form-field/div/div[1]/div/input")).setValue(addressLine2);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[4]/mat-form-field/div/div[1]/div/input")).setValue(city);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[5]/mat-form-field/div/div[1]/div/app-state-form-control/div/input")).setValue(state);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[6]/mat-form-field/div/div[1]/div/app-country-form-control/div/input")).setValue(country);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[7]/mat-form-field/div/div[1]/div/input")).setValue(zip);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[8]/mat-form-field/div/div[1]/div/input")).setValue(contact);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-content/form/div/div[9]/mat-form-field/div/div[1]/div/input")).setValue(contactNum);
        $(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-shipping-address-add/mat-dialog-actions/button[1]")).click();









        //$("[name=building]").setValue(building).pressEnter();

        //$(".home-internet-connect-form-message").shouldHave(Condition.text("К сожалению, по указанному адресу нет возможности подключить пакетную услугу МТС."));

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
