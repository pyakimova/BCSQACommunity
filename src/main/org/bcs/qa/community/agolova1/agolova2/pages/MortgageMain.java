package agolova2.pages;

import com.codeborne.selenide.SelenideElement;

import jdk.jfr.Name;
import org.openqa.selenium.support.FindBy;


@Name("Ипотека Вторичное жилье")

public class MortgageMain extends CorePage{

    @Name("Быстрый переход: частным лицам")
    @FindBy(xpath="//div[@class=\"padding-slim\"]/*[contains(text(), \"Частным лицам\")]")
    private SelenideElement toPrivatePerson;

    @Name("Быстрый переход: ипотека")
    @FindBy(xpath="//div[@class=\"padding-slim\"]/*[contains(text(), \"Ипотека\")]")
    private SelenideElement toMortgage;

    @Name("Быстрый переход: вторичное жилье")
    @FindBy(xpath="//div[@class=\"padding-slim\"]/*[contains(text(), \"Вторичное жилье\")]")
    private SelenideElement toSecondaryHousing;

    @Name("Слайдер")
    @FindBy(xpath="//*[@class=\"owl-stage\"]")
    private SelenideElement slider;

    @Name("Слайдер: переключатель вправо")
    @FindBy(xpath="//div[@class=\"button-round button-round_right\"]")
    private SelenideElement switchRight;

    @Name("Слайдер: переключатель влево")
    @FindBy(xpath="//div[@class=\"button-round button-round_left\"]")
    private SelenideElement switchLeft;

    @Name("Слайдер: переключатель точка")
    @FindBy(xpath="//div[@class=\"owl-dots\"]/child::div[@class=\"owl-dot\"]")
    private SelenideElement switchDot;

    @Name("Кнопка оформления слайдера")
    @FindBy(xpath="//*[contains(text(), \"Оформить заявку\")]")
    private SelenideElement makeRequestButton;

    @Name("Панель входа в ЛК")
    @FindBy(xpath="//*[@class=\"margin-ex-slim-bottom\"]")
    private SelenideElement enterToPersonalArea;

    @Name("Картинка в блоке входа в ЛК")
    @FindBy(xpath="//*[@class=\"box-lk__img\"]")
    private SelenideElement imgPersonalArea;

    @Name("Текст в блоке входа в ЛК")
    @FindBy(xpath="//*[@class=\"box-lk__text\"]/child::p")
    private SelenideElement textPersonalArea;

    @Name("Вход в личный кабинет")
    @FindBy(xpath="//button[text()='Вход в личный кабинет']")
    private SelenideElement enterToPersonalAreaButton;

    @Name("Заголовок")
    @FindBy(xpath="//h1[text()='Ипотека на вторичное жилье в  ']")
    private SelenideElement headline;

    @Name("Текущий регион")
    @FindBy(xpath="//*[@class=\"current_region\"]")
    private SelenideElement currentRegion;

    @Name("Окно выбора региона")
    @FindBy(xpath="//*[@id=\"choose-city_True_False\"]")
    private SelenideElement chooseRegionWindow;

    @Name("Выбор жилья: новостройка")
    @FindBy(xpath="//*[contains(text(), \"Новостройка\")]")
    private SelenideElement chooseHousingNew;

    @Name("Выбор жилья: вторичное жилье")
    @FindBy(xpath="//*[ @aria-selected=\"true\" and @href =\"/personal/ipoteka/vtorichnoe-zhile/\"]")
    private SelenideElement chooseHousingSecond;

    @Name("Выбор жилья: рефинансирование")
    @FindBy(xpath="//a[@aria-selected=\"false\" and @href =\"/personal/ipoteka/refinansirovanie/\"]")
    private SelenideElement chooseHousingRefinance;

    @Name("Выбор жилья: другие программы")
    @FindBy(xpath="//button[contains(text(), \"Другие программы\")]")
    private SelenideElement chooseHousingotherPrograms;

    @Name("Блок калькулятора")
    @FindBy(xpath="//*[@data-model-name=\"ResaleProgram\"]")
    private SelenideElement calculatorBlock;

    @Name("Чек-бокс: площадь квартиры")
    @FindBy(xpath="//*[@id=\"title_for_programId_ResaleProgram_1\"]")
    private SelenideElement squareCheckBox;

    @Name("Чек-бокс: без подтверждения дохода")
    @FindBy(xpath="//*[@id=\"title_for_programId_ResaleProgram_2\"]")
    private SelenideElement noConfirmCheckBox;

    @Name("Чек-бокс: люди дела")
    @FindBy(xpath="//*[@id=\"title_for_clientTypeId_ResaleProgram_2\"]")
    private SelenideElement dealPeopleCheckBox;

    @Name("Чек-бокс: зарплатный клиент")
    @FindBy(xpath="//*[@id=\"title_for_clientTypeId_ResaleProgram_1\"]")
    private SelenideElement earnClientCheckBox;

    @Name("Инфо: площадь квартиры")
    @FindBy(xpath="//*[@id=\"title_for_programId_ResaleProgram_1\"]//following-sibling::span")
    private SelenideElement infoFlatSquare;

    @Name("Инфо: люди дела")
    @FindBy(xpath="//*[@id=\"title_for_clientTypeId_ResaleProgram_2\"]//following-sibling::span")
    private SelenideElement infoDealPeople;

    @Name("Заголовок поля стоимости")
    @FindBy(xpath="//label[contains(text(),\"Стоимость жилья\")]")
    private SelenideElement headlineAmount;

    @Name("Поле ввода стоимости")
    @FindBy(xpath="//input[@id=\"propertyPrice_ResaleProgram\"]")
    private SelenideElement AmountField;

    @Name("Заголовок поля ПВ")
    @FindBy(xpath="//label[contains(text(),\"Первоначальный взнос\")]")
    private SelenideElement headlineInitialFee;

    @Name("Поле ввода ПВ")
    @FindBy(xpath="//input[@id=\"downPayment_ResaleProgram\"]")
    private SelenideElement initialFeeField;

    @Name("Заголовок поля дохода")
    @FindBy(xpath="//label[contains(text(),\"Ежемесячный доход,\")]")
    private SelenideElement headlineIncome;

    @Name("Поле ввода дохода")
    @FindBy(xpath="//input[@id=\"monthlyIncome_ResaleProgram\"]")
    private SelenideElement headlineIncomeField;

    @Name("Чек-бокс: материнский капитал")
    @FindBy(xpath="//*[@for=\"maternialCapitalCheck_ResaleProgram\"]")
    private SelenideElement maternalCapitalCheckBox;

    @Name("Текст: пул ПВ")
    @FindBy(xpath="//*[@id=\"downPaymentHelper_ResaleProgram\"]")
    private SelenideElement initialFeeText;

    @Name("Кнопка Рассчитать")
    @FindBy(xpath="//*[@id=\"btCalculate_ResaleProgram\"]")
    private SelenideElement countButton;

    @Name("Сноска в калькуляторе")
    @FindBy(xpath="//*[contains(text(),\"Расчет является предварительным\")]")
    private SelenideElement calculatorFootNote;

    @Name("Инфо блок получения ипотеки")
    @FindBy(xpath="//*[@class=\"billboard billboard_margin-bottom-none\"]")
    private SelenideElement infoGettingMortgage;

    @Name("Инфо блок: оформление ипотеки")
    @FindBy(xpath="//*[@data-value=\"Оформление ипотеки\"]")
    private SelenideElement infoRegistrationMortgage;

    @Name("Инфо блок: условия ипотеки на вторичное жилье")
    @FindBy(xpath="//*[@data-value=\"Условия ипотеки на вторичное жилье\"]")
    private SelenideElement conditionSecondaryHousingMortgage;

    @Name("Инфо блок: условия ипотеки на жилые дома")
    @FindBy(xpath="//*[@data-value=\"Условия ипотеки на жилые дома\"]")
    private SelenideElement conditionSecondaryHouse;

    @Name("Инфо блок: способы погашения")
    @FindBy(xpath="//*[@data-value=\"Способы погашения\"]")
    private SelenideElement conditionPayment;

    @Name("Панель алгоритма получения ипотеки")
    @FindBy(xpath="//*[@class=\"billboard__panel padding-minor\"]")
    private SelenideElement stepMortgagePanel;

    @Name("Шаги алгоритма получения ипотеки")
    @FindBy(xpath="//*[@class=\"order-list order-list_steps\"]")
    private SelenideElement stepMortgage;

    @Name("Инфо блок: кнопка оформления заявки")
    @FindBy(xpath="//*[@class=\"button  button_red\" and contains(text(), \"Оформить заявку\")]")
    private SelenideElement infoBlockRegistreRequirement;

    @Name("Требования к заемщикам")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/trebovanija-k-zaemshhikam-vtorichnoe-zhiljo/\"]")
    private SelenideElement requirementsForBorrowers;

    @Name("Документы")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/documenty-vtorichnoe-zhiljo/\"]")
    private SelenideElement documentButton;

    @Name("Документы по выбранному жилью")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/documenty-na-vybrannoe-vtorichnoe-zhiljo/\"]")
    private SelenideElement documentChoseenHousingButton;

    @Name("Оценка жилья")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/katalog-nedvizhimosti/ocenka-zhilya/\"]")
    private SelenideElement hausingValuationButton;

    @Name("Страхование")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/informacija-dlja-zaemshhikov/strahovanie/\"]")
    private SelenideElement insuranceButton;

    @Name("Расходы на оформление")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/rashody-na-oformlenie/\"]")
    private SelenideElement clearanceСostsButton;

    @Name("Оформление договора и проведение сделки")
    @FindBy(xpath="//*[@href=\"/personal/ipoteka/oformlenie-dogovora-i-provedenie-sdelki/\"]")
    private SelenideElement registrationContractButton;

    @Name("Текст для кнопки подачи заявки")
    @FindBy(xpath="//div[@class=\"sms-block__text \"]/h3")
    private SelenideElement textRequestButton;

    @Name("Текст для кнопки подачи заявки (сроки)")
    @FindBy(xpath="//div[@class=\"sms-block__text \"]/p ")
    private SelenideElement textRequestTermButton;

}
